package com.example.prasadam;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class ProcessInddicatorActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_inddicator);
        lottieAnimationView = findViewById(R.id.lottile_animation_view_loading);
        Toast.makeText(ProcessInddicatorActivity.this,"process animation",Toast.LENGTH_LONG).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ProcessInddicatorActivity.this,PickReligionActivity.class);
                startActivity(intent);
            }
        },4000);
    }

}

