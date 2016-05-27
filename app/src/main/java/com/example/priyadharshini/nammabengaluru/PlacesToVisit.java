package com.example.priyadharshini.nammabengaluru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class PlacesToVisit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_to_visit);

    }

    public void locate(View view) {
        TextView tv = (TextView) view;
        String id= tv.getResources().getResourceEntryName(tv.getId());
        Intent map = new Intent(PlacesToVisit.this, MapsActivity.class);
        Bundle b = new Bundle();
        switch (id) {
            case "nandi_hills_locate":
                b.putDouble("lat", 13.3701516); //Your id
                b.putDouble("longitude", 77.6484354); //Your id
                b.putString("location", "Nandi Hills");
                break;
            case "wonder_la_locate":
                b.putDouble("lat", 12.9905789); //Your id
                b.putDouble("longitude", 77.3193761); //Your id
                b.putString("location", "Wonder La");
                break;


        }
        map.putExtras(b);
        this.startActivity(map);
    }
}
