package com.example.andyfetodia.mjapp;

public class Song {
    private String artworkUrl100;
    private String artistName;
    private String collectionName;
    private String trackName;

    public Song(){

    }

    /**
     *
     * @param artworkUrl100
     * @param artistName
     * @param collectionName
     * @param trackName
     */
    public Song(String artworkUrl100,String artistName,String collectionName, String trackName){
        this.artworkUrl100 = artworkUrl100;
        this.artistName = artistName;
        this.collectionName = collectionName;
        this.trackName = trackName;

    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getTrackName() {
        return trackName;
    }


}
