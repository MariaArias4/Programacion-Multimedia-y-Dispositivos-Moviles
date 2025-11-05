package com.example.tema5_gridview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.linear);

        //Datos de ejemplo
        List<String> data = Arrays.asList("Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4");


        //Configurar el ListView y asignarle el adaptador
        GridView listado = findViewById(R.id.grid);
        ArrayAdapter<String> adap = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adap);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Obtener el texto del elemento pulsado
                String elemento = (String) parent.getItemAtPosition(position);
                TextView texto2 = findViewById(R.id.text2);
                texto2.setText("Has seleccionado: " + elemento);
            }
        });
    }
}