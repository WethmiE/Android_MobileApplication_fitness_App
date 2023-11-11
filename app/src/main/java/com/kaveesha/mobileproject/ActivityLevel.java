package com.kaveesha.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ActivityLevel extends AppCompatActivity {

    private RadioGroup radioGroup;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        getSupportActionBar().setTitle("Select Your Activity Level");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView = findViewById(R.id.imageActive);

        // Next page
        Button button = findViewById(R.id.signup4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (checkedRadioButtonId != -1) {
                    Intent intent = new Intent(ActivityLevel.this, gymorhome.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ActivityLevel.this, "Please select an activity level", Toast.LENGTH_SHORT).show();
                }
            }
        });
         //Select radio button
        radioGroup = findViewById(R.id.radioGroupLevel);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedButtonId) {
                RadioButton radioButton = findViewById(checkedButtonId);
                switch (checkedButtonId) {
                    case R.id.sedentary:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.sendentary));
                        break;
                    case R.id.LowAc:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.lawact));
                        break;
                    case R.id.Moderate:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.moderate));
                        break;
                    case R.id.hight:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.highly));
                        break;
                }
            }
        });
    }
}
