    package com.example.a15011027_bilgikayituygulamasi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {

    EditText kullaniciAdiEditText, sifreEditText;
    Button girisButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kullaniciAdiEditText = (EditText) findViewById(R.id.kullaniciAdiEditText);
        sifreEditText = (EditText) findViewById(R.id.sifreEditText);
        girisButton = (Button) findViewById(R.id.girisButton);

        girisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kullaniciAdi = kullaniciAdiEditText.getText().toString();
                String sifre = sifreEditText.getText().toString();

                if( (kullaniciAdi.equals("admin")) && (sifre.equals("password")) ) {
                    Intent intent = new Intent(MainActivity.this, KayitActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, R.string.yanlis_sifre_text, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
