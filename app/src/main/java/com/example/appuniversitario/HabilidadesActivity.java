package com.example.appuniversitario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class HabilidadesActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    //public List<Habilidades> lstHabilidades = new List<Habilidades>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habilidades);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        //Tipo 1
        Spinner staticSpinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.skill_array,
                        android.R.layout.simple_spinner_item);
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticSpinner.setAdapter(staticAdapter);


        //Tipo 2
        Spinner dynamicSpinner = (Spinner) findViewById(R.id.spinner2);

        String[] items = new String[] { "HTML", "CSS", "JavaScript" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);
        dynamicSpinner.setAdapter(adapter);


        dynamicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        AdicionarHabilidades();
       // CarregarHabilidades();
    }
    public  void AdicionarHabilidades()
    {

        Habilidades habilidades = new Habilidades();

        habilidades.idHabilidades = UUID.randomUUID().toString();
        habilidades.descricao = "habilidade 1";


        try {
            databaseReference.child("Habilidades").child(habilidades.idHabilidades).setValue(habilidades);

        }
        catch (Exception ex)
        {
            String a = ex.toString();
        }
    }

    public  void CarregarHabilidades()
    {
        databaseReference.child("Habilidades").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Usuarios usuarios = snapshot.getValue(Usuarios.class);
               // usu = snapshot.getValue(Usuarios.class);
                //txtNome.setText(usuarios.nome);
                //txtEmail.setText(usuarios.email);
                //txtSobre.setText(usuarios.sobrenome);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}