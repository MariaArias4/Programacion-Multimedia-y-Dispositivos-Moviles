package com.example.gestioneventos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ArrayList<Event> events = new ArrayList<>();
    EventAdapter adapter;

    String eventName = "";
    String eventDate = "";
    String eventTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.listEvents);
        Button btnAdd = findViewById(R.id.btnAdd);

        adapter = new EventAdapter(this, events);
        list.setAdapter(adapter);

        // Permiso Android 13+
        if (Build.VERSION.SDK_INT >= 33) {
            requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, 1);
        }

        btnAdd.setOnClickListener(v -> showNameDialog());

        list.setOnItemClickListener((parent, view, position, id) -> showCustomToast(events.get(position)));
    }

    private void showNameDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Nombre del evento");

        final android.widget.EditText input = new android.widget.EditText(this);
        builder.setView(input);

        builder.setPositiveButton("OK", (dialog, which) -> {
            eventName = input.getText().toString();
            showDateDialog();
        });

        builder.setNegativeButton("Cancelar", null);
        builder.show();
    }

    private void showDateDialog() {
        Calendar c = Calendar.getInstance();

        DatePickerDialog dp = new DatePickerDialog(this,
                (view, year, month, day) -> {
                    eventDate = day + "/" + (month + 1) + "/" + year;
                    showTimeDialog();
                },
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH));

        dp.show();
    }

    private void showTimeDialog() {
        Calendar c = Calendar.getInstance();

        TimePickerDialog tp = new TimePickerDialog(this,
                (view, hour, minute) -> {
                    eventTime = hour + ":" + String.format("%02d", minute);
                    addEvent();
                },
                c.get(Calendar.HOUR_OF_DAY),
                c.get(Calendar.MINUTE),
                true);

        tp.show();
    }

    private void addEvent() {
        Event e = new Event(eventName, eventDate, eventTime);
        events.add(e);
        adapter.notifyDataSetChanged();

        NotificationHelper.createNotification(
                this,
                "Nuevo evento: " + eventName,
                eventDate + " " + eventTime
        );
    }

    private void showCustomToast(Event e) {
        View layout = LayoutInflater.from(this).inflate(R.layout.custom_toast, null);
        android.widget.TextView txt = layout.findViewById(R.id.txtToast);
        txt.setText(e.getName() + "\n" + e.getDate() + " " + e.getTime());

        Toast t = new Toast(this);
        t.setView(layout);
        t.setDuration(Toast.LENGTH_LONG);
        t.show();
    }
}