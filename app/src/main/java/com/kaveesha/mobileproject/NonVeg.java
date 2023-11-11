package com.kaveesha.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NonVeg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_veg);
        getSupportActionBar().setTitle("Non Vegetarian");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}