package com.example.a15011027_bilgikayituygulamasi;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Kisi implements Parcelable {

    private String ad;
    private String soyad;
    private String tcNo;
    private String telefonNo;
    private String email;

    public Kisi() {
    }

    public Kisi(String ad, String soyad, String tcNo, String telefonNo, String email) {
        this.ad = ad;
        this.soyad = soyad;
        this.tcNo = tcNo;
        this.telefonNo = telefonNo;
        this.email = email;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(String telefonNo) {
        this.telefonNo = telefonNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ad);
        dest.writeString(this.soyad);
        dest.writeString(this.tcNo);
        dest.writeString(this.telefonNo);
        dest.writeString(this.email);
    }

    protected Kisi(Parcel in) {
        this.ad = in.readString();
        this.soyad = in.readString();
        this.tcNo = in.readString();
        this.telefonNo = in.readString();
        this.email = in.readString();
    }

    public static final Creator<Kisi> CREATOR = new Creator<Kisi>() {
        @Override
        public Kisi createFromParcel(Parcel source) {
            return new Kisi(source);
        }

        @Override
        public Kisi[] newArray(int size) {
            return new Kisi[size];
        }
    };
}
