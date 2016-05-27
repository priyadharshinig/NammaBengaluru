package com.example.priyadharshini.nammabengaluru;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.client.HttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
            JSONArray weather  = reader.getJSONArray("weather");
            String temperature = main.getString("temp");
            JSONObject weatherObj  = (JSONObject)weather.get(0);
            String icon = weatherObj.getString("icon");
            String description = weatherObj.getString("description");
            TextView menuText = (TextView) findViewById(R.id.weather);
            String tempString = "Current temperature in Bangalore is: "+ temperature+"degree celcius";
            menuText.setText(tempString);

            TextView desc = (TextView) findViewById(R.id.description);
            menuText.setText(description);


                ImageView i = (ImageView)findViewById(R.id.iconImage);
                String url = "http://openweathermap.org/img/w/"+icon+".png";

            AsyncTask<String, String, Bitmap> response = new GetWeatherImageHelper().execute(url);
            i.setImageBitmap(response.get());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getWeather() throws ExecutionException, InterruptedException {

        String url = "http://api.openweathermap.org/data/2.5/weather?q=bangalore,India&APPID=b3a9591134e378601fb3f14eee925f4a&units=metric";

        AsyncTask<String, String, String> response = new OpenWeatherMapHelper().execute(url);
        return  response.get();

    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            Log.e("src",src);
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Log.e("Bitmap","returned");
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
            return null;
        }
    }

}
