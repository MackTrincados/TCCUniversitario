package com.example.appuniversitario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.appuniversitario.Models.FeedActivityOfi;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class HabilidadesActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    public List<Habilidades> lstHabilidade = new ArrayList<>();

    private Spinner dropdown3;

    private Button btnEntrarFeed, btnSalvarHabilidade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habilidades);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        btnEntrarFeed = (Button) findViewById(R.id.btnEntrarFeed1);
        btnSalvarHabilidade = (Button) findViewById(R.id.btnSalvarHabilidades1);

        //Tipo 1

        Spinner staticSpinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.skill_array,
                        android.R.layout.simple_spinner_item);
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticSpinner.setAdapter(staticAdapter);
        //segundo

        Spinner staticSpinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> staticAdapter2 = ArrayAdapter
                .createFromResource(this, R.array.skill_array,
                        android.R.layout.simple_spinner_item);
        staticAdapter2
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticSpinner2.setAdapter(staticAdapter2);

        // terceiro

        Spinner staticSpinner3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> staticAdapter3 = ArrayAdapter
                .createFromResource(this, R.array.skill_array,
                        android.R.layout.simple_spinner_item);
        staticAdapter3
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticSpinner3.setAdapter(staticAdapter3);




//create a list of items for the spinner.

//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.



//Dar uma olhada !!

        //dropdown3 = (Spinner) findViewById(R.id.spinner3);
        //ArrayAdapter<Habilidades> adapter3 = new ArrayAdapter<Habilidades>
       //          (this, android.R.layout.simple_spinner_item, lstHabilidade);
      // adapter3.setDropDownViewResource(android.R.layout.simple_spinner_item);
//set the spinners adapter to the previously created one.
       // dropdown3.setAdapter(adapter3);


       // dropdown3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        //    @Override
       //    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //        Habilidades habilidades = (Habilidades) adapterView.getSelectedItem();
        //        String ae = habilidades.descricao;
        //    }

        //    @Override
        //    public void onNothingSelected(AdapterView<?> adapterView) {

        //    }
        //});






        //Tipo 2


        //Spinner dynamicSpinner = (Spinner) findViewById(R.id.spinner2);

        //String[] items = new String[] { "HTML", "CSS", "JavaScript" };

       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          //      android.R.layout.simple_spinner_item, items);
        //dynamicSpinner.setAdapter(adapter);


        //dynamicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         //   @Override
         ///   public void onItemSelected(AdapterView<?> parent, View view,
         //                              int position, long id) {
         //       Log.v("item", (String) parent.getItemAtPosition(position));
          //  }

         //   @Override
         //   public void onNothingSelected(AdapterView<?> parent) {
         //       // TODO Auto-generated method stub
         //   }
      //  });

       // AdicionarHabilidades();
        CarregarHabilidades();
    }
    public  void AdicionarHabilidades()
    {

        Habilidades habilidades = new Habilidades();

        habilidades.idHabilidades = UUID.randomUUID().toString();
        habilidades.descricao = "habilidade 2";


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


                for (DataSnapshot areaSnapshot : snapshot.getChildren()) {
                    String idHabilidade = areaSnapshot.getKey();
                    databaseReference.child("Habilidades").child(idHabilidade).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Habilidades habilidades = snapshot.getValue(Habilidades.class);
                            lstHabilidade.add(habilidades);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
          //          Habilidades r = (Habilidades) areaSnapshot.getValue();

                }


               // usu = snapshot.getValue(Usuarios.class);
                //txtNome.setText(usuarios.nome);
                //txtEmail.setText(usuarios.email);
                //txtSobre.setText(usuarios.sobrenome);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnEntrarFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FeedActivityOfi.class));
            }
        });

        btnSalvarHabilidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HabilidadesActivity.this, "Habilidades Salvas!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void getSelectedUser(View v)
    {
        Habilidades habilidades = (Habilidades) dropdown3.getSelectedItem();
    }
}