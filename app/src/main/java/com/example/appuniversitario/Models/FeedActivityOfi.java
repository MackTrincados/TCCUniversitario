package com.example.appuniversitario.Models;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.res.Resources;
import android.os.Bundle;

import com.example.appuniversitario.Adapters.FeedAdapter;
import com.example.appuniversitario.R;

public class FeedActivityOfi extends AppCompatActivity {
    String s1[], s2[],s3[];
    int Images[] = {R.drawable.download,R.drawable.download2,R.drawable.download3,R.drawable.download4,R.drawable.download5};

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        recyclerView = findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.alunos);
        s2 = getResources().getStringArray(R.array.descricao);
        s3 = getResources().getStringArray(R.array.Materias2);

        FeedAdapter feedAdapter = new FeedAdapter(this,s1,s2,s3,Images);
        recyclerView.setAdapter(feedAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}