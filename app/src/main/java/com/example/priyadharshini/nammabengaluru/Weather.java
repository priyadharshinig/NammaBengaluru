package com.example.priyadharshini.nammabengaluru;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class Weather extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        String responseJson = null;
        try {
            responseJson = getWeather();
            JSONObject reader = new JSONObject(responseJson);
            JSONObject main  = reader.getJSONObject("main");
//            JSONObject weather  = reader.getJSONObject("weather");
            String temperature = main.getString("temp");
//            String icon = weather.getString("icon");
//            String description = weather.getString("description");
            TextView menuText = (TextView) findViewById(R.id.weather);
            String tempString = "Current temperature in Bangalore is: "+ temperature;
            menuText.setText(tempString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getWeather() throws ExecutionException, InterruptedException {

        String url = "http://api.openweathermap.org/data/2.5/weather?q=bangalore,India&APPID=b3a9591134e378601fb3f14eee925f4a&units=metric";

        AsyncTask<String, String, String> response = new OpenWeatherMapHelper().execute(url);
        return  response.get();

    }


}
