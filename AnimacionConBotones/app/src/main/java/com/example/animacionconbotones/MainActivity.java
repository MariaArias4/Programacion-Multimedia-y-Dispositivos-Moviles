package com.example.animacionconbotones;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Animation animacionActual;
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.lineal_layout);

    }
    protected void onStart(){
        super.onStart();
        Button btnTraslate = findViewById(R.id.btnTranslate);
        Button btnRotar = findViewById(R.id.btnRotate);
        Button btnDetener = findViewById(R.id.btnNo);
        texto = findViewById(R.id.texto);

        btnTraslate.setOnClickListener(v -> {
            animacionActual = AnimationUtils.loadAnimation(this, R.anim.traslate);
            texto.startAnimation(animacionActual);});
        btnRotar.setOnClickListener(v -> {
            animacionActual = AnimationUtils.loadAnimation(this, R.anim.rotar);
            texto.startAnimation(animacionActual);});
        btnDetener.setOnClickListener(v -> detener());
    }


    private void detener(){
        if(animacionActual != null){
            texto.clearAnimation();
            animacionActual.cancel();
            animacionActual = null;
        }
    }
}