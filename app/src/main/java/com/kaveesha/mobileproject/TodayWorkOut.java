package com.kaveesha.mobileproject;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import android.widget.Button;

public class TodayWorkOut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_work_out);

        //Action Bar
        getSupportActionBar().setTitle("Today Workout Plan");

        //Exit button
        Button button1= findViewById(R.id.exitbutton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(TodayWorkOut.this,dashboard.class);
                startActivity(intent);
            }
        });

        ImageView gifImageView = findViewById(R.id.gif1);
        ImageView gifImageView2 = findViewById(R.id.gif2);
        ImageView gifImageView3 = findViewById(R.id.gif3);

        // Load the GIF image using Glide and start the animation

        Glide.with(this)
                .load(R.drawable.t_jumping_jack_one)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(new DrawableImageViewTarget(gifImageView) {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        super.onResourceReady(resource, transition);
                        if (resource instanceof GifDrawable) {
                            ((GifDrawable) resource).setLoopCount(GifDrawable.LOOP_FOREVER);
                            ((GifDrawable) resource).start();
                        }
                    }
                });

        Glide.with(this)
                .load(R.drawable.t_squat_kicks_two)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(new DrawableImageViewTarget(gifImageView2) {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        super.onResourceReady(resource, transition);
                        if (resource instanceof GifDrawable) {
                            ((GifDrawable) resource).setLoopCount(GifDrawable.LOOP_FOREVER);
                            ((GifDrawable) resource).start();
                        }
                    }
                });
        Glide.with(this)
                .load(R.drawable.push_ups)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(new DrawableImageViewTarget(gifImageView3) {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        super.onResourceReady(resource, transition);
                        if (resource instanceof GifDrawable) {
                            ((GifDrawable) resource).setLoopCount(GifDrawable.LOOP_FOREVER);
                            ((GifDrawable) resource).start();
                        }
                    }
                });
    }
}
