package com.example.priyadharshini.nammabengaluru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.priyadharshini.nammabengaluru.adapters.PlacesToVisitAdapter;
import com.example.priyadharshini.nammabengaluru.models.PlaceInfo;

import java.util.ArrayList;
import java.util.List;

public class PlacesToVisit extends AppCompatActivity {

    List<PlaceInfo> places;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_to_visit);

        RecyclerView contactsRecyclerView = (RecyclerView) findViewById(R.id.list_view);

        if (contactsRecyclerView != null) {
            List<PlaceInfo> places = getPlaces();
            PlacesToVisitAdapter contactsAdapter = new PlacesToVisitAdapter(places);
            contactsRecyclerView.setAdapter(contactsAdapter);
            contactsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

    }

    public void locate(View view) {

        Button tv = (Button) view;
        Double latitude = (Double) tv.getTag(R.string.latitude);
        Double longitude = (Double) tv.getTag(R.string.longitude);
        String location = (String) tv.getTag(R.string.location);

        Intent map = new Intent(PlacesToVisit.this, MapsActivity.class);
        Bundle b = new Bundle();


        b.putDouble("latitude", latitude);
        b.putDouble("longitude", longitude);
        b.putString("location", location);

        map.putExtras(b);
        this.startActivity(map);
    }

    public List<PlaceInfo> getPlaces() {
        String[] names = new String[]{
                "Nandi Hills",
                "Wonder La",
                "vidhana soudha"};

        double[] latitudes = new double[]{13.3701516,
                12.9905789,
                12.9796309,
        };
        double[] longitudes = new double[]{77.6484354,
                77.3193761,
                77.5906865,
        };
        String[] imageSources = new String[]{"@drawable/nandi_1",
                "@drawable/woder_la",
                "@drawable/vidhana",
        };

        List<PlaceInfo> places = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            places.add(new PlaceInfo(names[i], latitudes[i], longitudes[i], imageSources[i]));
        }

        return places;
    }
}
