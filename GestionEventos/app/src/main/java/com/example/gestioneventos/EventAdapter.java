package com.example.gestioneventos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EventAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Event> events;

    public EventAdapter(Context context, ArrayList<Event> events) {
        this.context = context;
        this.events = events;
    }

    @Override
    public int getCount() { return events.size(); }

    @Override
    public Object getItem(int i) { return events.get(i); }

    @Override
    public long getItemId(int i) { return i; }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.item_event, parent, false);

        Event e = events.get(i);

        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtDateTime = convertView.findViewById(R.id.txtDateTime);

        txtName.setText(e.getName());
        txtDateTime.setText(e.getDate() + " " + e.getTime());

        return convertView;
    }
}
