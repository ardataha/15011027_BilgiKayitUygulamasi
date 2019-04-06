package com.example.a15011027_bilgikayituygulamasi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class KayitActivity extends AppCompatActivity {

    private static int RESULT_LOAD_IMG = 1;

    ImageView avatarImage;
    Button kayitButton, temizleButton, avatarButton;
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
        avatarButton = (Button) findViewById(R.id.avatarButton);
        kayitButton = (Button) findViewById(R.id.kayitButton);
        temizleButton = (Button) findViewById(R.id.temizleButton);
        avatarImage = (ImageView) findViewById(R.id.avatarImage);

        avatarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
            }
        });

        temizleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adEditText.setText("");
                soyadEditText.setText("");
                tcEditText.setText("");
                telefonEditText.setText("");
                emailEditText.setText("");
            }
        });

        kayitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ad = adEditText.getText().toString();
                String soyad = soyadEditText.getText().toString();
                String tcNo = tcEditText.getText().toString();
                String telNo = telefonEditText.getText().toString();
                String email = emailEditText.getText().toString();

                if ( ad.matches("") || soyad.matches("") || tcNo.matches("") || telNo.matches("") || email.matches("")) {
                    Toast.makeText(KayitActivity.this, R.string.eksik_bilgi_text, Toast.LENGTH_SHORT).show();
                }
                else {
                    Kisi kisi = new Kisi();
                    kisi.setAd(ad);
                    kisi.setSoyad(soyad);
                    kisi.setTcNo(tcNo);
                    kisi.setTelefonNo(telNo);
                    kisi.setEmail(email);

                    Intent intent = new Intent(KayitActivity.this, KisiBilgileriActivity.class);
                    intent.putExtra("Kisi", kisi);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            final Uri imageUri = data.getData();
            Glide.with(this)
                    .load(imageUri)
                        .into(avatarImage);
            avatarButton.setVisibility(View.GONE);
            avatarImage.setVisibility(View.VISIBLE);
        }else {
            Toast.makeText(KayitActivity.this, "Bir avatar seçiniz!",Toast.LENGTH_SHORT).show();
        }
    }
}
