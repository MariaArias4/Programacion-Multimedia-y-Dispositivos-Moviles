package com.example.ejemplotextview;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
        setContentView(R.layout.activity_main);
    }

    protected void onStart(){
        super.onStart();
        TextView miTexto = (TextView) findViewById(R.id.texto);
        miTexto.setText("No giradsfdfsdfsdfsfsdfsdfsdf");
        //Opcion 1 para cambiar el color
        miTexto.setTextColor(Color.parseColor("#0000FF"));
        //Opcion 2 para cambiar el color
        miTexto.setTextColor(Color.RED);
        //Cambio del texto a Negrita
        miTexto.setTypeface(null, Typeface.ITALIC);
        //Cambio el tamaño del texto
        miTexto.setTextSize(24);
        //Cambiar tipo de letra
        miTexto.setTypeface(Typeface.SANS_SERIF);

        Animation miAnimacion = AnimationUtils.loadAnimation(this,R.anim.animacion);
        miAnimacion.setRepeatMode(Animation.RESTART);
        miAnimacion.setRepeatCount(99999);
        miTexto.startAnimation(miAnimacion);
    }
}