package com.company.entities;
/*Parent class from which is inherited VipPerson*/
public class Person {
    private int id;
    private String full_name;
    private int age;

    public Person(int id, String full_name, int age) {
        this.id = id;
        this.full_name = full_name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", age=" + age +
                '}';
    }
}
