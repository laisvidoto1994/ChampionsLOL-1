package com.android.joaocdecastilho.championslol;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.joaocdecastilho.championslol.models.Champion;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterChampionsPersonalizado extends BaseAdapter {

    private final List<Champion> champions;
    private final Activity atc;

    public AdapterChampionsPersonalizado(List<Champion> champions, Activity atc) {
        this.champions = champions;
        this.atc = atc;
    }

    @Override
    public int getCount() {
        return champions.size();
    }

    @Override
    public Object getItem(int position) {
        return champions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = atc.getLayoutInflater().inflate(R.layout.activity_itens_champions,parent,false);

        final Champion champion = champions.get(position);


        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        TextView txtName = (TextView)view.findViewById(R.id.txtName);
        TextView txtTitles = (TextView)view.findViewById(R.id.txtTitles);

        txtName.setText(champion.getName());
        txtTitles.setText(champion.getTitle());

        txtName.setOnClickListener(new View.OnClickListener(){
            public  void  onClick(View view){

                Intent intent = new Intent(atc.getApplicationContext(),detalheChampion.class);
                intent.putExtra("champions",champion);
                atc.startActivity(intent);
             }
        });

        txtTitles.setOnClickListener(new View.OnClickListener(){
            public  void  onClick(View view){

                Intent intent = new Intent(atc.getApplicationContext(),detalheChampion.class);
                intent.putExtra("champions",champion);
                atc.startActivity(intent);
            }
        });


        return view;
    }
}
