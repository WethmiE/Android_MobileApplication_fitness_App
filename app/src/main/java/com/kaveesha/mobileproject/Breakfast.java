package com.kaveesha.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Breakfast extends AppCompatActivity {
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);

        //Action Bar
        getSupportActionBar().setTitle("Breakfast");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Select radio buttons

        radioGroup =findViewById(R.id.radioGroupBrekfast);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,int chekedButtonId) {
                switch(chekedButtonId){
                    case R.id.vegb:
                        Intent intent = new Intent(Breakfast.this, Veg.class);
                        startActivity(intent);
                        break;
                    case R.id.nonvegb:
                        Intent intentl= new Intent(Breakfast.this,NonVeg.class);
                        startActivity(intentl);

                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + chekedButtonId);
                }

            }
        });

    }
}