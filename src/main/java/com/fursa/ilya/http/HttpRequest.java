package com.fursa.ilya.http;

import com.fursa.ilya.db.DatabaseQueries;
import com.fursa.ilya.pojo.Friend;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HttpRequest {
    private String request = "https://api.vk.com/method/friends.get?user_id=";
    private String fields = "&fields=sex&v=5.52";
    private DatabaseQueries databaseQueries;

    public String getJSON(int uid) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request httpRequest = new Request.Builder()
                .url(request + uid + fields)
                .build();
        Response response = okHttpClient.newCall(httpRequest).execute();
        String answer = response.body().string();
        return answer;
    }

    public List<Friend> parseFriends(int uid) throws IOException, JSONException, SQLException, ClassNotFoundException {
        List<Friend> friends = new ArrayList<>();
        String json = getJSON(uid);
        JSONObject jsonObject = new JSONObject(json);
        parse(uid, friends, jsonObject);

        return friends;
    }

    private void parse(int uid, List<Friend> friends, JSONObject jsonObject) throws JSONException, SQLException, ClassNotFoundException {
        databaseQueries = new DatabaseQueries();

        JSONObject obj = jsonObject.getJSONObject("response");
        JSONArray jsonArray = obj.getJSONArray("items");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            Friend item = new Friend();
            item.setUid(object.getInt("id"));
            item.setFirstName(object.getString("first_name"));
            item.setLastName(object.getString("last_name"));
            item.setSex(object.getInt("sex"));
            item.setOwnerId(uid);
            databaseQueries.addFriend(item);
            friends.add(item);
        }
    }


}
