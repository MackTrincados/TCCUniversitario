package com.example.appuniversitario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PerfilActivity extends AppCompatActivity {


    private TextView txtNome;
    private TextView txtSobre;
    private TextView txtEmail;
    private TextView txtCelular;
    private TextView txtSemestre;
    private TextView txtSexo;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
   // private TextView txtUniversidade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);



        txtNome = (TextView) findViewById(R.id.txtNomeUsuarioPerfil);
        txtSobre = (TextView) findViewById(R.id.txtSobreMimPerfil);
        txtEmail = (TextView) findViewById(R.id.txtEmailPerfil);
        txtCelular = (TextView) findViewById(R.id.txtCelularPerfil);
        txtSexo = (TextView) findViewById(R.id.txtSexoPerfil);
        txtSemestre = (TextView) findViewById(R.id.txtSemestrePerfil);
       // txtUniversidade = (TextView) findViewById(R.id.txt);




    }
}