package com.example.edittext;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        String [] opciones = {"Opcion1", "Opcion2", "Opcion3", "Opcion4", "Opcion5"};

        AutoCompleteTextView textoLeido = findViewById(R.id.miTexto);

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line,opciones);
        textoLeido.setAdapter(adaptador);

        Spinner miSpinner = (Spinner) findViewById(R.id.miSpinner);
        String[] valores = {"a", "b", "c", "d"};
        miSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Has seleccionado el valor:", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "No has seleccionado nada", Toast.LENGTH_SHORT).show();
            }
        });

        CheckBox checkbox1 = findViewById(R.id.checkbox1);
        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Marcado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "No marcado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Button buttonCheck = findViewById(R.id.buttonCheck);
        TextView textView = findViewById(R.id.textViewResult);

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if(selectedId != -1){
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedOption = selectedRadioButton.getText().toString();
                    textView.setText("Seleccionado: " + selectedOption);
                } else {
                    textView.setText("No se ha seleccionado ninguna opcion");                }
            }
        });

        TextView textViewStatus = findViewById(R.id.textViewSwitch);
        Switch switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    textViewStatus.setText("Estado: Encendido");
                }else {
                    textViewStatus.setText("Estado: Apagado");
                }
            }
        });

        TextView textViewSeek = findViewById(R.id.textViewSeek);
        SeekBar seekBar1 = findViewById(R.id.seekbar1);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewSeek.setText("Valor: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //textViewSeek.setText("Estas usando la barra");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //textViewSeek.setText("Has dejado de usar la barra");
            }
        });

        TextView textViewrat = findViewById(R.id.textViewRat);
        RatingBar ratingBar = findViewById(R.id.ratingBar1);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textViewrat.setText("Calificacion: " + rating);
            }
        });

    }
}