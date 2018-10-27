package com.android.joaocdecastilho.championslol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.joaocdecastilho.championslol.models.Champion;

public class detalheChampion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_champion);

        Intent intent = getIntent();


        TextView txtNameChampion = (TextView)findViewById(R.id.txtNameChampion);
        TextView txtTitleChampion = (TextView)findViewById(R.id.txtTitleChampion);
        TextView txtTagChampion = (TextView)findViewById(R.id.txtTagChampion);
        TextView txtDescriptionChampion = (TextView)findViewById(R.id.txtDescriptionChampion);

        Champion champion = (Champion)getIntent().getExtras().getSerializable("champions");

        txtNameChampion.setText(champion.getName());
        txtTitleChampion.setText(champion.getTitle());
        txtTagChampion.setText(champion.getHp());
        txtDescriptionChampion.setText(champion.getDescription());

    }
}
