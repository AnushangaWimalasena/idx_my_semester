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

public class LecTimesActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_lec_times);
        layout = findViewById(R.id.layout);
        inflater = LayoutInflater.from(this);

        SharedPreferences pref = getSharedPreferences("modules",MODE_PRIVATE);
        String stringData =  pref.getString("lecture_times","");

        try {
            JSONObject dataObj = new JSONObject(stringData);
            JSONArray array =  dataObj.getJSONArray("lecTimes");

            for(int i= 0;i<array.length(); i++){

                JSONObject data = array.getJSONObject(i);
                String dateTimeString = data.getString("dateTime");
                String date = dateTimeString.split(" ",-2)[0];
                String time = dateTimeString.split(" ",-2)[1];

                System.out.println(date);
                System.out.println(time);

                View list_item = inflater.inflate(R.layout.lec_list_item,layout,false);

                list_item.setBackgroundColor(getResources().getColor(colors[i%16]));

                TextView tv_date = list_item.findViewById(R.id.lec_date);
                tv_date.setText(date);

                TextView tv_time = list_item.findViewById(R.id.lec_time);
                tv_time.setText(time);

                layout.addView(list_item);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void back(View view){
        Intent intent =  new Intent(this,CurrentSemesterOneModuleActivity.class);
        startActivity(intent);
    }
}
