package com.company.entities;

import com.company.menu.Type;

public class BusinessClass extends UniqueClass implements Type {

    public BusinessClass(int id, int place, int flight, int price) {
        super(id, place, flight, price);
    }

    @Override
    public void getInfo() {
        System.out.println("This is business class");
    }

    @Override
    public int getType() {
        return 1;
    }

    @Override
    public String toString() {
        return "BusinessClass{} " + super.toString();
    }
}
