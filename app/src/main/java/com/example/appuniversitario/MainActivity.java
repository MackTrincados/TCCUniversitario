package com.example.appuniversitario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private Button btnEntrar;
    private Button btnEqueceuSenha;
    private Button btnCadastro;
    private EditText txtEmail;
    private EditText txtSenha;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;


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

        //Button banCadastroMain = (Button) findViewById(R.id.btnCadastro);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnCadastro = (Button) findViewById(R.id.btnCadastro);
        btnEqueceuSenha = (Button) findViewById(R.id.btnEsqSenha);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString().trim();
                String senha = txtSenha.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    txtEmail.setError("Campo 'email' é requerido.");
                    return;
                }

                if(TextUtils.isEmpty(senha)){
                    txtSenha.setError("Campo 'senha' é requerido.");
                    return;
                }

                if(senha.length() < 6){
                    txtSenha.setError("A sua senha deve ser >= 6 Characteres");
                    return;
                }

                //Autenticação do usuário

                firebaseAuth.signInWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Login Realizado com Sucesso!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),PerfilActivity.class));
                        }else {
                            Toast.makeText(MainActivity.this, "Erro" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        });

        //Esse botão abre a tela de "perfil", temos que fazer ele "sincronizar" a validação com o email e senha
        /*btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PerfilActivity.class));
            }
        });

         */


        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CadastroActivity.class));
            }
        });

        btnEqueceuSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),EsqueceuSenhaActivity.class));
            }
        });



        /*banCadastroMain.setOnClickListener(new View.OnClickListener() {
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
        }); */
    }
}