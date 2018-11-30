package com.motorola.sarcontrol;

import android.os.Parcel;
import android.os.Parcelable;

public class SarStatus implements Parcelable {

    public boolean mChargerConnected;
    public boolean mEarPiece;
    public boolean mVoiceCall;
    public boolean mDataCall;
    public boolean mConnection;
    public boolean mWifi;
    public boolean mMifi;
    public boolean mWifiDirect;
    public boolean mAirPlaneMode;
    public boolean mRfCable;
    public boolean mOB5State;
    public boolean mTX0State;
    public boolean mPsensorNear;
    public boolean mHeadsetConnected;

    public int mSarState;
    public int mWifiCutbackUsed;
    public int mTunerState;
    public int mWifiBand;
    public int mMifiBand;
    public int mWifiTxPower;

    public int[] mSensorState = null;

    public SarStatus() {
    }


    public SarStatus(boolean mChargerConnected, boolean mEarPiece, boolean mVoiceCall,
                     boolean mDataCall, boolean mConnection, boolean mWifi, boolean mMifi,
                     boolean mWifiDirect, boolean mAirPlaneMode, boolean mRfCable,
                     boolean mOB5State, boolean mTX0State, boolean mPsensorNear,
                     boolean mHeadsetConnected, int mSarState, int mWifiCutbackUsed,
                     int mTunerState, int mWifiBand, int mMifiBand, int mWifiTxPower,int[] mSensorState) {
        this.mChargerConnected = mChargerConnected;
        this.mEarPiece = mEarPiece;
        this.mVoiceCall = mVoiceCall;
        this.mDataCall = mDataCall;
        this.mConnection = mConnection;
        this.mWifi = mWifi;
        this.mMifi = mMifi;
        this.mWifiDirect = mWifiDirect;
        this.mAirPlaneMode = mAirPlaneMode;
        this.mRfCable = mRfCable;
        this.mOB5State = mOB5State;
        this.mTX0State = mTX0State;
        this.mPsensorNear = mPsensorNear;
        this.mHeadsetConnected = mHeadsetConnected;
        this.mSarState = mSarState;
        this.mWifiCutbackUsed = mWifiCutbackUsed;
        this.mTunerState = mTunerState;
        this.mWifiBand = mWifiBand;
        this.mMifiBand = mMifiBand;
        this.mWifiTxPower = mWifiTxPower;
        this.mSensorState = mSensorState;
    }

    protected SarStatus(Parcel in) {

        mChargerConnected = in.readInt() == 1;
        mEarPiece = in.readInt() == 1;
        mVoiceCall = in.readInt() == 1;
        mDataCall = in.readInt() == 1;
        mConnection = in.readInt() == 1;
        mWifi = in.readInt() == 1;
        mMifi = in.readInt() == 1;
        mWifiDirect = in.readInt() == 1;
        mAirPlaneMode = in.readInt() == 1;
        mRfCable = in.readInt() == 1;
        mOB5State = in.readInt() == 1;
        mTX0State = in.readInt() == 1;
        mPsensorNear = in.readInt() == 1;
        mHeadsetConnected = in.readInt() == 1;

        mSarState = in.readInt();
        mWifiCutbackUsed = in.readInt();
        mTunerState = in.readInt();
        mWifiBand = in.readInt();
        mMifiBand = in.readInt();
        mWifiTxPower = in.readInt();

        int length = in.readInt();
        if(length > 0){
            mSensorState = new int[length];
            in.readIntArray(mSensorState);
        }
    }

    public static final Creator<SarStatus> CREATOR = new Creator<SarStatus>() {
        @Override
        public SarStatus createFromParcel(Parcel in) {
            return new SarStatus(in);
        }

        @Override
        public SarStatus[] newArray(int size) {
            return new SarStatus[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(mChargerConnected ? 1:0);
        parcel.writeInt(mEarPiece ? 1:0);
        parcel.writeInt(mVoiceCall ? 1:0);
        parcel.writeInt(mDataCall ? 1:0);
        parcel.writeInt(mConnection ? 1:0);
        parcel.writeInt(mWifi ? 1:0);
        parcel.writeInt(mMifi ? 1:0);
        parcel.writeInt(mWifiDirect ? 1:0);
        parcel.writeInt(mAirPlaneMode ? 1:0);
        parcel.writeInt(mRfCable ? 1:0);
        parcel.writeInt(mOB5State ? 1:0);
        parcel.writeInt(mTX0State ? 1:0);
        parcel.writeInt(mPsensorNear ? 1:0);
        parcel.writeInt(mHeadsetConnected ? 1:0);

        parcel.writeInt(mSarState);
        parcel.writeInt(mWifiCutbackUsed);
        parcel.writeInt(mTunerState);
        parcel.writeInt(mWifiBand);
        parcel.writeInt(mMifiBand);
        parcel.writeInt(mWifiTxPower);

        if(mSensorState == null){
            parcel.writeInt(0);
        } else {
            parcel.writeInt(mSensorState.length);
            parcel.writeIntArray(mSensorState);
        }

    }

    public boolean ismChargerConnected() {
        return mChargerConnected;
    }

    public void setmChargerConnected(boolean mChargerConnected) {
        this.mChargerConnected = mChargerConnected;
    }

    public boolean ismEarPiece() {
        return mEarPiece;
    }

    public void setmEarPiece(boolean mEarPiece) {
        this.mEarPiece = mEarPiece;
    }

    public boolean ismVoiceCall() {
        return mVoiceCall;
    }

    public void setmVoiceCall(boolean mVoiceCall) {
        this.mVoiceCall = mVoiceCall;
    }

    public boolean ismDataCall() {
        return mDataCall;
    }

    public void setmDataCall(boolean mDataCall) {
        this.mDataCall = mDataCall;
    }

    public boolean ismConnection() {
        return mConnection;
    }

    public void setmConnection(boolean mConnection) {
        this.mConnection = mConnection;
    }

    public boolean ismWifi() {
        return mWifi;
    }

    public void setmWifi(boolean mWifi) {
        this.mWifi = mWifi;
    }

    public boolean ismMifi() {
        return mMifi;
    }

    public void setmMifi(boolean mMifi) {
        this.mMifi = mMifi;
    }

    public boolean ismWifiDirect() {
        return mWifiDirect;
    }

    public void setmWifiDirect(boolean mWifiDirect) {
        this.mWifiDirect = mWifiDirect;
    }

    public boolean ismAirPlaneMode() {
        return mAirPlaneMode;
    }

    public void setmAirPlaneMode(boolean mAirPlaneMode) {
        this.mAirPlaneMode = mAirPlaneMode;
    }

    public boolean ismRfCable() {
        return mRfCable;
    }

    public void setmRfCable(boolean mRfCable) {
        this.mRfCable = mRfCable;
    }

    public boolean ismOB5State() {
        return mOB5State;
    }

    public void setmOB5State(boolean mOB5State) {
        this.mOB5State = mOB5State;
    }

    public boolean ismTX0State() {
        return mTX0State;
    }

    public void setmTX0State(boolean mTX0State) {
        this.mTX0State = mTX0State;
    }

    public boolean ismPsensorNear() {
        return mPsensorNear;
    }

    public void setmPsensorNear(boolean mPsensorNear) {
        this.mPsensorNear = mPsensorNear;
    }

    public boolean ismHeadsetConnected() {
        return mHeadsetConnected;
    }

    public void setmHeadsetConnected(boolean mHeadsetConnected) {
        this.mHeadsetConnected = mHeadsetConnected;
    }

    public int getmSarState() {
        return mSarState;
    }

    public void setmSarState(int mSarState) {
        this.mSarState = mSarState;
    }

    public int getmWifiCutbackUsed() {
        return mWifiCutbackUsed;
    }

    public void setmWifiCutbackUsed(int mWifiCutbackUsed) {
        this.mWifiCutbackUsed = mWifiCutbackUsed;
    }

    public int getmTunerState() {
        return mTunerState;
    }

    public void setmTunerState(int mTunerState) {
        this.mTunerState = mTunerState;
    }

    public int getmWifiBand() {
        return mWifiBand;
    }
    public void setmWifiBand(int mWifiBand) {
        this.mWifiBand = mWifiBand;
    }

    public int getmMifiBand() {
        return mMifiBand;
    }
    public void setmMifiBand(int mMifiBand) {
        this.mMifiBand = mMifiBand;
    }

    public int getmWifiTxPower() {
        return mWifiTxPower;
    }
    public void setmWifiTxPower(int mWifiTxPower) {
        this.mWifiTxPower = mWifiTxPower;
    }

    public int[] getmSensorState() {
        return mSensorState;
    }

    public void setmSensorState(int[] mSensorState) {
        this.mSensorState = mSensorState;
    }

    @Override
    public String toString() {
        StringBuilder string_mSensorState = new StringBuilder();

        if(mSensorState != null){
            for(int i =0; i < mSensorState.length; i++ ){
                string_mSensorState.append(mSensorState[i] +" ");
            }
        }
        String out =
                "[ mChargerConnected = " + mChargerConnected + ", mEarPiece = " + mEarPiece +
                        ", mVoiceCall = " + mVoiceCall + ", mDataCall = " + mDataCall +
                        ", mConnection = " + mConnection + ", mWifi = " + mWifi +
                        ", mMifi = " + mMifi + ", mWifiDirect = " + mWifiDirect +
                        ", mAirPlaneMode = " + mAirPlaneMode + ", mRfCable = " + mRfCable +
                        ", mOB5State = " + mOB5State + ", mTX0State = " + mTX0State +
                        ", mPsensorNear = " + mPsensorNear + ", mHeadsetConnected = " + mHeadsetConnected +
                        ", mSarState = " + mSarState + ", mWifiCutbackUsed = " + mWifiCutbackUsed +
                        ", mTunerState = " + mTunerState + ", mWifiBand = " + mWifiBand +
                        ", mMifiBand = " + mMifiBand + ", mWifiTxPower = " + mWifiTxPower +
                        ", mSensorState[] = [" + string_mSensorState +"], ]";
        return out;
    }

}
