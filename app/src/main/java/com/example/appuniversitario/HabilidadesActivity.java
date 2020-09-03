package com.example.appuniversitario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class HabilidadesActivity extends AppCompatActivity {
    private Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habilidades);

        btnEnviar = (Button) findViewById(R.id.btnEnviarHabilidades);

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

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),BuscaActivity.class));
            }
        });
    }
}