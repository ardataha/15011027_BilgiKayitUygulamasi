package com.example.a15011027_bilgikayituygulamasi;

public class Ders {

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
}
