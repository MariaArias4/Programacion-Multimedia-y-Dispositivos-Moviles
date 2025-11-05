package com.example.adaptadorespersonalizados;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Adaptador extends ArrayAdapter<Datos> {
    private Datos[] datos;

    public Adaptador(Context context, Datos[] datos){
        super(context,R.layout.linear , datos);
        this.datos=datos;
    }

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater mostrado = LayoutInflater.from(getContext());
    View linear = mostrado.inflate(R.layout.linear, parent, false);
    TextView text1 = linear.findViewById(R.id.text1);
    TextView text2 = linear.findViewById(R.id.text2);
    text1.setText(datos[position].getTexto1());//Texto principal
    text2.setText(datos[position].getTexto2());//Texto secundario
    return linear;
}
}
