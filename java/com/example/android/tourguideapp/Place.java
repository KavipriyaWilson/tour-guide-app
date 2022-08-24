package com.example.android.tourguideapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Place implements Parcelable {
    private String placeName;
    private int placeImageResourceID;
    private String palaceDiscription;


    public Place(String placeName, int placeImageResourceID, String palaceDiscription) {
        this.placeName = placeName;
        this.placeImageResourceID = placeImageResourceID;
        this.palaceDiscription = palaceDiscription;
    }

    protected Place(Parcel in) {
        placeName = in.readString();
        placeImageResourceID = in.readInt();
        palaceDiscription = in.readString();
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    public String getPlaceName() {
        return placeName;
    }

    public int getPlaceImageResourceID() {
        return placeImageResourceID;
    }

    public String getPalaceDiscription() {
        return palaceDiscription;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setPlaceImageResourceID(int placeImageResourceID) {
        this.placeImageResourceID = placeImageResourceID;
    }


    public void setPalaceDiscription(String palaceDiscription) {
        this.palaceDiscription = palaceDiscription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(placeName);
        dest.writeInt(placeImageResourceID);
        dest.writeString(palaceDiscription);
    }
}