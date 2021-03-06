package com.example.appuniversitario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appuniversitario.Models.FeedActivityOfi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private Button btnEntrar, btnEsqueceuSenha, btnCadastro;
    private EditText txtEmail, txtSenha;
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
        firebaseAuth = FirebaseAuth.getInstance();
        //Usuarios usuariosTeste = new Usuarios();
        //usuariosTeste.idUsuarios = UUID.randomUUID().toString();
        //usuariosTeste.nome = "Neymar";
        // usuariosTeste.email = "adultoney@gmail.com";
        //usuariosTeste.senha = "neyzika123";
        // databaseReference.child("Usuarios").child(usuariosTeste.idUsuarios).setValue(usuariosTeste);

        //Button banCadastroMain = (Button) findViewById(R.id.btnCadastro);
        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        btnCadastro = (Button) findViewById(R.id.btnCadastro);
        btnEsqueceuSenha = (Button) findViewById(R.id.btnEsqSenha);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        this.txtSenha.setText("123456");
        this.txtEmail.setText("teste10@10.com");

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString().trim();
                String senha = txtSenha.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    txtEmail.setError("O campo 'email' é requerido.");
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

                //Autenticação do usuário
                try {
                    firebaseAuth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
                                FirebaseUser user = firebaseAuth.getCurrentUser();

                                startActivity(new Intent(getApplicationContext(), PerfilActivity.class));
                            } else {
                                Toast.makeText(MainActivity.this, "Erro!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                catch (Exception ex)
                {
                    String a = ex.toString();
                }
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

        /*btnEsqueceuSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),EsqueceuSenhaActivity.class));
            }
        });
         */

        btnEsqueceuSenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText resetMail = new EditText(v.getContext());
                AlertDialog.Builder dialogoRedefineSenha = new AlertDialog.Builder(v.getContext());
                dialogoRedefineSenha.setTitle("Redefinir senha?");
                dialogoRedefineSenha.setMessage("Digite o seu email para receber o link");
                dialogoRedefineSenha.setView(resetMail);

                dialogoRedefineSenha.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        //extrair email e enviar o link de redefinição
                        String mail = resetMail.getText().toString();
                        firebaseAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(MainActivity.this, "O link de redefinição de senha foi enviado para o seu emai!", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Erro, link de redefinição não enviado!" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

                dialogoRedefineSenha.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        //Fechar o dialógo
                    }
                });

                dialogoRedefineSenha.create().show();
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