package com.fursa.ilya.db;

import com.fursa.ilya.pojo.Friend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static Connection connection = null;
    private static final String URL = "jdbc:mysql://localhost:3306/VK_FRIENDS?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "toor";

    private DatabaseConnection() {

    }

    public static Connection getInstance() throws ClassNotFoundException, SQLException {
        if(connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }

        return connection;
    }

}
