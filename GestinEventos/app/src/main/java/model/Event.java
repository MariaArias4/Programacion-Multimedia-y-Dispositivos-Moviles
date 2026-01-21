package model;

import java.util.Calendar;

public class Event {
    private String name;
    private Calendar dateTime;

    public Event(String name, Calendar dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public Calendar getDateTime() {
        return dateTime;
    }

    public String getFormattedDate() {
        int day = dateTime.get(Calendar.DAY_OF_MONTH);
        int month = dateTime.get(Calendar.MONTH) + 1;
        int year = dateTime.get(Calendar.YEAR);
        return day + "/" + month + "/" + year;
    }

    public String getFormattedTime() {
        int hour = dateTime.get(Calendar.HOUR_OF_DAY);
        int minute = dateTime.get(Calendar.MINUTE);
        return String.format("%02d:%02d", hour, minute);
    }
}