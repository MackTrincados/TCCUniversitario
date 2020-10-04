package com.example.appuniversitario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PerfilActivity2 extends AppCompatActivity {


    private EditText  txtSobre, txtEmail, txtCelular, txtSemestre, txtSexo;
    private TextView txtCurso;
    private EditText  txtNome;
    private Button btnSalvarPerfil, btnHabilidades, btnSolicitarEncontro;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    String IdPerfil = "";
    public String a = "";
    public Usuarios usu = new Usuarios();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil2);

        //firebaseDatabase = FirebaseDatabase.getInstance();
       // databaseReference = firebaseDatabase.getReference();
        //firebaseAuth = FirebaseAuth.getInstance();
        //FirebaseUser user = firebaseAuth.getCurrentUser();
        //IdPerfil = firebaseAuth.getUid();
        //txtNome = (EditText) findViewById(R.id.txtNomeUsuPer2);
        //txtSobre = (EditText) findViewById(R.id.txtSobreMimPerfil2);
       // txtEmail = (EditText) findViewById(R.id.txtEmailPerfil2);
        //txtCelular = (EditText) findViewById(R.id.txtCelularPerfil2);
        //txtCurso = (EditText) findViewById(R.id.txtCursoPerfil2);
        //txtSemestre = (EditText) findViewById(R.id.txtSemestrePerfil2);

        int c = 1;
      // EventoDataBase();


        //txtSexo = (EditText) findViewById(R.id.txtSexoPerfil);

       // btnSalvarPerfil = (Button) findViewById(R.id.btnSalvarPerfil);
        btnHabilidades = (Button) findViewById(R.id.btnSolicitarEncontroPerfil);



        btnHabilidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Solicitacoes.class));
            }
        });

       // txtUniversidade = (TextView) findViewById(R.id.txt);
    }


}