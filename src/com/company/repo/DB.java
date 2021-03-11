package com.company.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
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
}
