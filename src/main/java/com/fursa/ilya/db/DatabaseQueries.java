package com.fursa.ilya.db;

import com.fursa.ilya.pojo.Friend;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQueries implements DatabaseWorker {
    private Statement statement = null;

    @Override
    public void addFriend(Friend friend) throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConnection.getInstance();
        System.out.println("INSERT INTO Users.User(uid, firs_name, last_name, sex) " +
                "VALUES(" + friend.getUid() + ", '" + friend.getFirstName() + "','"
                + friend.getLastName() + "'," + friend.getSex() +");");
        statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO Users.User(uid, firs_name, last_name, sex) " +
                "VALUES(" + friend.getUid() + ", '" + friend.getFirstName() + "','" + friend.getLastName() + "'," + friend.getSex() +");");

    }

    @Override
    public boolean deleteFriend(int id) {
        return false;
    }
}
