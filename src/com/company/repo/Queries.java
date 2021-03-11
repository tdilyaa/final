package com.company.repo;

import com.company.entities.*;
import com.company.menu.Menu;

import java.sql.SQLException;
/*Here we write all sql queries*/

public class Queries {

    public static void insertNonVipPerson(Person person) throws SQLException {
        DB.getConnection().createStatement().execute("INSERT INTO person (fullname, age) VALUES ('"+person.getFull_name()+"','"+person.getAge()+"')");
    }

    public static void insertVipPerson(VipPerson person) throws SQLException {
        DB.getConnection().createStatement().execute("INSERT INTO person (fullname, age, vip_level) VALUES ('"+person.getFull_name()+"','"+person.getAge()+"', '"+person.getPrivilege_level()+"')");
    }

    public static void insertBusinessClass(BusinessClass businessClass, int person_id) throws SQLException {
        DB.getConnection().createStatement().execute("INSERT INTO ticket (flight_id, place, price, person_id, class) VALUES ('"+businessClass.getFlight()+"','"+businessClass.getPlace()+"','"+businessClass.getPrice()+"','"+person_id+"','b')");
    }

    public static void insertEconomyClass(EconomyClass economyClass, int person_id) throws SQLException {
        DB.getConnection().createStatement().execute("INSERT INTO ticket (flight_id, place, price, person_id, class, baggage) VALUES ('"+economyClass.getFlight()+"','"+economyClass.getPlace()+"','"+economyClass.getPrice()+"','"+person_id+"','e', '"+economyClass.getBaggage()+"')");
    }

    public static void insertFirstClass(FirstClass firstClass, int person_id) throws SQLException {
        DB.getConnection().createStatement().execute("INSERT INTO ticket (flight_id, place, price, person_id, class, menu) VALUES ('"+firstClass.getFlight()+"','"+firstClass.getPlace()+"','"+firstClass.getPrice()+"','"+person_id+"','f','"+firstClass.getMenu()+"')");
    }

    public static void insertFlightComplete(Flight flight) throws SQLException {
        DB.getConnection().createStatement().execute("INSERT INTO flight (date, from_place, to_place) VALUES ('"+flight.getDate()+"','"+flight.getFrom_place()+"','"+flight.getTo_place()+"')");
    }
}
