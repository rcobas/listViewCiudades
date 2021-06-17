package com.example.listviewciudades;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    Context miContexto;
    ArrayList<Ciudad> listaCiudades;

    public Adaptador(Context miContexto, ArrayList<Ciudad> listaCiudades) {
        this.miContexto = miContexto;
        this.listaCiudades = listaCiudades;
    }

    @Override
    public int getCount() {
        return listaCiudades.size();
    }

    @Override
    public Object getItem(int pos) {
        return listaCiudades.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return listaCiudades.get(pos).getImagen();
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        LayoutInflater inflador = LayoutInflater.from(miContexto);
        view = inflador.inflate(R.layout.itemdetail, null);

        TextView ciudad = view.findViewById(R.id.tvCiudad);
        TextView pais = view.findViewById(R.id.tvPais);
        TextView poblacion = view.findViewById(R.id.tvPoblacion);
        ImageView imagen = view.findViewById(R.id.ivImagen);
        ImageButton btAmpliar = view.findViewById(R.id.btAmpliar);
        ImageButton btMapa = view.findViewById(R.id.btMapa);

        ciudad.setText(listaCiudades.get(i).getCiudad());
        pais.setText(listaCiudades.get(i).getPais());
        poblacion.setText(listaCiudades.get(i).getPoblacion());
        imagen.setImageResource(listaCiudades.get(i).getImagen());
        btAmpliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AmpliacionCiudad.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//MUY IMPORTANTE AÑADIR LOS FLAGS!!!
                intent.putExtra("imagen", listaCiudades.get(i).getImagen());
                intent.putExtra("nombre", listaCiudades.get(i).getCiudad());
                v.getContext().startActivity(intent);

            }
        });

        btMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(v.getContext(), MapsActivity.class);
                in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                in.putExtra("latitud", listaCiudades.get(i).getLatitud());
                in.putExtra("longitud", listaCiudades.get(i).getLongitud());
                in.putExtra("ciudad", listaCiudades.get(i).getCiudad());
                v.getContext().startActivity(in);
            }
        });


        return view;
    }


}

