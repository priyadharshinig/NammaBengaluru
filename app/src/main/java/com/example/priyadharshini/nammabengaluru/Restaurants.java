package com.example.priyadharshini.nammabengaluru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Restaurants extends AppCompatActivity {

    //todo: make these constants in string array
    String[] menuArray = {"Ibis", "Novotel", "Park Plaza"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.menu, menuArray);

        ListView listView = (ListView) findViewById(R.id.menu_list);
        listView.setAdapter(adapter);
    }
}
