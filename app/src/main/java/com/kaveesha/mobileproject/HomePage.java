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

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        getSupportActionBar().setTitle("Home Workouts");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView gifImageView = findViewById(R.id.gifone);
        ImageView gifImageView2 = findViewById(R.id.giftwo);
        ImageView gifImageView3 = findViewById(R.id.gifthree);
        ImageView gifImageView4 = findViewById(R.id.giffour);

        // Load the GIF image using Glide and start the animation

        Glide.with(this)
                .load(R.drawable.jumping_squats)
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
                .load(R.drawable.shoulder_stretch)
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
                .load(R.drawable.frog_press)
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
        Glide.with(this)
                .load(R.drawable.seated_abs_circles)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(new DrawableImageViewTarget(gifImageView4) {
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
