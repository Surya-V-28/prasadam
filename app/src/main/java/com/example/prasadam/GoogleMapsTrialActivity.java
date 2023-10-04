package com.example.prasadam;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;

import com.example.prasadam.databinding.ActivityGoogleMapsTrialBinding;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.LatLng;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.FusedLocationProviderClient;

public class GoogleMapsTrialActivity extends AppCompatActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGoogleMapsTrialBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        locationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        getUIFromXML();

        setupGoogleMaps();
    }

    private void setupGoogleMaps() {
        mapFragment = SupportMapFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
            .add(R.id.mapFragmentContainer, mapFragment)
            .commit();

        mapFragment.getMapAsync(this::onMapReady);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        this.map = map;

        MarkerOptions centerMarkerOptions = new MarkerOptions()
            .position(new LatLng(0, 0))
            .title("Center");

        map.addMarker(centerMarkerOptions);

        final Location location;
        try {
             location = Tasks.await(locationProviderClient.getLastLocation());
        }
        catch(Exception exception) { return; }

        final MarkerOptions currentUserMarkerOptions = new MarkerOptions()
            .position( new LatLng(location.getLatitude(), location.getLongitude()) )
            .title("Current Location");
        map.addMarker(currentUserMarkerOptions);
    }


    private void getUIFromXML() { }

    private SupportMapFragment mapFragment = null;
    private GoogleMap map = null;
    
    private FusedLocationProviderClient locationProviderClient = null;

    private ActivityGoogleMapsTrialBinding binding;
}