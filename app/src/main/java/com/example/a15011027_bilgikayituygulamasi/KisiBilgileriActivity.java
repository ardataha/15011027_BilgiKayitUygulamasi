package com.example.a15011027_bilgikayituygulamasi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

public class KisiBilgileriActivity extends AppCompatActivity {

    TextView adSoyadText, tcText, telText, mailText;
    ImageView avatarImage;
    ImageButton telButton, mailButton;
    Button  notlarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisi_bilgileri);

        adSoyadText = (TextView) findViewById(R.id.adSoyadText);
        tcText = (TextView) findViewById(R.id.kisiTcText);
        telText = (TextView) findViewById(R.id.kisiTelText);
        mailText = (TextView) findViewById(R.id.kisiMailText);
        avatarImage = (ImageView) findViewById(R.id.kisiAvatarImage);
        notlarButton = (Button) findViewById(R.id.notlarButton);
        telButton = (ImageButton) findViewById(R.id.telefonButton);
        mailButton = (ImageButton) findViewById(R.id.mailButton);

        Intent intent = getIntent();
        Kisi kisi = intent.getParcelableExtra("Kisi");

        final String ad = kisi.getAd();
        final String soyad = kisi.getSoyad();
        final String tcNo = kisi.getTcNo();
        final String email = kisi.getEmail();
        final String telNo = kisi.getTelefonNo();
        final Uri avatarUri = kisi.getAvatar();

        adSoyadText.setText(ad + " " + soyad);
        tcText.setText(tcNo);
        telText.setText(telNo);
        mailText.setText(email);
        Glide.with(this)
                .load(avatarUri)
                    .into(avatarImage);

        mailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TO[] = {email, ""};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                startActivity(Intent.createChooser(emailIntent, "Mail gönder:"));
            }
        });

        telButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + telNo));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        notlarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KisiBilgileriActivity.this, DersListesiActivity.class);
                startActivity(intent);
            }
        });
    }
}
