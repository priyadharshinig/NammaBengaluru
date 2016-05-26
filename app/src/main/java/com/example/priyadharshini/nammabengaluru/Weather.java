package com.example.priyadharshini.nammabengaluru;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Weather extends AppCompatActivity {

    LocationTracker locationTracker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        locationTracker = new LocationTracker();
        double latitude = locationTracker.latitude;
        double longitude = locationTracker.longitude;
        final TextView textA = (TextView) findViewById(R.id.lat);
        textA.setText(latitude+"");
        final TextView text = (TextView) findViewById(R.id.longitude);
        textA.setText(longitude+"");

    }





}
