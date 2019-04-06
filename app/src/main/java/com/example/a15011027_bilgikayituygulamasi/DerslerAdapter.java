package com.example.a15011027_bilgikayituygulamasi;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;

import org.w3c.dom.Text;

import java.util.List;

public class DerslerAdapter extends RecyclerView.Adapter<DerslerAdapter.MyViewHolder>{

    private List<Ders> dersler;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView not;
        public Button dersButton;

        public MyViewHolder(View view) {
            super(view);

            not = (TextView) view.findViewById(R.id.dersNotuText);
            dersButton = (Button) view.findViewById(R.id.dersAdıButton);
        }
    }

    public DerslerAdapter(List<Ders> dersler) {
        this.dersler = dersler;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ders_satiri, parent, false);
        return new MyViewHolder(itemView);
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        Ders ders = dersler.get(position);
        holder.dersButton.setText(ders.getAd());
        holder.not.setText(ders.getNotOrtalamasi());

        holder.dersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DersBilgileriActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return dersler.size();
    }

}
