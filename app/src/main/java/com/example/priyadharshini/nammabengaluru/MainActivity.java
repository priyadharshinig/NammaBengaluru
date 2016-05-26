package com.example.priyadharshini.nammabengaluru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Array of strings...
    String[] menuArray = {"Tour Bengaluru", "Find Kannada Translation", "Hotels", "Weather", "Restaurants", "Map"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.menu, menuArray);

        ListView listView = (ListView) findViewById(R.id.menu_list);
        listView.setAdapter(adapter);
    }

    public void performAction(View view) {
        TextView menuText = (TextView) view.findViewById(R.id.menu_item);

        if(menuText.getText().equals("Tour Bengaluru")) {
            Intent placesToVisit = new Intent(MainActivity.this, PlacesToVisit.class);
            this.startActivity(placesToVisit);
        } else if(menuText.getText().equals("Weather")) {
            Intent weather = new Intent(MainActivity.this, Weather.class);
            this.startActivity(weather);
        }
    }
}
