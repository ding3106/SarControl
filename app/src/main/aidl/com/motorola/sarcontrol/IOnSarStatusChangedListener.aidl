// IOnSarStatusChangedListener.aidl
package com.motorola.sarcontrol;

import com.motorola.sarcontrol.SarStatus;

// Declare any non-default types here with import statements

interface IOnSarStatusChangedListener {

    void onSarStatusChanged(in SarStatus sarStatus);

}
