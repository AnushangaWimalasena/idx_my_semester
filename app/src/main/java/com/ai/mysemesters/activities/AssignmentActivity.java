package com.ai.mysemesters.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ai.mysemesters.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AssignmentActivity extends AppCompatActivity {

    String stringData;
    LinearLayout layout;
    LayoutInflater inflater;
    Integer [] colors = {
            R.color.purple ,
            R.color.indigo ,
            R.color.cyan ,
            R.color.teal ,
            R.color.green ,
            R.color.light_green ,
            R.color.lime ,
            R.color.yellow ,
            R.color.amber ,
            R.color.orange ,
            R.color.deep_orange ,
            R.color.brown ,
            R.color.green ,
            R.color.blue_grey ,
            R.color.red ,
            R.color.pink ,
            R.color.deer_purple
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        inflater = LayoutInflater.from(AssignmentActivity.this);
        layout = findViewById(R.id.layout_ass);

        SharedPreferences pref  =  getSharedPreferences("modules", MODE_PRIVATE);
        stringData = pref.getString("assignment","");
        System.out.println(stringData);
        try {
            JSONObject obj = new JSONObject(stringData);
            JSONObject assignments = obj.getJSONObject("assignments");

            SharedPreferences prefName = getSharedPreferences("app_status",MODE_PRIVATE);
            String name = prefName.getString("current_module","");

            JSONArray array = assignments.getJSONArray(name);
            for ( int i = 0; i<array.length(); i++){
                JSONObject object = array.getJSONObject(i);

                View item = inflater.inflate(R.layout.assignment_list,layout,false);
                TextView tv_ass = item.findViewById(R.id.assignment_txt);
                tv_ass.setText(object.getString("assignment"));

                TextView tv_stat = item.findViewById(R.id.assignment_status);
                if(object.getBoolean("status")){
                    tv_stat.setText(getResources().getText(R.string.completed));
                } else {
                    tv_stat.setText(getResources().getText(R.string.pending));
                }

                layout.addView(item);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void back(View view){
        Intent intent = new Intent(this,CurrentSemesterOneModuleActivity.class);
        startActivity(intent);
    }


}
