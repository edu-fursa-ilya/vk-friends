package com.fursa.ilya.db;

import com.fursa.ilya.pojo.Friend;

import java.sql.SQLException;

public interface DatabaseWorker {

    public void addFriend(Friend friend) throws SQLException, ClassNotFoundException;

    public boolean deleteFriend(int id);
}
