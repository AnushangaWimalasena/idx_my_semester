package com.ai.mysemesters.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ai.mysemesters.R;

public class HomeActivity extends AppCompatActivity {

    String previousSemesters = "[\n" +
            "    {\n" +
            "        \"semester\" : 1,\n" +
            "        \"GPA\" : 4.00,\n" +
            "        \"total_credits\" : 8,\n" +
            "        \"modules\" : [{\n" +
            "            \"name\" : \"1201 Module 1\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\" : \"1202 Module 2\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\" : \"1203 Module 3\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\" : \"1204 Module 4\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        }\n" +
            "    ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"semester\" : 2,\n" +
            "        \"GPA\" : 4.00,\n" +
            "        \"total_credits\" : 8,\n" +
            "        \"modules\" : [{\n" +
            "            \"name\" : \"2201 Module 1\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\" : \"2202 Module 2\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\" : \"2203 Module 3\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\" : \"2204 Module 4\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        }\n" +
            "    ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"semester\" : 3,\n" +
            "        \"GPA\" : 4.00,\n" +
            "        \"total_credits\" : 8,\n" +
            "        \"modules\" : [{\n" +
            "            \"name\" : \"3201 Module 1\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\" : \"3202 Module 2\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\" : \"3203 Module 3\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\" : \"3204 Module 4\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        }\n" +
            "    ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"semester\" : 4,\n" +
            "        \"GPA\" : 4.00,\n" +
            "        \"total_credits\" : 8,\n" +
            "        \"modules\" : [{\n" +
            "            \"name\" : \"4201 Module 1\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\" : \"4202 Module 2\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\" : \"4203 Module 3\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\" : \"4204 Module 4\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        }\n" +
            "    ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"semester\" : 5,\n" +
            "        \"GPA\" : 4.00,\n" +
            "        \"total_credits\" : 8,\n" +
            "        \"modules\" : [{\n" +
            "            \"name\" : \"5201 Module 1\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\" : \"5202 Module 2\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\" : \"5203 Module 3\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\" : \"5204 Module 4\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        }\n" +
            "    ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"semester\" : 6,\n" +
            "        \"GPA\" : 4.00,\n" +
            "        \"total_credits\" : 8,\n" +
            "        \"modules\" : [{\n" +
            "            \"name\" : \"6201 Module 1\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\" : \"6202 Module 2\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\" : \"6203 Module 3\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\" : \"6204 Module 4\",\n" +
            "            \"grade\" : \"A\"\n" +
            "        }\n" +
            "    ]\n" +
            "    }\n" +
            "]";

    String currentModules = "{ \n" +
            "\"semester\" : 7, \n" +
            "   \"week\" : 2, \n" +
            "\"modules\" : [\n" +
            "    { \"name\": \"Module 1\", \"id\": \"7201\", \"lecHours\": 28, \"lecTimes\": [{ \"dateTime\": \"07.12.2020 09:00:00\" }, { \"dateTime\": \"07.13.2020 09:00:00\" }, { \"dateTime\": \"07.14.2020 09:00:00\" }] },\n" +
            "    { \"name\": \"Module 2\", \"id\": \"7202\", \"lecHours\": 28, \"lecTimes\": [{ \"dateTime\": \"07.12.2020 10:00:00\" }, { \"dateTime\": \"07.13.2020 10:00:00\" }, { \"dateTime\": \"07.14.2020 10:00:00\" }] }, \n" +
            "    { \"name\": \"Module 3\", \"id\": \"7203\", \"lecHours\": 28, \"lecTimes\": [{ \"dateTime\": \"07.12.2020 11:00:00\" }, { \"dateTime\": \"07.13.2020 11:00:00\" }, { \"dateTime\": \"07.14.2020 11:00:00\" }] }\n" +
            "    ] \n" +
            "}";

    String user = "{\n" +
            "    \"name\" : \"Wimalasena DCVA\",\n" +
            "    \"id\" : \"EG3025\",\n" +
            "    \"e-mail\" : \"anushanga@gmail.com\",\n" +
            "    \"semester\": 7,\n" +
            "    \"gpa\" : \"3.5\",\n" +
            "    \"department\" : \"EIE\"\n" +
            "}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void currentSemester(View view){
        Intent intent = new Intent(this,CurrentSemesterHomeActivity.class);
        intent.putExtra("data", currentModules );
        startActivity(intent);
    }

    public void previousSemester(View view){
        Intent intent = new Intent(this,PreviousSemesterHomeActivity.class);
        intent.putExtra("data",previousSemesters);
        startActivity(intent);
    }

    public void profile(View view){
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("data",user);
        startActivity(intent);
    }

}

