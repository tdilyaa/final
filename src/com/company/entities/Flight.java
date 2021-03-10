package com.company.entities;

public class Flight {
    private int id;
    private String date;
    private String from_place;
    private String to_place;

    public Flight(int id, String date, String from_place, String to_place) {
        this.id = id;
        this.date = date;
        this.from_place = from_place;
        this.to_place = to_place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFrom_place() {
        return from_place;
    }

    public void setFrom_place(String from_place) {
        this.from_place = from_place;
    }

    public String getTo_place() {
        return to_place;
    }

    public void setTo_place(String to_place) {
        this.to_place = to_place;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", from_place='" + from_place + '\'' +
                ", to_place='" + to_place + '\'' +
                '}';
    }
}
