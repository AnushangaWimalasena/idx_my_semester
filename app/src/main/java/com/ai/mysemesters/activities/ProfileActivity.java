package com.ai.mysemesters.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ai.mysemesters.R;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {

    String dataString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_home);
        dataString = getIntent().getStringExtra("data");
        TextView name = findViewById(R.id.name);
        TextView id = findViewById(R.id.eg_no);
        TextView email = findViewById(R.id.email);
        TextView dep = findViewById(R.id.department);
        TextView sem = findViewById(R.id.semester_no);
        TextView gpa = findViewById(R.id.gpa);
        try {
            JSONObject data = new JSONObject(dataString);
            name.setText(data.getString("name"));
            id.setText(data.getString("id"));
            email.setText(data.getString("e-mail"));
            dep.setText(data.getString("department"));
            sem.setText(String.valueOf(data.getInt("semester")));
            gpa.setText(data.getString("gpa"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void back(View view){
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }


}
