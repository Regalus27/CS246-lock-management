package com.example.schlageproject;

import android.util.Log;

import java.util.ArrayList;

public class Lock {
    // All of the Lock variables we care about.
    private final LockState _lockState; // Constants used to indicate the state of the device.
    private final LockBatteryState _lockBatteryState; // Potential set of values that can be assigned to battery state.
    private final String _modelName; // Human readable model name to present to users
    private final String _serialNumber; // Serial number of the device
    private final String _id; // Device unique identification - uuid
    private final String _name; // Device friendly name
    private final ArrayList<AccessCode> _accessCodes;

    private final String debugTag = "Lock";

    public Lock(LockState lockState, LockBatteryState lockBatteryState, String modelName, String serialNumber, String id, String name, ArrayList<AccessCode> accessCodes) {
        this._lockState = lockState;
        this._lockBatteryState = lockBatteryState;
        this._modelName = modelName;
        this._serialNumber = serialNumber;
        this._id = id;
        this._name = name;
        this._accessCodes = accessCodes;
    }

    public String getLockID() {
        return this._id;
    }

    public String getName() {
        // TODO: if name is null create a generic name such as "Unnamed Lock", either here or in constructor.
        return this._name;
    }

    public LockState getLockState() {
        return this._lockState;
    }

    public LockBatteryState getLockBatteryState() {
        return this._lockBatteryState;
    }

    public String getModelName() {
        return this._modelName;
    }

    public String getSerialNumber() {
        return this._serialNumber;
    }

    public ArrayList<AccessCode> getAccessCodes() {
        return this._accessCodes;
    }

    public void changeLockState(LockState lockState) {
        /* @param lockState: Desired LockState for this lock.
        * Check if lock is already in this state.
        * If not, call the appropriate
        * */
        switch (lockState) {
            case LOCKED:
                if(this.getLockState() != LockState.LOCKED) {
                    // Make API call to lock the lock.
                    Log.d(this.debugTag, "Lock is " + this.getLockState().toString() + ", making call to set state to " + lockState.toString());
                }
            case UNLOCKED:
                if(this.getLockState() != LockState.UNLOCKED) {
                    // Make API call to unlock the lock.
                    Log.d(this.debugTag, "Lock is " + this.getLockState().toString() + ", making call to set state to " + lockState.toString());
                }

            default:
                Log.d(this.debugTag, "Lock is " + this.getLockState().toString() + ", request to set state to " + lockState.toString() + " will be ignored");
        }
    }
}