package com.example.a15011027_bilgikayituygulamasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DersListesiActivity extends AppCompatActivity {

    public List<Ders> dersler = new ArrayList<>();
    private RecyclerView recyclerView;
    private DerslerAdapter derslerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ders_listesi);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        dersler.add(new Ders("Ağ Teknolojileri", 3, "CC", "Ali Gökhan YAVUZ"));
        dersler.add(new Ders("Mobil Programlamaya Giriş", 3, "AA", "M. Amaç GÜVENSAN"));
        dersler.add(new Ders("Veritabanı Sistemlerinin Gerçekleştirilmesi", 3, "CC", "Mustafa Utku KALAY"));
        dersler.add(new Ders("Biyoenformatiğe Giriş", 3, "BA", "Nizamettin AYDIN"));
        dersler.add(new Ders("Robot Teknolojisine Giriş", 3, "BB", "Sırma YAVUZ"));

        derslerAdapter = new DerslerAdapter(dersler);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(derslerAdapter);
    }
}
