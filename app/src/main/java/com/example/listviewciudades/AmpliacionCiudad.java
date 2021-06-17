package com.example.listviewciudades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class AmpliacionCiudad extends AppCompatActivity {
    ImageView ivampliada;
    TextView nombreciudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ampliacion_ciudad);

        ivampliada = findViewById(R.id.ivAmpliada);
        nombreciudad = findViewById(R.id.tvNombreCiudad);
        Bundle bundle = getIntent().getExtras();
        ivampliada.setImageResource(bundle.getInt("imagen"));
        Log.i("Imagem", String.valueOf(bundle.getInt("imagen")));
        nombreciudad.setText(bundle.getString("nombre"));
    }
}