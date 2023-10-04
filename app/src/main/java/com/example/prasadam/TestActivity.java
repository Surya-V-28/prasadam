package com.example.prasadam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.prasadam.databinding.ActivityTestBinding;
import com.example.prasadam.models.Temples;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.openTempleDetailsPageButton.setOnClickListener(
            (view) -> {
                final Intent intent = new Intent(this, TempleDetailsActivity.class);
                intent.putExtra("temple", Temples.Christian[0]);
                startActivity(intent);
            }
        );
    }


    private ActivityTestBinding binding = null;
}