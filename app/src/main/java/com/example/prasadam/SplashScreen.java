package com.example.prasadam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        MotionLayout motionLayout = findViewById(R.id.motionLayout);
        motionLayout.setTransitionListener(new MotionLayout.TransitionListener() {

            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int startId, int endId) {

            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress) {

            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int currentId) {
                Toast.makeText(SplashScreen.this, "Splash Screen Over", Toast.LENGTH_LONG).show();
                Intent i;
                i = new Intent(SplashScreen.this, LottieAnimationActivity.class);
                startActivity(i);
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive, float progress) {

            }
        });
    }
}