package ru.smal.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfig {

    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:C:/h2_db/first_db";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    private final Connection connection;

    public ConnectionConfig () {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
