package com.example.cuentabar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.linear);

        EditText editTextTotal = findViewById(R.id.textocuenta);
        TextView textViewError = findViewById(R.id.total);
        Button buttonValidar = findViewById(R.id.buttonCheck);
        SeekBar seekbarPropina = findViewById(R.id.seekbar1);
        TextView textPropina = findViewById(R.id.propina);
        TextView total = findViewById(R.id.total);

        int propina = 10;


        seekbarPropina.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textPropina.setText("Propina: " + progress + "%");
                MainActivity.this.propina = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        buttonValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editTextTotal.getText().toString().trim();

                // Validación de valor nulo o vacío
                if (input.isEmpty()) {
                    textViewError.setText("Falta meter el valor de la cuenta.");
                    return;
                }

                try {
                    double valor = Double.parseDouble(input);

                    // Validación de valor mínimo
                    if (valor <= 0) {
                        textViewError.setText("El valor debe ser mayor que cero.");
                    } else {
                        textViewError.setText(""); // Sin errores
                    }
                } catch (NumberFormatException e) {
                    textViewError.setText("Formato inválido. Introduce solo números.");
                }

                    if(input )
            }
        });

    }
}