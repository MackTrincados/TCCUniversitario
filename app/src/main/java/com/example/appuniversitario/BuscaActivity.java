package com.example.appuniversitario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class BuscaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busca);

        //Spinner Curso

        Spinner spinnerCurso = (Spinner) findViewById(R.id.spinnerC);
        String[] cursos = new String[] {"nenhum", "Direito", "Engenharia", "FCI" };

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, cursos);
        spinnerCurso.setAdapter(adapter1);

        //Spinner Semestre

        Spinner spinnerSemestre = (Spinner) findViewById(R.id.spinnerS);
        String[] semestre = new String[] { "nenhum", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, semestre);
        spinnerSemestre.setAdapter(adapter2);

        //Spinner Deficiencia

        Spinner spinnerDeficiencia = (Spinner) findViewById(R.id.spinnerD);
        String[] deficiencia = new String[] { "nenhum", "Auditiva" };

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, deficiencia);
        spinnerDeficiencia.setAdapter(adapter3);

        //Spinner Recomendações

        Spinner spinnerRecomendacoes = (Spinner) findViewById(R.id.spinnerR);
        String[] recomendacoes = new String[] { "nenhum", "Restaurantes", "Estacionamentos" };

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, recomendacoes);
        spinnerRecomendacoes.setAdapter(adapter4);


    }
}