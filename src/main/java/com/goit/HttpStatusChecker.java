package com.goit;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    String getStatusImage(int code) {
        String url = "https://http.cat/" + code + ".jpg";
        HttpURLConnection connection;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            int resCode = connection.getResponseCode();
            if(resCode == HttpURLConnection.HTTP_OK)
                return url;
            else{
                throw new RuntimeException("Error 404");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
