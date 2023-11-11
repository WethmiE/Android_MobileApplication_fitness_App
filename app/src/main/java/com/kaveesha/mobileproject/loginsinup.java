package com.kaveesha.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
public class loginsinup extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private  Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN  );
        getSupportActionBar().hide(); *///hide  actionbar
        setContentView(R.layout.activity_loginsinup);
        getSupportActionBar().setTitle("Login and SignUp");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        button1= findViewById(R.id.signup);
        button2 = findViewById(R.id.login);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(loginsinup.this,Register.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(loginsinup.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}