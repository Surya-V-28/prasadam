package com.example.prasadam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.prasadam.databinding.ActivityTempleDetailsBinding;
import com.example.prasadam.models.Temple;

import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class TempleDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTempleDetailsBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        temple = (Temple) getIntent().getSerializableExtra("temple");

        binding.nameLabel.setText(temple.templeName);
        binding.addressLabel.setText(temple.address.toString());
        binding.distanceValueLabel.setText(temple.templeDistance);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("My Notification","Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager= getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        binding.showDirectionsButton.setOnClickListener(
            (view) -> {

                Toast.makeText(this,"welcome",Toast.LENGTH_LONG).show();
                NotificationCompat.Builder bulider=new NotificationCompat.Builder(this,"My Notification");
                bulider.setContentTitle("Notifications  SUPPORT");
                bulider.setContentText("fetching directions ");
                bulider.setSmallIcon(R.drawable.ic_launcher_background);
                bulider.setAutoCancel(true);
                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(this);
                managerCompat.notify(1,bulider.build());

                final Uri uri = Uri.parse("https://www.google.com/maps/dir/")
                    .buildUpon()
                    .appendQueryParameter("api", "1")
                    .appendQueryParameter("destination", "Sri Krishna Temple")
                    .appendQueryParameter("destination_place_id", temple.mapId)
                    .build();

                Log.i("CustomLog", "Uri = " + uri.toString());


                final Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        );
    }


    private ActivityTempleDetailsBinding binding = null;
    private Temple temple = null;
}