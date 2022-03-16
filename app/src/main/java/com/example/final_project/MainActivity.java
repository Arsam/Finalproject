package com.example.final_project;

// Arsam Firoozfar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements itemAdapter.ListItemClickListener{
    public static final String EXTRA_MESSAGE = "com.example.final_project.MESSAGE";
    public static ArrayList<ActivityObject> activityArray = new ArrayList<ActivityObject>();
    private EditText activityInput;
    private static String queryString;
    private TextView mInstruction;
    private Button button;
    public static ProgressBar progressBar;
    public static itemAdapter mAdapter;
    public static RecyclerView mItemList;
    private static final int numberOfItems = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityInput = (EditText)findViewById(R.id.activityinput);
        button = (Button)findViewById(R.id.searchButton);
        mInstruction = (TextView)findViewById(R.id.instructions);
        progressBar  = (ProgressBar) findViewById(R.id.progressBar);
        mItemList = (RecyclerView) findViewById(R.id.recyclerViewItems);

    }

    public void searchActivities(View view) {
        //Get the queryString and execute GetActivity 20 times
        queryString = activityInput.getText().toString();

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected()) {
            progressBar.setVisibility(View.VISIBLE);
            for(int i = 0;i < 20;i++)
                new GetActivity().execute(queryString);
        }

        //display the RecyclerView

            button.setVisibility(View.INVISIBLE);
            activityInput.setVisibility(View.INVISIBLE);
            mInstruction.setVisibility(View.INVISIBLE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            mItemList.setLayoutManager(layoutManager);
            mItemList.setHasFixedSize(true);
            mAdapter = new itemAdapter(numberOfItems, this);


    }

    @Override
    public void onListItemClick(int i, View itemView) {
        //display the data for the ActivityObject inside the RecyclerView
        //After clicking on the viewHolder
        String activityInfo = (new StringBuilder()).append(activityArray.get(i).activity)
                .append("\n").append(activityArray.get(i).accessibility).append("\n").append(activityArray.get(i).type)
                .append("\n").append(activityArray.get(i).participants).append("\n").append(activityArray.get(i).price)
                .append("\n").append(activityArray.get(i).link).append("\n").append(activityArray.get(i).key).toString();
        Intent intent = new Intent(this, modelDetailPage.class);
        intent.putExtra(EXTRA_MESSAGE, activityInfo);
        startActivity(intent);
    }
}