package com.company.entities;
import com.company.menu.Type;


public class EconomyClass extends UniqueClass implements Type {
    private int baggage;

    public EconomyClass(int id, int place, int flight, int price, int baggage) {
        super(id, place, flight, price);
        this.baggage = baggage;
    }

    public int getBaggage() {
        return baggage;
    }

    public void setBaggage(int baggage) {
        this.baggage = baggage;
    }

    @Override
    public void getInfo() {
        System.out.println("This is economy  class");
    }

    @Override
    public int getType() {
        return 2;
    }

    @Override
    public String toString() {
        return "EconomyClass{" +
                "baggage=" + baggage +
                "} " + super.toString();
    }
}