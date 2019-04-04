package com.example.a15011027_bilgikayituygulamasi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class KayitActivity extends AppCompatActivity {

    static final int PICK_IMAGE_REQUEST = 1;

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

        avatarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
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
                Kisi kisi = new Kisi();
                kisi.setAd(adEditText.getText().toString());
                kisi.setSoyad(soyadEditText.getText().toString());
                kisi.setTcNo(tcEditText.getText().toString());
                kisi.setTelefonNo(telefonEditText.getText().toString());
                kisi.setEmail(emailEditText.getText().toString());

                Intent intent = new Intent(KayitActivity.this, KisiBilgileriActivity.class);
                intent.putExtra("Kisi", kisi);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);

        avatarButton = (Button) findViewById(R.id.avatarButton);
        avatarImage = (ImageView) findViewById(R.id.avatarImage);

        Log.d("RESULT CODE: ", String.valueOf(resultCode));

        if (resultCode == PICK_IMAGE_REQUEST) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                avatarImage.setImageBitmap(selectedImage);
                avatarButton.setVisibility(View.GONE);
                avatarImage.setVisibility(View.VISIBLE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(KayitActivity.this, "Bir hata oluştu!", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(KayitActivity.this, "Resim seçmediniz!",Toast.LENGTH_SHORT).show();
        }
    }
}
