package com.ai.mysemesters.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.ai.mysemesters.R;

public class MainActivity extends AppCompatActivity {

    Boolean isLogged;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences pref = getSharedPreferences("app_status",MODE_PRIVATE);
        isLogged = pref.getBoolean("is_logged",false);
        if(!pref.getBoolean("is_data_available",false)){
            String data = "{\n" +
                    "    \"assignments\" : {\n" +
                    "        \"Module 1\" :[\n" +
                    "            {\"assignment\": \"assignment one\", \"status\":false},\n" +
                    "            {\"assignment\": \"assignment two\", \"status\":false},\n" +
                    "            {\"assignment\": \"assignment three\", \"status\":false}  \n" +
                    "        ],\n" +
                    "        \"Module 2\" :[\n" +
                    "            {\"assignment\": \"assignment one\", \"status\":false},\n" +
                    "            {\"assignment\": \"assignment two\", \"status\":false},\n" +
                    "            {\"assignment\": \"assignment three\", \"status\":false}  \n" +
                    "        ],\n" +
                    "        \"Module 3\" :[\n" +
                    "            {\"assignment\": \"assignment one\", \"status\":false},\n" +
                    "            {\"assignment\": \"assignment two\", \"status\":false},\n" +
                    "            {\"assignment\": \"assignment three\", \"status\":false}  \n" +
                    "        ]\n" +
                    "    }\n" +
                    "}";
            SharedPreferences.Editor editor_app = getSharedPreferences("modules",MODE_PRIVATE).edit();
            editor_app.putString("assignment",data);
            editor_app.apply();
            SharedPreferences.Editor editor_status = getSharedPreferences("app_status",MODE_PRIVATE).edit();
            editor_status.putBoolean("is_data_available",true);
            editor_status.apply();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isLogged){
            Intent intent = new Intent(this,HomeActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }
    }
}
