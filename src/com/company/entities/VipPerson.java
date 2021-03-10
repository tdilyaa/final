package com.company.entities;

public class VipPerson extends Person {
    private int privilege_level;

    public VipPerson(int id, String full_name, int age, int privilege_level) {
        super(id, full_name, age);
        this.privilege_level = privilege_level;
    }

    public int getPrivilege_level() {
        return privilege_level;
    }

    public void setPrivilege_level(int privilege_level) {
        this.privilege_level = privilege_level;
    }

    @Override
    public String toString() {
        return "VipPerson{" +
                "privilege_level=" + privilege_level +
                "} " + super.toString();
    }
}
