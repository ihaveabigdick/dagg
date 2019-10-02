package com.example.shen.hottohome.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Meals implements Parcelable {
    public int id = 1;
    public String name = "ji";
    public int price = 10;

    public Meals() {

    }

    public Meals(Parcel in) {
        id = in.readInt();
        name = in.readString();
        price = in.readInt();
    }

    public static final Creator<Meals> CREATOR = new Creator<Meals>() {
        @Override
        public Meals createFromParcel(Parcel in) {
            return new Meals(in);
        }

        @Override
        public Meals[] newArray(int size) {
            return new Meals[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeInt(price);
    }

}
