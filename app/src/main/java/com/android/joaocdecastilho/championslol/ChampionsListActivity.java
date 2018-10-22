package com.android.joaocdecastilho.championslol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.joaocdecastilho.championslol.models.Champion;
import com.android.joaocdecastilho.championslol.models.ChampionCatalog;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChampionsListActivity extends AppCompatActivity {

    private static final String TAG = "JCarlos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champions_list);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ChampionService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ChampionService service = retrofit.create(ChampionService.class);
        Call<List<Champion>> requestChampions = service.listChampion();

        requestChampions.enqueue(new Callback<List<Champion>>() {
            @Override
            public void onResponse(Call<List<Champion>> call, Response<List<Champion>> response) {
                if(!response.isSuccessful()) {
                    Log.i(TAG, "Erro: " + response.code());
                } else {
                    ListView listaDeChampions = (ListView) findViewById(R.id.lista);
                    List<Champion> champions = response.body();
                    ArrayAdapter<Champion> adapter = new ArrayAdapter<Champion>(ChampionsListActivity.this, R.layout.activity_champions_list, champions);
                    listaDeChampions.setAdapter(adapter);

                    for(Champion c : champions) {
                        Log.i(TAG, String.format("%s: %s", c.name, c.title));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Champion>> call, Throwable t) {
                Log.e(TAG, "Erro: " + t.getMessage());
            }
        });
    }
}
