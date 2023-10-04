package com.example.prasadam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;

import android.content.Intent;

import com.example.prasadam.models.Temple;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    Temple[] temples;

    public MyAdapter(Context context, Temple[] temples) {
        this.context = context;
        this.temples = temples;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Temple temple = temples[position];

        holder.templeName.setText(temple.templeName);
        holder.templeTime.setText(temple.templeTime);
        holder.templeLocation.setText(temple.templeLocation);
        holder.templeDistance.setText(temple.templeDistance);
        holder.templeImage.setImageResource(temple.templeImage);

        holder.cardView.setOnClickListener(
            (view) -> {
                final Intent intent = new Intent(context, TempleDetailsActivity.class);
                intent.putExtra("temple", temple);
                context.startActivity(intent);
            }
        );
    }

    @Override
    public int getItemCount() {
        return temples.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView templeName;
        TextView templeTime;
        TextView templeLocation;
        TextView templeDistance;
        ImageView templeImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Log.i("CustomLog", "Root node in View holder = " + itemView);
            cardView = (CardView)itemView;
            templeName = itemView.findViewById(R.id.templeName);
            templeTime = itemView.findViewById(R.id.templeTiming);
            templeLocation = itemView.findViewById(R.id.templeLocation);
            templeDistance = itemView.findViewById(R.id.templeDistance);
            templeImage = itemView.findViewById(R.id.templeImage);

        }
    }
}
