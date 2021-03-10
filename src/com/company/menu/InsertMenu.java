package com.company.menu;

import com.company.entities.*;

import java.sql.SQLException;
import java.util.Scanner;

public class InsertMenu {
    public static void menu() {
        System.out.println("Select option: ");
        System.out.println("1. Insert person");
        System.out.println("2. Insert ticket");
        System.out.println("3. Insert flight");
        System.out.println("0. Quit");

        int option = Integer.parseInt(new Scanner(System.in).nextLine());
        try {
            if(option == 1) {
                insertPerson();
            }
            if(option == 2) {
                insertTicket();
            }
            if(option == 3) {
                insertFlight();
            }
        }
        catch (Exception e) {
            System.out.println("Something went wrong, please try again");
        }

        if(option == 0) {
            return;
        }
        menu();
    }

    public static void insertPerson() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter person name: ");
        String full_name = scan.nextLine();
        System.out.println("Enter age: ");
        int age = Integer.parseInt(scan.nextLine());

        System.out.println("Is vip? (y/n):");
        String vip = scan.nextLine();
        if(vip.equals("n")) {
            insertNonVipPerson(new Person(0, full_name, age));
            return;
        }
        if(vip.equals("y")) {
            System.out.println("Enter privilege level: ");
            int vip_level = Integer.parseInt(scan.nextLine());
            insertVipPerson(new VipPerson(0, full_name, age, vip_level));
            return;
        }
        System.out.println("Something went wrong");
    }

    public static void insertNonVipPerson(Person person) throws SQLException {
        Menu.getConnection().createStatement().execute("INSERT INTO person (fullname, age) VALUES ('"+person.getFull_name()+"','"+person.getAge()+"')");
    }

    public static void insertVipPerson(VipPerson person) throws SQLException {
        Menu.getConnection().createStatement().execute("INSERT INTO person (fullname, age, vip) VALUES ('"+person.getFull_name()+"','"+person.getAge()+"', '"+person.getPrivilege_level()+"')");
    }

    public static void insertTicket() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter flight id: ");
        int flight_id = Integer.parseInt(scan.nextLine());
        System.out.println("Enter place number: ");
        int place = Integer.parseInt(scan.nextLine());
        System.out.println("Enter price: ");
        int price = Integer.parseInt(scan.nextLine());
        System.out.println("Enter person id: ");
        int person_id = Integer.parseInt(scan.nextLine());
        System.out.println("Enter class (b - business, e - economy, f - first): ");
        String class_ = scan.nextLine();
        if(class_.equals("b")) {
            insertBusinessClass(new BusinessClass(0, flight_id, place, price), person_id);
        }
        if(class_.equals("e")) {
            System.out.println("Insert baggage capacity: ");
            int baggage = Integer.parseInt(scan.nextLine());
            insertEconomyClass(new EconomyClass(0, place, flight_id, price, baggage), person_id);
        }
        if(class_.equals("f")) {
            System.out.println("Insert menu(100 symbol max): ");
            String menu = scan.nextLine();
            insertFirstClass(new FirstClass(0, place, flight_id, price, menu), person_id);
        }
    }

    public static void insertBusinessClass(BusinessClass businessClass, int person_id) throws SQLException {
        Menu.getConnection().createStatement().execute("INSERT INTO ticket (flight_id, place, price, person_id, class) VALUES ('"+businessClass.getFlight()+"','"+businessClass.getPlace()+"','"+businessClass.getPrice()+"','"+person_id+"','b')");
    }

    public static void insertEconomyClass(EconomyClass economyClass, int person_id) throws SQLException {
        Menu.getConnection().createStatement().execute("INSERT INTO ticket (flight_id, place, price, person_id, class, baggage) VALUES ('"+economyClass.getFlight()+"','"+economyClass.getPlace()+"','"+economyClass.getPrice()+"','"+person_id+"','e', '"+economyClass.getBaggage()+"')");
    }

    public static void insertFirstClass(FirstClass firstClass, int person_id) throws SQLException {
        Menu.getConnection().createStatement().execute("INSERT INTO ticket (flight_id, place, price, person_id, class, menu) VALUES ('"+firstClass.getFlight()+"','"+firstClass.getPlace()+"','"+firstClass.getPrice()+"','"+person_id+"','f','"+firstClass.getMenu()+"')");
    }

    public static void insertFlight() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter date (yyyy-mm-dd): ");
        String date = scan.nextLine();
        System.out.println("Enter from place: ");
        String from_place = scan.nextLine();
        System.out.println("Enter to place: ");
        String to_place = scan.nextLine();

        insertFlightComplete(new Flight(0, date, from_place, to_place));
    }

    public static void insertFlightComplete(Flight flight) throws SQLException {
        Menu.getConnection().createStatement().execute("INSERT INTO flight (date, from_place, to_place) VALUES ('"+flight.getDate()+"','"+flight.getFrom_place()+"','"+flight.getTo_place()+"')");
    }
}
