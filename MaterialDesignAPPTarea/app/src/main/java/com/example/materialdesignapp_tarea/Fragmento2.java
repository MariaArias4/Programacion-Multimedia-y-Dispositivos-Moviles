package com.example.materialdesignapp_tarea;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragmento2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflamos la vista normalmente
        View view = inflater.inflate(R.layout.fragment_fragmento2, container, false);

        // Ejemplo sencillo: botón que muestra un mensaje
        Button btn = view.findViewById(R.id.btnExample);
        if (btn != null) {
            btn.setOnClickListener(v ->
                    Toast.makeText(getContext(), "Has pulsado el botón", Toast.LENGTH_SHORT).show()
            );
        }

        return view;
    }
}