package com.fursa.ilya;

import com.fursa.ilya.http.HttpFriendsRequest;
import com.fursa.ilya.http.HttpMutualRequest;
import com.fursa.ilya.pojo.Friend;
import org.json.JSONException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, JSONException, SQLException, ClassNotFoundException {
        HttpFriendsRequest request = new HttpFriendsRequest();
        //  List<Friend> user1 = request.parseFriends(11111111);
        //   List<Friend> user2 = request.parseFriends(2);

        HttpMutualRequest httpMutualRequest = new HttpMutualRequest();
        httpMutualRequest.getMutualFriendsJSON(6492, 2745, 5.65);

    }
}
