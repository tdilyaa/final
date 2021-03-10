package com.company.entities;

import com.company.menu.Type;

public class FirstClass extends UniqueClass implements Type {
    private String menu;

    public FirstClass(int id, int place, int flight, int price, String menu) {
        super(id, place, flight, price);
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    @Override
    public void getInfo() {
        System.out.println("This is first class");
    }

    @Override
    public int getType() {
        return 3;
    }

    @Override
    public String toString() {
        return "FirstClass{" +
                "menu='" + menu + '\'' +
                "} " + super.toString();
    }
}
