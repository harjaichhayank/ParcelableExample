package com.example.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

class Data implements Parcelable {
    private int imageView;
    private String text1;
    private String text2;

    Data(int imageView, String text1, String text2) {
        setImageView(imageView);
        setText1(text1);
        setText2(text2);
    }

    private Data(Parcel in) {
        imageView = in.readInt();
        text1 = in.readString();
        text2 = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    int getImageView() { return imageView; }
    String getText1() { return text1; }
    String getText2() { return text2; }

    private void setText1(String text1) { this.text1 = text1; }
    private void setImageView(int imageView) { this.imageView = imageView; }
    private void setText2(String text2) { this.text2 = text2; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageView);
        dest.writeString(text1);
        dest.writeString(text2);
    }
}
