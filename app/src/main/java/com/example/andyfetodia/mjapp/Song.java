package com.example.andyfetodia.mjapp;

import java.util.concurrent.TimeUnit;

public class Song {
    private String artworkUrl100;
    private String collectionName;
    private String trackName;
    private String trackPrice;
    private String trackTimeMillis;
    private String trackViewUrl;
    public Song(){

    }


    public Song(String artworkUrl100, String collectionName, String trackName, String trackPrice, String trackTimeMillis, String trackViewUrl){
        this.artworkUrl100 = artworkUrl100;
        this.collectionName = collectionName;
        this.trackName = trackName;
        this.trackPrice = "$ " + trackPrice;
        this.trackTimeMillis = convertTime(trackTimeMillis) + " mins";
        this.trackViewUrl = trackViewUrl;
    }

    private String convertTime(String trackTimeMillis) {
        int time = Integer.parseInt(trackTimeMillis);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(time);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time);
        return String.valueOf(minutes) + ":" + String.valueOf(seconds/100);
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getTrackPrice() {
        return trackPrice;
    }

    public String getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }
}
