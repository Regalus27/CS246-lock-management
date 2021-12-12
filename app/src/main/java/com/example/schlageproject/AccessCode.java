package com.example.schlageproject;

import android.os.Parcel;
import android.os.Parcelable;

public class AccessCode implements Parcelable {
    // private final AccessCodeScheduleType _scheduleType;
    // Stretch goal: Include start and end times for temporary and recurring codes
    private final String _accessCodeID;
    private final String _name;
    private final String _accessCode;

    public AccessCode(String name, String accessCode, String accessCodeID) {
        this._accessCode = accessCode;
        this._accessCodeID = accessCodeID;
        this._name = name;
    }

    protected AccessCode(Parcel in) {
        _accessCodeID = in.readString();
        _name = in.readString();
        _accessCode = in.readString();
    }

    public static final Creator<AccessCode> CREATOR = new Creator<AccessCode>() {
        @Override
        public AccessCode createFromParcel(Parcel in) {
            return new AccessCode(in);
        }

        @Override
        public AccessCode[] newArray(int size) {
            return new AccessCode[size];
        }
    };

    public String getAccessCode() {
        return this._accessCode;
    }

    public String getName() {
        return this._name;
    }

    public String getAccessCodeID() {
        return this._accessCodeID;
    }

    public int getAccessCodeLength() {
        return this._accessCode.length();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(_accessCodeID);
        dest.writeString(_name);
        dest.writeString(_accessCode);
    }
}
