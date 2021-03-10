package com.company.menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu implements MenuInterface {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/end?useUnicode=true&serverTimezone=UTC";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
        return connection;
    }

    public static void menu() {
        System.out.println("Select option: ");
        System.out.println("1. Insert info");
        System.out.println("2. Get info");
        System.out.println("0. Quit");

        int option = Integer.parseInt(new Scanner(System.in).nextLine());

        if(option == 1) {
            InsertMenu.menu();
        }
        if(option == 2) {
            SelectMenu.menu();
        }
        if(option == 0) {
            return;
        }
        menu();
    }
}
