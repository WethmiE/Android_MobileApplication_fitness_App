package com.kaveesha.mobileproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Veg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg);
        getSupportActionBar().setTitle("Vegetarian");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
/*import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Veg extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg);

        ImageView imageView1 = findViewById(R.id.imageView1);
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageView imageView3 = findViewById(R.id.imageView3);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enlargeImage(R.drawable.smo);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enlargeImage(R.drawable.vegb);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enlargeImage(R.drawable.vegbb);
            }
        });
    }

    private void enlargeImage(int imageResId) {
        // Perform actions to enlarge the clicked image
        // For example, you can display a larger image in a dialog or start a new activity to show the enlarged image
        Toast.makeText(this, "Enlarging image: " + getResources().getResourceEntryName(imageResId), Toast.LENGTH_SHORT).show();
    }
}*/
