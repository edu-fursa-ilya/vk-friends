package com.fursa.ilya.db;

import com.fursa.ilya.pojo.Friend;
import com.fursa.ilya.pojo.Mutual;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQueries implements DatabaseWorker {
    private Statement statement = null;

    private Connection connection = DatabaseConnection.getInstance();

    @Override
    public void addFriend(Friend friend) throws SQLException, ClassNotFoundException {

        System.out.println("INSERT INTO Users.Friend(uid, first_name, last_name, sex, owner) " +
                "VALUES(" + friend.getUid() + ", '" + friend.getFirstName() + "','"
                + friend.getLastName() + "'," + friend.getSex() +"," + friend.getOwnerId() +");");

        statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO Users.Friends(uid, first_name, last_name, sex, owner) " +
                "VALUES(" + friend.getUid() + ", '" + friend.getFirstName() + "','" + friend.getLastName()
                + "'," + friend.getSex() +"," + friend.getOwnerId() +");");

    }

    @Override
    public void addMutualFriend(Mutual mutual) throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO Users.Mutual_Friends(uid1, uid2, mutual_friend_uid) VALUES " +
                "(" + mutual.getUser1() +"," + mutual.getUser2() + "," + mutual.getMutualId() + ");");

        System.out.println("INSERT INTO Users.Mutual_Friends(uid1, uid2, mutual_friend_uid) VALUES (" + mutual.getUser1()
                +"," + mutual.getUser2() + "," + mutual.getMutualId() + ");");
    }

    public DatabaseQueries() throws SQLException, ClassNotFoundException {

    }
}
