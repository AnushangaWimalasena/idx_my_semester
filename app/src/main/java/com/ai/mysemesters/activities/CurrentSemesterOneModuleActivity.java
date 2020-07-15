package com.ai.mysemesters.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ai.mysemesters.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CurrentSemesterOneModuleActivity extends AppCompatActivity {

    TextView module_name;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_semester_one_module);
        SharedPreferences pref = getSharedPreferences("app_status",MODE_PRIVATE);
        name = pref.getString("current_module","");
        module_name = findViewById(R.id.module_name);
        module_name.setText(name);
    }

    public void lecTimes(View view){
        Intent intent =  new Intent(this,LecTimesActivity.class);
        startActivity(intent);
    }

    public void assignments(View view){
        Intent intent = new Intent(this,AssignmentActivity.class);
        startActivity(intent);
    }

    public void extraNotes(View view){
        Intent intent = new Intent(this,ExtraNotesActivity.class);
        startActivity(intent);
    }
}
