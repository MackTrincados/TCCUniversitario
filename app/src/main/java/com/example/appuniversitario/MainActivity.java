package com.example.appuniversitario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private Button btnEntrar;
    private Button btnEqueceuSenha;
    private EditText txtEmail;
    private EditText txtSenha;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(MainActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        //Usuarios usuariosTeste = new Usuarios();
        //usuariosTeste.idUsuarios = UUID.randomUUID().toString();
        //usuariosTeste.nome = "Neymar";
       // usuariosTeste.email = "adultoney@gmail.com";
        //usuariosTeste.senha = "neyzika123";
       // databaseReference.child("Usuarios").child(usuariosTeste.idUsuarios).setValue(usuariosTeste);

        Button banCadastroMain = (Button) findViewById(R.id.btnCadastro);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnEqueceuSenha = (Button) findViewById(R.id.btnEsqSenha);
        txtEmail = (EditText) findViewById(R.id.txtEmailPerfil);
        txtSenha = (EditText) findViewById(R.id.txtSenha);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuarios usuarios = new Usuarios();
                usuarios.email = txtEmail.getText().toString();
                usuarios.senha = txtSenha.getText().toString();
            }
        });

        banCadastroMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = 0;
                try {
                    Intent telaCastro = new Intent(MainActivity.this, CadastroActivity.class);
                    startActivity(telaCastro);
                }
                catch (Exception ex)
                {
                    String ce = ex.toString();
                }

            }
        });
        btnEqueceuSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent telaEsqueceuSenha = new Intent(MainActivity.this, EsqueceuSenhaActivity.class);
                    startActivity(telaEsqueceuSenha);
                }
                catch (Exception ex)
                {
                    String ce = ex.toString();
                }

            }
        });
    }
}