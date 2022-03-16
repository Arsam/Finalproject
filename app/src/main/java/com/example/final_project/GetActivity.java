package com.example.final_project;

//Arsam Firoozfar
import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;


public class GetActivity extends AsyncTask<String, Void, String> {


    @Override
    protected String doInBackground(String... strings) {

        return NetworkUtils.getActivityInfo(strings[0]);
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            String activityName =(new StringBuilder()).append("activity: ").append(jsonObject.getString("activity")).toString();
            String accessibilityName = (new StringBuilder()).append("accessibility: ").append(jsonObject.getString("accessibility")).toString();
            String typeName = (new StringBuilder()).append("type: ").append(jsonObject.getString("type")).toString();
            String participantsName = (new StringBuilder()).append("participants: ").append(jsonObject.getString("participants")).toString();
            String priceName = (new StringBuilder()).append("price: ").append(jsonObject.getString("price")).toString();
            String linkName = (new StringBuilder()).append("link: ").append(jsonObject.getString("link")).toString();
            String keyName = (new StringBuilder()).append("key: ").append(jsonObject.getString("key")).toString();
            MainActivity.activityArray.add(new ActivityObject(activityName,accessibilityName,typeName,participantsName,priceName,linkName,keyName));
        } catch (JSONException e) {

            e.printStackTrace();
        }
    }
}
