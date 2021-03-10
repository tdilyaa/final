package com.company.menu;

import com.company.entities.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectMenu implements MenuInterface {
    public static void menu() {
        System.out.println("Select option: ");
        System.out.println("1. Select people");
        System.out.println("2. Select tickets");
        System.out.println("3. Select flights");
        System.out.println("4. Select tickets of flight");
        System.out.println("5. Select tickets of person");
        System.out.println("0. Quit");

        int option = Integer.parseInt(new Scanner(System.in).nextLine());
        try {
            if(option == 1) {
                selectPeople();
            }
            if(option == 2) {
                selectTickets();
            }
            if(option == 3) {
                selectFlights();
            }
            if(option == 4) {
                selectTicketsOfPerson();
            }
            if(option == 5) {
                selectTicketsOfFlight();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if(option == 0) {
            return;
        }
        menu();
    }

    public static void selectPeople() throws SQLException {
        ResultSet rs = Menu.getConnection().createStatement().executeQuery("SELECT * FROM person");
        while (rs.next()) {
            Person person = null;
            if(rs.getString("vip_level") != null) {
                person = new VipPerson(rs.getInt("person_id"), rs.getString("fullname"), rs.getInt("age"), rs.getInt("vip_level"));
                System.out.println(person);
            }
            else {
                person = new Person(rs.getInt("person_id"), rs.getString("fullname"), rs.getInt("age"));
                System.out.println(person);
            }
        }
    }

    public static void selectTickets() throws SQLException {
        ResultSet rs = Menu.getConnection().createStatement().executeQuery("SELECT * FROM ticket");
        while (rs.next()) {
            UniqueClass type = null;
            if(rs.getString("class").equals("b")) {
                type = new BusinessClass(
                        rs.getInt("ticket_id"),
                        rs.getInt("place"),
                        rs.getInt("flight_id"),
                        rs.getInt("price")
                );
                System.out.println(type);
            }
            if(rs.getString("class").equals("e")) {
                type = new EconomyClass(
                        rs.getInt("ticket_id"),
                        rs.getInt("place"),
                        rs.getInt("flight_id"),
                        rs.getInt("price"),
                        rs.getInt("baggage")
                );
                System.out.println(type);
            }
            if(rs.getString("class").equals("f")) {
                type = new FirstClass(
                        rs.getInt("ticket_id"),
                        rs.getInt("place"),
                        rs.getInt("flight_id"),
                        rs.getInt("price"),
                        rs.getString("menu")
                );
                System.out.println(type);
            }
        }
    }


    public static void selectFlights() throws SQLException {
        ResultSet rs = Menu.getConnection().createStatement().executeQuery("SELECT * FROM flight");
        while (rs.next()) {
            Flight flight = new Flight(
                    rs.getInt("flight_id"),
                    rs.getString("date"),
                    rs.getString("from_place"),
                    rs.getString("to_place")
            );
            System.out.println(flight);
        }
    }


    public static void selectTicketsOfPerson() throws SQLException {
        System.out.println("Enter person id: ");
        int id = Integer.parseInt(new Scanner(System.in).nextLine());
        ResultSet rs = Menu.getConnection().createStatement().executeQuery("SELECT * FROM tickets WHERE person_id = " + id);
        while (rs.next()) {
            Type type = null;
            if(rs.getString("class") == "b") {
                type = new BusinessClass(
                        rs.getInt("ticket_id"),
                        rs.getInt("place"),
                        rs.getInt("flight_id"),
                        rs.getInt("price")
                );
                System.out.println(type);
            }
            if(rs.getString("class") == "e") {
                type = new EconomyClass(
                        rs.getInt("ticket_id"),
                        rs.getInt("place"),
                        rs.getInt("flight_id"),
                        rs.getInt("price"),
                        rs.getInt("baggage")
                );
                System.out.println(type);
            }
            if(rs.getString("class") == "f") {
                type = new FirstClass(
                        rs.getInt("ticket_id"),
                        rs.getInt("place"),
                        rs.getInt("flight_id"),
                        rs.getInt("price"),
                        rs.getString("menu")
                );
                System.out.println(type);
            }
        }
    }


    public static void selectTicketsOfFlight() throws SQLException {
        System.out.println("Enter flight id: ");
        int id = Integer.parseInt(new Scanner(System.in).nextLine());
        ResultSet rs = Menu.getConnection().createStatement().executeQuery("SELECT * FROM tickets WHERE flight_id = " + id);
        while (rs.next()) {
            Type type = null;
            if(rs.getString("class") == "b") {
                type = new BusinessClass(
                        rs.getInt("ticket_id"),
                        rs.getInt("place"),
                        rs.getInt("flight_id"),
                        rs.getInt("price")
                );
                System.out.println(type);
            }
            if(rs.getString("class") == "e") {
                type = new EconomyClass(
                        rs.getInt("ticket_id"),
                        rs.getInt("place"),
                        rs.getInt("flight_id"),
                        rs.getInt("price"),
                        rs.getInt("baggage")
                );
                System.out.println(type);
            }
            if(rs.getString("class") == "f") {
                type = new FirstClass(
                        rs.getInt("ticket_id"),
                        rs.getInt("place"),
                        rs.getInt("flight_id"),
                        rs.getInt("price"),
                        rs.getString("menu")
                );
                System.out.println(type);
            }
        }
    }
}
