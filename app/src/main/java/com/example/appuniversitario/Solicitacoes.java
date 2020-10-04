package com.example.appuniversitario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.appuniversitario.Models.FeedActivityOfi;

public class Solicitacoes extends AppCompatActivity {

    private EditText  txtDetalhesEncontro;
    private Spinner dropdown3;
    private Button btnEnviarSolicitacoes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacoes);
        txtDetalhesEncontro = (EditText) findViewById(R.id.txtDetalhesSolicitacao);
        btnEnviarSolicitacoes = (Button) findViewById(R.id.btnEnviarSolicitacoes);

        Spinner staticSpinner = (Spinner) findViewById(R.id.spinnerSolicitacoes);
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.skill_array,
                        android.R.layout.simple_spinner_item);
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticSpinner.setAdapter(staticAdapter);

        btnEnviarSolicitacoes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Solicitacoes.this, "Solicitação Enviada!", Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(getApplicationContext(), FeedActivityOfi.class));
                        //Toast.makeText(Solicitacoes.this, "Solicitação Enviada!", Toast.LENGTH_SHORT).show();
                  }
              });
    }
}