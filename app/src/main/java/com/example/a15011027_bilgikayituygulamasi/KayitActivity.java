package com.example.a15011027_bilgikayituygulamasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class KayitActivity extends AppCompatActivity {

    Button kayitButton;
    EditText adEditText, soyadEditText, tcEditText, telefonEditText, emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        adEditText = (EditText) findViewById(R.id.adEditText);
        soyadEditText = (EditText) findViewById(R.id.soyadEditText);
        tcEditText = (EditText) findViewById(R.id.tcEditText);
        telefonEditText = (EditText) findViewById(R.id.telefonEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        kayitButton = (Button) findViewById(R.id.kayitButton);

        kayitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kisi kisi = new Kisi();
                kisi.setAd(adEditText.getText().toString());
                kisi.setSoyad(soyadEditText.getText().toString());
                kisi.setTcNo(tcEditText.getText().toString());
                kisi.setTelefonNo(telefonEditText.getText().toString());
                kisi.setEmail(emailEditText.getText().toString());

                Intent intent = new Intent(KayitActivity.this, KisiBilgileriActivity.class);
                intent.putExtra("Kisi", kisi);
            }
        });
    }
}
