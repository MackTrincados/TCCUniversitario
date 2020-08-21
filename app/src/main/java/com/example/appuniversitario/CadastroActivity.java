package com.example.appuniversitario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class CadastroActivity extends AppCompatActivity {
    private Button btnCriarPerfil;
    private EditText txtEmail;
    private EditText txtSenha;
    private EditText txtNome;
    private EditText txtSobrenome;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);
        btnCriarPerfil = (Button) findViewById(R.id.btnCriarPerfilCadastro);

        txtEmail = (EditText) findViewById(R.id.txtEmailCadastro);
        txtNome = (EditText) findViewById(R.id.txtNomeCadastro);
        txtSobrenome = (EditText) findViewById(R.id.txtSobrenomeCadastro);
        txtSenha = (EditText) findViewById(R.id.txtSenhaCadastro);

        btnCriarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Usuarios usuarios = new Usuarios();
                //usuarios.email = txtEmail.text;
                //usuarios.senha = txtSenha.getText().toString();
                //usuarios.sobrenome = txtSobrenome.getText().toString();
                //usuarios.nome = txtNome.getText().toString();
                FirebaseApp.initializeApp(CadastroActivity.this);
                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference();
                Usuarios usuariosTeste = new Usuarios();
                usuariosTeste.idUsuarios = UUID.randomUUID().toString();
                usuariosTeste.nome = txtNome.getText().toString();
                usuariosTeste.email = txtEmail.getText().toString();
                usuariosTeste.senha = txtSenha.getText().toString();
                usuariosTeste.sobrenome = txtSobrenome.getText().toString();

                 databaseReference.child("Usuarios").child(usuariosTeste.idUsuarios).setValue(usuariosTeste);
                try {
                    Intent teaPeril = new Intent(CadastroActivity.this, PerfilActivity.class);
                    startActivity(teaPeril);
                }
                catch (Exception ex)
                {
                String erro = "-";
                }
                finish();
            }
        });


    }
}