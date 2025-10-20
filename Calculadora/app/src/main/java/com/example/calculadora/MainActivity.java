package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView texto;
    private double num1 = 0, num2 = 0;
    private String operador = "";
    private boolean nuevoNumero = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_calculadora);

        texto = findViewById(R.id.texto);

        // Botones numéricos
        Button b0 = findViewById(R.id.boton0);
        Button b1 = findViewById(R.id.boton1);
        Button b2 = findViewById(R.id.boton2);
        Button b3 = findViewById(R.id.boton3);
        Button b4 = findViewById(R.id.boton4);
        Button b5 = findViewById(R.id.boton5);
        Button b6 = findViewById(R.id.boton6);
        Button b7 = findViewById(R.id.boton7);
        Button b8 = findViewById(R.id.boton8);
        Button b9 = findViewById(R.id.boton9);
        Button coma = findViewById(R.id.coma);

        // Botones de operaciones
        Button sumar = findViewById(R.id.mas);
        Button restar = findViewById(R.id.menos);
        Button multiplicar = findViewById(R.id.por);
        Button dividir = findViewById(R.id.division);
        Button porcentaje = findViewById(R.id.porciento);
        Button igual = findViewById(R.id.igual);
        Button borrar = findViewById(R.id.botonC);
        Button limpiar = findViewById(R.id.botonAC);

        // Listeners de números
        View.OnClickListener listenerNumero = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                String valor = b.getText().toString();

                if (nuevoNumero) {
                    texto.setText("");
                    nuevoNumero = false;
                }

                String actual = texto.getText().toString();
                if (valor.equals(",") && actual.contains(",")) return; // evitar doble coma

                texto.setText(actual.equals("0") && !valor.equals(",")
                        ? valor
                        : actual + valor);
            }
        };

        b0.setOnClickListener(listenerNumero);
        b1.setOnClickListener(listenerNumero);
        b2.setOnClickListener(listenerNumero);
        b3.setOnClickListener(listenerNumero);
        b4.setOnClickListener(listenerNumero);
        b5.setOnClickListener(listenerNumero);
        b6.setOnClickListener(listenerNumero);
        b7.setOnClickListener(listenerNumero);
        b8.setOnClickListener(listenerNumero);
        b9.setOnClickListener(listenerNumero);
        coma.setOnClickListener(listenerNumero);

        // Listeners de operadores
        sumar.setOnClickListener(v -> guardarOperador("+"));
        restar.setOnClickListener(v -> guardarOperador("-"));
        multiplicar.setOnClickListener(v -> guardarOperador("*"));
        dividir.setOnClickListener(v -> guardarOperador("/"));
        porcentaje.setOnClickListener(v -> guardarOperador("%"));

        // Botón igual
        igual.setOnClickListener(v -> calcular());

        // Botón borrar (C)
        borrar.setOnClickListener(v -> {
            String actual = texto.getText().toString();
            if (actual.length() > 1)
                texto.setText(actual.substring(0, actual.length() - 1));
            else
                texto.setText("0");
        });

        // Botón limpiar (AC)
        limpiar.setOnClickListener(v -> {
            texto.setText("0");
            num1 = 0;
            num2 = 0;
            operador = "";
            nuevoNumero = true;
        });
    }

    private void guardarOperador(String op) {
        num1 = Double.parseDouble(texto.getText().toString().replace(',', '.'));
        operador = op;
        nuevoNumero = true;
    }

    private void calcular() {
        num2 = Double.parseDouble(texto.getText().toString().replace(',', '.'));
        double resultado = 0;

        switch (operador) {
            case "+": resultado = num1 + num2; break;
            case "-": resultado = num1 - num2; break;
            case "*": resultado = num1 * num2; break;
            case "/": resultado = (num2 == 0) ? 0 : num1 / num2; break;
            case "%": resultado = num1 * num2 / 100; break;
            default: resultado = num2; break;
        }

        texto.setText(String.valueOf(resultado));
        num1 = resultado;
        nuevoNumero = true;
    }
}
