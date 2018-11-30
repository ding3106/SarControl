package com.motorola.sarcontrol;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;

import com.motorola.sarcontrol.IOnSarStatusChangedListener;
import com.motorola.sarcontrol.ISarStatusManager;
import com.motorola.sarcontrol.SarStatus;

import java.util.concurrent.atomic.AtomicBoolean;

public class SarStatusDebuggerService extends Service {

    private static final String TAG = "SarStatusDebuggerServic";
    public SarStatusDebuggerService() {
    }

    private static AtomicBoolean mIsServiceDestoryed = new AtomicBoolean(true);

    //Used to save current latest SarStatus.
    public static SarStatus currentSarStatus = new SarStatus();

    private static RemoteCallbackList<IOnSarStatusChangedListener> mListenerList = new RemoteCallbackList<>();

    private final ISarStatusManager.Stub mBinder = new ISarStatusManager.Stub() {
        @Override
        public SarStatus getSarStatus() throws RemoteException {

            Log.w(SarStatusDebuggerService.this.TAG, "getSarStatus: currentSarStatus = "+ currentSarStatus.toString() );
            return currentSarStatus;
        }


        @Override
        public void registerListener(IOnSarStatusChangedListener listener) throws RemoteException {
            if(mListenerList.register(listener)){
                Log.w(TAG, "registerListener: success");
            } else {
                Log.w(TAG, "registerListener: failed" );
            }


        }

        @Override
        public void unregisterListener(IOnSarStatusChangedListener listener) throws RemoteException {
            if(mListenerList.unregister(listener)){
                Log.w(TAG, "unregisterListener: success" );
            } else {
                Log.w(TAG, "unregisterListener: failed" );
            }
        }
    };


    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate() called");
        super.onCreate();
        mIsServiceDestoryed.set(false);

        //Used for test. To be deleted
        new Thread(new ServiceWork()).start();


    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind() called with: intent = [" + intent + "]");
        return mBinder;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy() called");
        mIsServiceDestoryed.set(true);
        super.onDestroy();
    }

    private static void onSarStatusChanged(SarStatus sarStatus){
        final int N = mListenerList.beginBroadcast();
        Log.w(TAG, "onPSarStatusChanged: N = " + N );
        for(int i = 0; i < N; i++){

            IOnSarStatusChangedListener listener = mListenerList.getBroadcastItem(i);
            if(listener != null){
                try {
                    listener.onSarStatusChanged(sarStatus);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

        }
        mListenerList.finishBroadcast();
    }

    //Used for test. To be deleted
    private class ServiceWork implements Runnable{

        @Override
        public void run() {

            //init the int array in SarStatus, used for test
            int[] mSensorState = {0,1,2,3,4,5};
            currentSarStatus.mSensorState = mSensorState;

            while (!mIsServiceDestoryed.get()){

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(currentSarStatus.mSensorState != null){
                    currentSarStatus.mSensorState[0] = currentSarStatus.mSensorState[0] + 1;
                }
                updateSarStatusDisplay(currentSarStatus);
            }
        }
    }

    public static void updateSarStatusDisplay(SarStatus sarStatus){
        if(mIsServiceDestoryed.get())
            return;//if SarStatusDebuggerService is not working, return
        onSarStatusChanged(sarStatus);
    }
}
