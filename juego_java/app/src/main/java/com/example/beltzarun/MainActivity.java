package com.example.beltzarun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import Data.Highscore;
import PostgreSQL.Database;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Employee> employees;
    public static int Highscore;

    public static boolean SpinnerCompleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean connected = false;
        setContentView(R.layout.activity_main);
        Button online_jokatu = findViewById(R.id.online_jokatu);
        online_jokatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Choose_player_data.class));
            }
        });

        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
            Database db = new Database();

        }
        else{
            connected = false;
            setContentView(R.layout.activity_main);

            findViewById(R.id.Play).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,GameActivity.class));
                }
            });
        }

    }

    }
