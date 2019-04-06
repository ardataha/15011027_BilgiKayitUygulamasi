package com.example.a15011027_bilgikayituygulamasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DersBilgileriActivity extends AppCompatActivity {

    TextView ad, veren, kredi, not;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ders_bilgileri);

        ad = (TextView) findViewById(R.id.dersAdiEditText);
        veren = (TextView) findViewById(R.id.dersVerenEditText);
        kredi = (TextView) findViewById(R.id.krediEditText);
        not = (TextView) findViewById(R.id.notEditText);

        Intent intent = getIntent();
        Ders ders = intent.getParcelableExtra("ders");

        ad.setText(ders.getAd());
        veren.setText(ders.getDersiVeren());
        kredi.setText(Integer.toString(ders.getKredi()));
        not.setText(ders.getNotOrtalamasi());
    }
}
