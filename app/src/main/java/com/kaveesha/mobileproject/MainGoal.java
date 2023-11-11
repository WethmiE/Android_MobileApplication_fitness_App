package com.kaveesha.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainGoal extends AppCompatActivity {
    private RadioGroup radioGroup;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_goal);
        getSupportActionBar().setTitle("Select your Main goal");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView=findViewById(R.id.imageView2);
        //nextpage
        Button button = findViewById(R.id.signup3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainGoal.this, ActivityLevel.class);
                startActivity(intent);
            }
        });

        radioGroup = findViewById(R.id.radioGroupGoal);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(RadioGroup radioGroup, int checkedButtonId) {
                                                      switch (checkedButtonId) {
                                                          case R.id.lose:
                                                              imageView.setImageDrawable(getResources().getDrawable(R.drawable.loseweight));
                                                              break;
                                                          case R.id.Gain:
                                                              imageView.setImageDrawable(getResources().getDrawable(R.drawable.gainweight));
                                                              break;
                                                          case R.id.fit:
                                                              imageView.setImageDrawable(getResources().getDrawable(R.drawable.keepfit));
                                                              break;
                                                      }

                                                  }
                                              }
        );

    }
}