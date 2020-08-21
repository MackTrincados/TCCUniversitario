package com.example.appuniversitario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EsqueceuSenhaActivity extends AppCompatActivity {
    private Button btnEnviar;
    private EditText txtEmail;
    private EditText txtConfSenha;
    private EditText txtNovaSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.esqueceu_a_senha);
        btnEnviar = (Button) findViewById(R.id.btnEnviarEsqSenha);

        txtEmail = (EditText) findViewById(R.id.txtEmailEsqSenha);
        txtConfSenha = (EditText) findViewById(R.id.txtConfSenhaEsqSenha);
        txtNovaSenha = (EditText) findViewById(R.id.txtNovaSenhaEsqSenha);




    }
}