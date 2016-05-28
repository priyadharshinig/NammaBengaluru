package com.example.priyadharshini.nammabengaluru.models;

/**
 * Created by priya.dharshini on 28/05/16.
 */
public class PlaceInfo {
    public  String name;
    public double latitude;
    public double longitude;
    public String imageSource;

    public PlaceInfo(String name, double latitude, double longitude, String imageSource) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageSource = imageSource;
    }
}
