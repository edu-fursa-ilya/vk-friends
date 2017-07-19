package com.fursa.ilya.http;


import com.fursa.ilya.db.DatabaseQueries;
import com.fursa.ilya.pojo.Friend;
import com.fursa.ilya.pojo.Mutual;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HttpMutualRequest {
    private static final String ACCESS_TOKEN = "****ACCESS-TOKEN*****";
    private DatabaseQueries databaseQueries;
    private String[] idsList;

    public void getMutualFriendsJSON(int sourceId, int targerId, double version) throws IOException, JSONException, SQLException, ClassNotFoundException {
        String request = "https://api.vk.com/method/friends.getMutual?source_uid="
                + sourceId + "&target_uid=" + targerId +
                "&access_token=" + ACCESS_TOKEN + "&version=" + version;
        OkHttpClient okHttpClient = new OkHttpClient();
        Request httpRequest = new Request.Builder()
                .url(request)
                .build();
        Response response = okHttpClient.newCall(httpRequest).execute();
        String answer = response.body().string();
        idsList = answer.replaceAll("\\D+", " ").trim().split(" ");
        databaseQueries = new DatabaseQueries();

        for (int i = 0; i < idsList.length; i++) {
            databaseQueries.addMutualFriend(new Mutual(sourceId, targerId, Integer.valueOf(idsList[i])));
        }

    }


}
