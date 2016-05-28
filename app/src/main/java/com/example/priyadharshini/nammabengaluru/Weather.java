package com.example.priyadharshini.nammabengaluru;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.priyadharshini.nammabengaluru.helper.OpenWeatherMapHelper;
import com.example.priyadharshini.nammabengaluru.helper.WeatherImageHelper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class Weather extends AppCompatActivity {

    final String DEGREE = "\u00b0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        String responseJson = null;
        try {
            responseJson = getWeather();
            JSONObject reader = new JSONObject(responseJson);
            JSONObject main = reader.getJSONObject("main");
            JSONArray weather = reader.getJSONArray("weather");
            String temperature = main.getString("temp");
            JSONObject weatherObj = (JSONObject) weather.get(0);
            String icon = weatherObj.getString("icon");
            String description = weatherObj.getString("description");
            TextView menuText = (TextView) findViewById(R.id.weather);
            String tempString = temperature + " " + DEGREE + "C";
            menuText.setText(tempString);

            TextView desc = (TextView) findViewById(R.id.description);
            desc.setText(description);


            ImageView i = (ImageView) findViewById(R.id.iconImage);
            String url = "http://openweathermap.org/img/w/" + icon + ".png";

            AsyncTask<String, String, Bitmap> response = new WeatherImageHelper().execute(url);
            i.setImageBitmap(response.get());

        } catch (Exception e) {
            Log.e("Exception occured. ", e.getMessage());
        }
    }

    private String getWeather() throws ExecutionException, InterruptedException {

        String url = "http://api.openweathermap.org/data/2.5/weather?q=bangalore,India&APPID=b3a9591134e378601fb3f14eee925f4a&units=metric";

        AsyncTask<String, String, String> response = new OpenWeatherMapHelper().execute(url);
        return response.get();

    }

}
