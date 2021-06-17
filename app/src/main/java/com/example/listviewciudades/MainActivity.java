package com.example.listviewciudades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv1;
    ArrayList<Ciudad> lista;
    Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1=findViewById(R.id.lv1);
        lista = new ArrayList<Ciudad>();
        lista.add(new Ciudad("Bruselas", "Bélgica", "Pobl: 177 307", "50.8467", "4.3547", R.drawable.bruselas));
        lista.add(new Ciudad("Budapest", "Hungría", "Pobl: 1 752 704", "47.498333", "19.040833", R.drawable.budapest));
        lista.add(new Ciudad("Dublín", "Irlanda", "Pobl: 527 612", "53.3425", "-6.265833", R.drawable.dublin));
        lista.add(new Ciudad("Florencia", "Italia", "Pobl: 382 258", "43.771389", "11.254167", R.drawable.florencia));
        adaptador= new Adaptador(getApplicationContext(), lista);
        lv1.setAdapter(adaptador);




    }
}