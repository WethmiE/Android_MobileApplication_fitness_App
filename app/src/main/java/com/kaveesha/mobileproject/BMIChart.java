package com.kaveesha.mobileproject;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BMIChart extends AppCompatActivity {

    private EditText editTextWeight, editTextHeight;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmichart);

        //Action Bar
        getSupportActionBar().setTitle("BMI Calculator");

        //exit button
        Button button1= findViewById(R.id.exitbutton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(BMIChart.this,dashboard.class);
                startActivity(intent);
            }
        });

        // Initialize views
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        textViewResult = findViewById(R.id.textViewResult);

        // Set click listener for the calculate button
        Button buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        // Get weight and height input as strings
        String weightText = editTextWeight.getText().toString();
        String heightText = editTextHeight.getText().toString();

        // Check if weight and height are provided
        if (weightText.isEmpty() || heightText.isEmpty()) {
            textViewResult.setText("Please enter weight and height.");
            return;
        }

        // Parse weight and height from strings to float values
        float weight = Float.parseFloat(weightText);
        float height = Float.parseFloat(heightText) / 100; // Convert cm to meters

        // Calculate BMI
        float bmi = weight / (height * height);

        // Determine the BMI category based on the calculated value
        String resultText;

        if (bmi < 18.5) {
            resultText = "Underweight";
        } else if (bmi < 25) {
            resultText = "Normal weight";
        } else if (bmi < 30) {
            resultText = "Overweight";
        } else {
            resultText = "Obese";
        }

        // Format the result and display it in the result TextView
        resultText = "BMI: " + String.format("%.1f", bmi) + "\n" + resultText;
        textViewResult.setText(resultText);
    }
}
