package com.example.appuniversitario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PerfilActivity extends AppCompatActivity {


    private TextView txtNome, txtSobre, txtEmail, txtCelular, txtSemestre, txtSexo;
    private Button btnSalvarPerfil, btnHabilidades;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    String IdPerfil = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        IdPerfil = firebaseAuth.getUid();

        int c = 1;
       EventoDataBase();

        txtNome = (TextView) findViewById(R.id.txtNomeUsuarioPerfil);
        txtSobre = (TextView) findViewById(R.id.txtSobreMimPerfil);
        txtEmail = (TextView) findViewById(R.id.txtEmailPerfil);
        txtCelular = (TextView) findViewById(R.id.txtCelularPerfil);
        txtSexo = (TextView) findViewById(R.id.txtSexoPerfil);
        txtSemestre = (TextView) findViewById(R.id.txtSemestrePerfil);
        btnSalvarPerfil = (Button) findViewById(R.id.btnSalvarPerfil);
        btnHabilidades = (Button) findViewById(R.id.btnHabilidades);
        btnSalvarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Usuarios usuariosTeste = new Usuarios();
                usuariosTeste.nome = txtNome.getText().toString();
                usuariosTeste.email = txtEmail.getText().toString();
                usuariosTeste.sobremim = txtSobre.getText().toString();
                String semestre = txtSemestre.getText().toString();
                int semestreInt = Integer.parseInt(semestre);
                usuariosTeste.semestre = semestreInt;
                usuariosTeste.sexo = txtSexo.getText().toString();
                usuariosTeste.telefone = txtCelular.getText().toString();

                databaseReference.child("Usuarios").child(IdPerfil).setValue(usuariosTeste);
            }
        });

        btnHabilidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HabilidadesActivity.class));
            }
        });

       // txtUniversidade = (TextView) findViewById(R.id.txt);
    }

    private void EventoDataBase()
    {

        databaseReference.child("Usuarios").child(IdPerfil).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Usuarios usuarios = snapshot.getValue(Usuarios.class);
                txtNome.setText(usuarios.nome);
                txtEmail.setText(usuarios.email);
                //txtSobre.setText(usuarios.sobrenome);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}