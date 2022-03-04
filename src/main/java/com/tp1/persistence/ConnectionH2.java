package com.tp1.persistence;

import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionH2 {

    static final String DRIVER_JDBC = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/TP1Javatown";

    static final String USER = "sa";
    static final String PASS = "";

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Impossible de se connecter à la base de données.", ex);
        }
    }
}
