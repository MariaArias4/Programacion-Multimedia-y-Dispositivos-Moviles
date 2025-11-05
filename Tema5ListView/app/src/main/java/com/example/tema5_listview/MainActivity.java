package com.example.tema5_listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
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
        ListView listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Obtener el texto del elemento pulsado
                String elemento = (String) parent.getItemAtPosition(position);
                TextView texto = findViewById(R.id.text);
                texto.setText("Has seleccionado: " + elemento);
            }
        });

        //Configurar el ListView y asignarle el adaptador
        GridView listado = findViewById(R.id.grid);
        ArrayAdapter<String> adap = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        listado.setAdapter(adap);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Obtener el texto del elemento pulsado
                String elemento = (String) parent.getItemAtPosition(position);
                TextView texto2 = findViewById(R.id.text2);
                texto2.setText("Has seleccionado: " + elemento);
            }
        });

        Spinner miSpinner = (Spinner) findViewById(R.id.spin);
        String[] valores = {"a", "b", "c", "d"};
        miSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));
        TextView texto3 = findViewById(R.id.text3);

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                texto3.setText("Has seleccionado el valor:" + parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                texto3.setText("No has seleccionado nada");
            }
        });
    }
}