package com.fursa.ilya;

import com.fursa.ilya.db.DatabaseConnection;
import com.fursa.ilya.http.HttpRequest;
import com.fursa.ilya.pojo.Friend;
import org.json.JSONException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, JSONException, SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
    //    System.out.print("Please enter UID from VK.COM: ");
    //    int uid = sc.nextInt();

        HttpRequest request = new HttpRequest();
        List<Friend> response = request.parse(2);
        for (int i = 0; i < response.size(); i++) {
            System.out.println(response.get(i).toString() + "\n");
        }

    }
}
