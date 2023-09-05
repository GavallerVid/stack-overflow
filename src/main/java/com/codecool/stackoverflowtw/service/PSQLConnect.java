package com.codecool.stackoverflowtw.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PSQLConnect {
    private final String url = "jdbc:postgresql://localhost:5432/stackoverflow";
    private final String user = "postgres";
    private final String password = "4444";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
