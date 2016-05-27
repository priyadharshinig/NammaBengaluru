package com.example.priyadharshini.nammabengaluru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private double lat = 30;
    private double longi = 32;
    private String location ="Bangalore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bundle b = getIntent().getExtras();

        if(b != null) {
            lat = b.getDouble("lat");
            longi = b.getDouble("longitude");
            location = b.getString("location");
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng l = new LatLng(lat, longi);
        mMap.addMarker(new MarkerOptions().position(l).title(location));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, longi), 30.0f));
    }
}
