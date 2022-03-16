package com.example.final_project;

// Arsam Firoozfar
import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtils {
    private static  String baseURL;

    static String getActivityInfo(String queryString){

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String JSONString = null;
        baseURL = "https://www.boredapi.com/api/activity";
        switch(queryString){
            case "education": baseURL = (new StringBuilder()).append(baseURL).append("?type=").append(queryString).toString();
                break;
            case "recreational": baseURL = (new StringBuilder()).append(baseURL).append("?type=").append(queryString).toString();
                break;
            case "social": baseURL = (new StringBuilder()).append(baseURL).append("?type=").append(queryString).toString();
                break;
            case "diy": baseURL = (new StringBuilder()).append(baseURL).append("?type=").append(queryString).toString();
                break;
            case "charity": baseURL = (new StringBuilder()).append(baseURL).append("?type=").append(queryString).toString();
                break;
            case "cooking": baseURL = (new StringBuilder()).append(baseURL).append("?type=").append(queryString).toString();
                break;
            case "relaxation": baseURL = (new StringBuilder()).append(baseURL).append("?type=").append(queryString).toString();
                break;
            case "music": baseURL = (new StringBuilder()).append(baseURL).append("?type=").append(queryString).toString();;
                break;
            case "busywork" : baseURL = (new StringBuilder()).append(baseURL).append("?type=").append(queryString).toString();
                break;
            default: baseURL = "https://www.boredapi.com/api/activity/";
                break;
        }

        try {

            URL requestURL = new URL(baseURL);
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Get the InputStream.
            InputStream inputStream = urlConnection.getInputStream();
            // Create a buffered reader from that input stream.
            reader = new BufferedReader(new InputStreamReader(inputStream));

            JSONString = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return JSONString;
    }

}
