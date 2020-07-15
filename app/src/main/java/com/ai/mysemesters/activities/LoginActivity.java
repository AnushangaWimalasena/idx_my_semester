package com.ai.mysemesters.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ai.mysemesters.R;

import java.sql.SQLOutput;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    String username_str;
    String password_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
    }

    public void login(View view){
        username_str = username.getText().toString();
        password_str = password.getText().toString();
        System.out.println(username_str);
        System.out.println(password_str);
        if(username_str.equals("eg5060")&&password_str.equals("1234")){
            SharedPreferences.Editor editor = getSharedPreferences("app_status",MODE_PRIVATE).edit();
            editor.putBoolean("is_logged",true);
            editor.apply();
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else {
            username.setText("");
            password.setText("");
        }
    }
}
