// ISarStatusManager.aidl
package com.motorola.sarcontrol;

import com.motorola.sarcontrol.SarStatus;
import com.motorola.sarcontrol.IOnSarStatusChangedListener;
// Declare any non-default types here with import statements

interface ISarStatusManager {
    SarStatus getSarStatus();

    void registerListener(in IOnSarStatusChangedListener listener);
    void unregisterListener(in IOnSarStatusChangedListener listener);

}
