package com.example.appuniversitario.Models;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.appuniversitario.Adapters.FeedAdapter;
import com.example.appuniversitario.NotificacoesActivity;
import com.example.appuniversitario.PerfilActivity;
import com.example.appuniversitario.PerfilActivity2;
import com.example.appuniversitario.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class FeedActivityOfi extends AppCompatActivity {

    String s1[], s2[],s3[];
    int Images[] = {R.drawable.victor,R.drawable.paulo,R.drawable.leo,R.drawable.xandao,R.drawable.mothers};
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

        btnFotoFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PerfilActivity.class));
            }
        });

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {
                startActivity(new Intent(getApplicationContext(), PerfilActivity2.class));
            }

            @Override public void onLongItemClick(View view, int position) {
                // do whatever
            }
        }));

        btnNotificacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), NotificacoesActivity.class));
            }
        });
    }

}