package com.alaske.mvp.rxjavamvp.mo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author: zhaocheng
 * Date: 2016-04-14
 * Time: 17:25
 * Name:UserMo
 * Introduction:
 */
public class UserMo implements Parcelable {

    public String name;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    public UserMo() {
    }

    protected UserMo(Parcel in) {
        this.name = in.readString();
    }

    public static final Parcelable.Creator<UserMo> CREATOR = new Parcelable.Creator<UserMo>() {
        @Override
        public UserMo createFromParcel(Parcel source) {
            return new UserMo(source);
        }

        @Override
        public UserMo[] newArray(int size) {
            return new UserMo[size];
        }
    };
}
