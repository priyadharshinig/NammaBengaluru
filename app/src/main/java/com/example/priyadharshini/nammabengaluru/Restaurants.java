package com.example.priyadharshini.nammabengaluru;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Restaurants extends AppCompatActivity {

    //todo: make these constants in string array
    String[] menuArray = {"Olive Beach", "Leela Palace", "Park Plaza"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

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
            case "Olive Beach":
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                         Uri.parse("http://www.olivebarandkitchen.com/index.php"));
                startActivity(browserIntent);
                break;

            case "Leela Palace":
                Intent browserIntent2 = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.theleela.com/en_us/hotels-in-bengaluru/the-leela-palace-hotel-bengaluru/dining/"));
                startActivity(browserIntent2);
                break;

            case "Park Plaza":
                Intent browserIntent3 = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.parkplaza.com/bangalore-hotel-in-560037/indbanl"));
                startActivity(browserIntent3);
                break;

            default:
                break;
        }
    }
}
