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

public class CurrentSemesterHomeActivity extends AppCompatActivity {

    String data;
    JSONObject semester;
    LinearLayout layout;
    LayoutInflater inflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_semester_home);
        layout = findViewById(R.id.module_list);
        inflater =  LayoutInflater.from(CurrentSemesterHomeActivity.this);


        data = getIntent().getStringExtra("data");
        try {
         semester = new JSONObject(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONArray m;
        String [] modules = new String[0];
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
        try {
            m = semester.getJSONArray("modules");
            modules = new String[m.length()];
            for(int i = 0; i<m.length(); i++){
                modules[i] = m.getJSONObject(i).getString("id")+"\n"+m.getJSONObject(i).getString("name");
            }

            for(int i = 0; i<m.length(); i++){
                System.out.println(modules[i]);
                View list_item = inflater.inflate(R.layout.grid_item, layout, false);
                TextView textView = list_item.findViewById(R.id.tv_grid);
                int x = i%colors.length;
                textView.setId(i);
                textView.setBackgroundColor(getResources().getColor(colors[x]));
                textView.setText(modules[i]);
                layout.addView(list_item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void oneModuleShow(View view){
        int id = view.getId();
        System.out.println(id);

        try {
            JSONArray m = semester.getJSONArray("modules");

            //Select one module
            JSONObject obj = m.getJSONObject(id);
            Intent intent =  new Intent(this,CurrentSemesterOneModuleActivity.class);

            // Save current use module in SP
            SharedPreferences.Editor editor = getSharedPreferences("modules",MODE_PRIVATE).edit();
            editor.putString("lecture_times",obj.toString());
            editor.apply();

            SharedPreferences.Editor editor_app = getSharedPreferences("app_status",MODE_PRIVATE).edit();
            editor_app.putString("current_module",obj.getString("name"));
            editor_app.apply();

            //intent.putExtra("data",obj.toString());
            startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
