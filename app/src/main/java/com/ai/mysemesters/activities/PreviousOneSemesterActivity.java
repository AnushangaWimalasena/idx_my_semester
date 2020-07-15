package com.ai.mysemesters.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ai.mysemesters.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class PreviousOneSemesterActivity extends AppCompatActivity {

    String dataString;
    LinearLayout layout;
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_one_semester);

        inflater = LayoutInflater.from(PreviousOneSemesterActivity.this);
        layout = findViewById(R.id.layout);

        dataString = getIntent().getStringExtra("data");

        System.out.println(dataString);

        TextView semester_name = findViewById(R.id.semester_no);
        TextView gpa = findViewById(R.id.gpa);
        TextView total_credit = findViewById(R.id.total_credit);

        try {
            JSONObject semester_obj = new JSONObject(dataString);
            semester_name.setText(semester_obj.getString("semester"));
            gpa.setText(semester_obj.getString("GPA"));
            total_credit.setText(semester_obj.getString("total_credits"));

            JSONArray array = semester_obj.getJSONArray("modules");

            for(int i =0; i<array.length(); i++){
                JSONObject object = array.getJSONObject(i);

                View item = inflater.inflate(R.layout.module_list,layout,false);
                TextView module_name = item.findViewById(R.id.module_name);
                TextView module_grade = item.findViewById(R.id.module_grade);

                module_name.setText(object.getString("name"));
                module_grade.setText(object.getString("grade"));

                layout.addView(item);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
