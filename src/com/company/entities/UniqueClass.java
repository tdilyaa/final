package com.company.entities;

public abstract class UniqueClass {
    private int id;
    private int place;
    private int flight;
    private int price;

    public UniqueClass(int id, int place, int flight, int price) {
        this.id = id;
        this.place = place;
        this.flight = flight;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getFlight() {
        return flight;
    }

    public void setFlight(int flight) {
        this.flight = flight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "UniqueClass{" +
                "id=" + id +
                ", place=" + place +
                ", flight=" + flight +
                ", price=" + price +
                '}';
    }
}
