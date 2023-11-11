package com.kaveesha.mobileproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class DietPlans extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plans);
        getSupportActionBar().setTitle("Diet Plans");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Button for Breakfast

        Button button1= findViewById(R.id.breakfast);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(DietPlans.this,Breakfast.class);
                startActivity(intent);
            }
        });

        //Other buttons not created
    }
}