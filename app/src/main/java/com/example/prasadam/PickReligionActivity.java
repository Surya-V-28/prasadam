package com.example.prasadam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PickReligionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_religion);

        CardView hinduButton = findViewById(R.id.hinduButton);
        CardView MuslimButton = findViewById(R.id.muslimButton);
        CardView ChristianButton = findViewById(R.id.christianButton);

        hinduButton.setOnClickListener(view -> {
            Intent i = new Intent(this, TemplesActivity.class);
            i.putExtra("Religion", "Hindu");
            startActivity(i);
        });

        MuslimButton.setOnClickListener(view -> {
            Intent i = new Intent(this, TemplesActivity.class);
            i.putExtra("Religion", "Muslim");
            startActivity(i);
        });

        ChristianButton.setOnClickListener(view -> {
            Intent i = new Intent(this, TemplesActivity.class);
            i.putExtra("Religion", "Christian");
            startActivity(i);
        });
    }
}