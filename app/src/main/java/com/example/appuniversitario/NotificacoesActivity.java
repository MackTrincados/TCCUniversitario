package com.example.appuniversitario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.appuniversitario.Adapters.NotificacoesAdapter;

import java.util.ArrayList;
import java.util.List;

public class NotificacoesActivity extends AppCompatActivity {

    RecyclerView recyclerViewN;
    NotificacoesAdapter notificacoesAdapter;
    ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notificacoes);

        items = new ArrayList<>();
        items.add("Paulo");
        items.add("Marcos");
        items.add("Victor");
        items.add("João");
        items.add("Vinicius");
        items.add("Leonardo");
        items.add("Bruno");
        items.add("Eduardo");

        recyclerViewN = findViewById(R.id.recyclerViewN);
        recyclerViewN.setLayoutManager(new LinearLayoutManager(this));
        notificacoesAdapter = new NotificacoesAdapter(this, items);
        recyclerViewN.setAdapter(notificacoesAdapter);



    }
}