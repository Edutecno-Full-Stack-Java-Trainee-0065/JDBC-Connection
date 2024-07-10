package com.example.jdbc1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/myapp";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se pudo cargar el driver de la base de datos");
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

}
