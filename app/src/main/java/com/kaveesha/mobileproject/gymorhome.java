package com.kaveesha.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class gymorhome extends AppCompatActivity {
    private RadioGroup radioGroup;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gymorhome);

        getSupportActionBar().setTitle("Select Gym or Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView=findViewById(R.id.imageView);
        Button button= findViewById(R.id.gymHomeNext);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(gymorhome.this,dashboard.class);
                startActivity(intent);
                /*final String maleText = male.getText().toString();
                final String femaleText = female.getText().toString();*/
            }
        });
        radioGroup =findViewById(R.id.radioGroupGymorHome);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,int chekedButtonId) {
                switch(chekedButtonId){
                    case R.id.gym:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.gympic));
                        /*databaseReference.child("users").child(String.valueOf(male)).child("name").setValue(male);
                        startActivity(new Intent(Gender. this,RegiDetails.class));
                        finish();*/
                        break;
                    case R.id.home:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.homegym));
                        /*databaseReference.child("users").child(String.valueOf(female)).child("name").setValue(female);
                        startActivity(new Intent(Gender. this,RegiDetails.class));
                        finish();*/
                        break;
                }

            }
        });
    }
}