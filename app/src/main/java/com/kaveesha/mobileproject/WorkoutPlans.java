package com.kaveesha.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.RadioGroup;

import android.os.Bundle;

public class WorkoutPlans extends AppCompatActivity {

    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_plans);

        getSupportActionBar().setTitle("Workout Plans");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        radioGroup =findViewById(R.id.radioworkout);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,int chekedButtonId) {
                switch(chekedButtonId){
                    case R.id.gymW:
                        Intent intent = new Intent(WorkoutPlans.this, GymPage.class);
                        startActivity(intent);
                        break;
                    case R.id.homeW:
                        Intent intentl= new Intent(WorkoutPlans.this,HomePage.class);
                        startActivity(intentl);

                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + chekedButtonId);
                }

            }
        });
    }
}