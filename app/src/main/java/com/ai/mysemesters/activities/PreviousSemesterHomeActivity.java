package com.ai.mysemesters.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ai.mysemesters.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PreviousSemesterHomeActivity extends AppCompatActivity {

    LinearLayout layout;
    LayoutInflater inflater;
    String dataString;

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
        setContentView(R.layout.activity_previous_semester_home);

        dataString = getIntent().getStringExtra("data");

        inflater = LayoutInflater.from(PreviousSemesterHomeActivity.this);
        layout = findViewById(R.id.layout);

        try {
            JSONArray dataArray = new JSONArray(dataString);

            for(int i = 0; i<dataArray.length(); i++){
                View item = inflater.inflate(R.layout.semester_list, layout, false);
                TextView semester_name = item.findViewById(R.id.semester_name);
                item.setId(i);

                String name = String.valueOf(dataArray.getJSONObject(i).getInt("semester"));

                semester_name.setText(getResources().getText(R.string.semester)+ " "+name);

                layout.addView(item);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void showPreviousSemester(View view){
        int id = view.getId();
        try {
            JSONArray array = new JSONArray(dataString);
            JSONObject object =  array.getJSONObject(id);

            Intent intent = new Intent(this,PreviousOneSemesterActivity.class);
            intent.putExtra("data",object.toString());
            startActivity(intent);
            
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
