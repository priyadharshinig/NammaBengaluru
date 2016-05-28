package com.example.priyadharshini.nammabengaluru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Hotel extends AppCompatActivity {

    String[] menuArray = {"Ibis, Bellandur", "Park Plaza, Marathahalli", "Novotel, Devarabisanahalli",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.menu, menuArray);
        final ListView listView = (ListView) findViewById(R.id.menu_list);
        listView.setAdapter(adapter);
    }
}
