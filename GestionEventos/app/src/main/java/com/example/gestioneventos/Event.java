package com.example.gestioneventos;
public class Event {
    private String name;
    private String date;
    private String time;

    public Event(String name, String date, String time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public String getName() { return name; }
    public String getDate() { return date; }
    public String getTime() { return time; }
}
