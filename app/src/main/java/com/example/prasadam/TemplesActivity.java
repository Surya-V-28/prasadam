package com.example.prasadam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.prasadam.models.Temples;

public class TemplesActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temples);

        String religion = getIntent().getExtras().getString("Religion");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        if(religion.equals("Hindu")) {
            myAdapter = new MyAdapter(this, Temples.Hindu);
            recyclerView.setAdapter(myAdapter);
        }

        if(religion.equals("Muslim")) {
            myAdapter = new MyAdapter(this, Temples.Muslim);
            recyclerView.setAdapter(myAdapter);
        }

        if(religion.equals("Christian")) {
            myAdapter = new MyAdapter(this, Temples.Christian);
            recyclerView.setAdapter(myAdapter);
        }
    }
}