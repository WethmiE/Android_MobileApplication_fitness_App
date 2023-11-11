package com.kaveesha.mobileproject;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.transition.Transition;

public class GymPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_page);

        getSupportActionBar().setTitle("Gym Workouts");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView gifImageView = findViewById(R.id.gif1);
        ImageView gifImageView2 = findViewById(R.id.gif2);
        ImageView gifImageView3 = findViewById(R.id.gif3);

        // Load the GIF image using Glide and start the animation
        Glide.with(this)
                .load(R.drawable.arms_workout)
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
                .load(R.drawable.treadmill_workout_running)
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
                .load(R.drawable.leg_press)
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
