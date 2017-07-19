package com.fursa.ilya.db;

import com.fursa.ilya.pojo.Friend;
import com.fursa.ilya.pojo.Mutual;

import java.sql.SQLException;

public interface DatabaseWorker {

    public void addFriend(Friend friend) throws SQLException, ClassNotFoundException;

    public void addMutualFriend(Mutual mutual) throws SQLException;

}
