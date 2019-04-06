package com.example.a15011027_bilgikayituygulamasi;

import android.os.Parcel;
import android.os.Parcelable;

public class Ders implements Parcelable {

    private String ad;
    private int kredi;
    private String notOrtalamasi;
    private String dersiVeren;

    public Ders() {
    }

    public Ders(String ad, int kredi, String notOrtalamasi, String dersiVeren) {
        this.ad = ad;
        this.kredi = kredi;
        this.notOrtalamasi = notOrtalamasi;
        this.dersiVeren = dersiVeren;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getKredi() {
        return kredi;
    }

    public void setKredi(int ogrenciSayisi) {
        this.kredi = ogrenciSayisi;
    }

    public String getNotOrtalamasi() {
        return notOrtalamasi;
    }

    public void setNotOrtalamasi(String notOrtalamasi) {
        this.notOrtalamasi = notOrtalamasi;
    }

    public String getDersiVeren() {
        return dersiVeren;
    }

    public void setDersiVeren(String dersiVeren) {
        this.dersiVeren = dersiVeren;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.ad);
        dest.writeInt(this.kredi);
        dest.writeString(this.notOrtalamasi);
        dest.writeString(this.dersiVeren);
    }

    protected Ders(Parcel in) {
        this.ad = in.readString();
        this.kredi = in.readInt();
        this.notOrtalamasi = in.readString();
        this.dersiVeren = in.readString();
    }

    public static final Parcelable.Creator<Ders> CREATOR = new Parcelable.Creator<Ders>() {
        @Override
        public Ders createFromParcel(Parcel source) {
            return new Ders(source);
        }

        @Override
        public Ders[] newArray(int size) {
            return new Ders[size];
        }
    };
}
