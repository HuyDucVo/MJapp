package com.example.andyfetodia.mjapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class SongDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);


        String songName = getIntent().getStringExtra("song_name");
        String collectionName = getIntent().getStringExtra("collection_name");
        String playtime = getIntent().getStringExtra("playtime");
        String price = getIntent().getStringExtra("price");

        TextView songNameTV = (TextView) findViewById(R.id.song_name);
        TextView collectionNameTV = (TextView) findViewById(R.id.collection_name);
        TextView playtimeTV = (TextView) findViewById(R.id.playtime_value);
        TextView priceTV = (TextView) findViewById(R.id.price_value);

        songNameTV.setText(songName);
        collectionNameTV.setText(collectionName);
        playtimeTV.setText(playtime);
        priceTV.setText(price);
    }

}
