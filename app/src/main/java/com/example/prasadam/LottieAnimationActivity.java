package com.example.prasadam;

import static com.example.prasadam.R.id.lottile_animation_view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class LottieAnimationActivity extends AppCompatActivity {

   LottieAnimationView lottieAnimationView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie_animation);
        Toast.makeText(LottieAnimationActivity.this,"Lottie animation",Toast.LENGTH_LONG).show();
        lottieAnimationView = findViewById(R.id.lottile_animation_view);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LottieAnimationActivity.this,MainActivity.class);
                startActivity(intent);
            }
        },4000);

    }
}