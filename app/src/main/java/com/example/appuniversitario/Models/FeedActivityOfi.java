package com.example.appuniversitario.Models;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.appuniversitario.Adapters.FeedAdapter;
import com.example.appuniversitario.PerfilActivity;
import com.example.appuniversitario.PerfilActivity2;
import com.example.appuniversitario.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class FeedActivityOfi extends AppCompatActivity {
    String s1[], s2[],s3[];
    int Images[] = {R.drawable.download,R.drawable.download2,R.drawable.download3,R.drawable.download4,R.drawable.download5};
    //ImageView imageViewFeed ;
    TextView txtNomesFeed;
    private Button btnEntrarPerfil, btnBuscar, btnNotificacoes;
    private CircleImageView btnFotoFeed;


    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);
        recyclerView = findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.alunos);
        s2 = getResources().getStringArray(R.array.descricao);
        s3 = getResources().getStringArray(R.array.Materias2);

        FeedAdapter feedAdapter = new FeedAdapter(this,s1,s2,s3,Images);
        recyclerView.setAdapter(feedAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //imageViewFeed = (ImageView) findViewById(R.id.imageViewFeed);
        //btnBuscar = (Button) findViewById(R.id.btnAtualizarFeed);
        txtNomesFeed = (TextView) findViewById(R.id.txtNomesFeed);
        //btnEntrarPerfil = (Button) findViewById(R.id.btnEntrarPerfilFeeds);
        btnNotificacoes = (Button) findViewById(R.id.btnNotificacoesFeed);
        btnFotoFeed = (CircleImageView) findViewById(R.id.home_profile_image);

        /*Spinner staticSpinner = (Spinner) findViewById(R.id.spinnerFeed);
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.skill_array,
                        android.R.layout.simple_spinner_item);
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticSpinner.setAdapter(staticAdapter); */

       /* btnEntrarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PerfilActivity.class));
            }
        });

        */
        btnFotoFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PerfilActivity.class));
            }
        });

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PerfilActivity2.class));
            }
        });
        btnNotificacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), PerfilActivity2.class));
            }
        });



        //txtNomesFeed.setOnClickListener(new View.OnClickListener() {
        //    @Override
       //     public void onClick(View view) {
       //         startActivity(new Intent(getApplicationContext(), PerfilActivity2.class));
       //     }
        //});

    }

}