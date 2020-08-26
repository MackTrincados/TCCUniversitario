package com.example.appuniversitario;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;

public class CadastroActivity extends AppCompatActivity {
    private Button btnCriarPerfil, btnEnviar;
    private EditText txtEmail, txtSenha, txtNome, txtSobrenome;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);
        btnCriarPerfil = (Button) findViewById(R.id.btnCriarPerfilCadastro);
        btnEnviar = (Button) findViewById(R.id.btnEnviarCadastro);
        txtEmail = (EditText) findViewById(R.id.txtEmailCadastro);
        txtNome = (EditText) findViewById(R.id.txtNomeCadastro);
        txtSobrenome = (EditText) findViewById(R.id.txtSobrenomeCadastro);
        txtSenha = (EditText) findViewById(R.id.txtSenhaCadastro);
        txtEmail.setText("email@email.com");
        txtNome.setText("nome");
        txtSobrenome.setText("sobre");
        txtSenha .setText("etre45");


       // if (firebaseAuth.getCurrentUser() != null) {
         //   startActivity(new Intent(getApplicationContext(), MainActivity.class));
          //  finish();
       // }
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();





        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick (View view){
                    String email = txtEmail.getText().toString().trim();
                    String senha = txtSenha.getText().toString().trim();
                    String nome = txtNome.getText().toString().trim();
                    String sobrenome = txtSobrenome.getText().toString().trim();

                if(TextUtils.isEmpty(nome)){
                    txtNome.setError("O campo 'nome' é requerido.");
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    txtEmail.setError("O campo 'email' é requerido.");
                    return;
                }
                if(TextUtils.isEmpty(sobrenome)){
                    txtSobrenome.setError(" O campo 'sobrenome' é requerido.");
                    return;
                }

                if(TextUtils.isEmpty(senha)){
                    txtSenha.setError("O campo 'senha' é requerido.");
                    return;
                }

                if(senha.length() < 6){
                    txtSenha.setError("A sua senha deve ter entre 6 ou mais characteres");
                    return;
                }

                firebaseAuth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            criarUsuarioFirebase(user);
                            Toast.makeText(CadastroActivity.this, "Usuário criado", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),PerfilActivity.class));

                        }else{
                            Toast.makeText(CadastroActivity.this, "Usuário não encontrado" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }


                    }
                });
            }
        });


        /*btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
         */

  /*      btnCriarPerfil.setOnClickListener(new View.OnClickListener() {
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
                } catch (Exception ex) {
                    String erro = "-";
                }
                finish();
            }

        }); */
    }

    private void criarUsuarioFirebase(FirebaseUser user)
    {
        Usuarios usuariosTeste = new Usuarios();
        usuariosTeste.idUsuarios = firebaseAuth.getUid();
        usuariosTeste.nome = txtNome.getText().toString();
        usuariosTeste.email = txtEmail.getText().toString();
        usuariosTeste.senha = txtSenha.getText().toString();
        usuariosTeste.sobrenome = txtSobrenome.getText().toString();

        try {
            databaseReference.child("Usuarios").child(usuariosTeste.idUsuarios).setValue(usuariosTeste);

        }
        catch (Exception ex)
        {
            String a = ex.toString();
        }

    }

}