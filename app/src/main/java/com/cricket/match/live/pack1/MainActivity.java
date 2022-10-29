package com.cricket.match.live.pack1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.bumptech.glide.Glide;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
    GifImageView image1;
    private static int SPLASH_SCREEN_TIME_OUT=5000;

    Animation topanimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1 = findViewById(R.id.image1);



        topanimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        image1.setAnimation(topanimation);



        Glide.with(this).load(R.drawable.ball1).into(image1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
            }
        },SPLASH_SCREEN_TIME_OUT);

    }
}