package com.example.priyadharshini.nammabengaluru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    /**
     * main menu in an array
     */
    String[] menuArray = getResources().getStringArray(R.array.menuArray);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.menu, menuArray);
        final ListView listView = (ListView) findViewById(R.id.menu_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                String o = (String) listView.getItemAtPosition(position);
                performAction(o);
            }
        });

    }

    /**
     * This method opens the required activity according to the item selected in the main activity
     * @param item
     */
    public void performAction(String item) {

        switch (item) {
            case "Places To Visit":
                Intent placesToVisit = new Intent(MainActivity.this, PlacesToVisit.class);
                this.startActivity(placesToVisit);
                break;
            case "Weather":
                Intent weather = new Intent(MainActivity.this, Weather.class);
                this.startActivity(weather);
                break;
            case "Restaurants":
                Intent restaurant = new Intent(MainActivity.this, Restaurants.class);
                this.startActivity(restaurant);
                break;
            case "Map":
                Intent map = new Intent(MainActivity.this, MapsActivity.class);
                Bundle b = new Bundle();
                b.putDouble("latitude", 12.9538477);
                b.putDouble("longitude", 77.3507382);
                b.putString("location", "Bangalore");
                map.putExtras(b);
                this.startActivity(map);
                break;
            case "Hotels":
                Intent hotel = new Intent(MainActivity.this, Hotel.class);
                this.startActivity(hotel);
                break;
            default:
                break;
        }
    }
}
