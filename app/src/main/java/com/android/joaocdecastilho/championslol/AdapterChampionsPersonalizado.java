package com.android.joaocdecastilho.championslol;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.joaocdecastilho.championslol.models.Champion;

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
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = atc.getLayoutInflater().inflate(R.layout.activity_itens_champions,parent,false);

        Champion champion = champions.get(position);

        TextView txtName = (TextView)view.findViewById(R.id.txtName);
        TextView txtTitles = (TextView)view.findViewById(R.id.txtTitles);

        txtName.setText(champion.getName());
        txtTitles.setText(champion.getTitle());

        return view;
    }
}
