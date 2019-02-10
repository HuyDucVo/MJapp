package com.example.andyfetodia.mjapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * This class will get the information from the Intent passed from the Main Activity then
 * display all the detail of the song
 */
public class SongDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        String artworkUrl100 = getIntent().getStringExtra("artworkUrl100");
        String songName = getIntent().getStringExtra("song_name");
        String collectionName = getIntent().getStringExtra("collection_name");
        String playtime = getIntent().getStringExtra("playtime");
        String price = getIntent().getStringExtra("price");
        final String trackViewUrl = getIntent().getStringExtra("trackViewUrl");

        TextView songNameTV = (TextView) findViewById(R.id.song_name);
        TextView collectionNameTV = (TextView) findViewById(R.id.collection_name);
        TextView playtimeTV = (TextView) findViewById(R.id.playtime_value);
        TextView priceTV = (TextView) findViewById(R.id.price_value);
        ImageView artworkUrl100IV = (ImageView) findViewById(R.id.profile_song);
        ImageButton imageButtonIB = (ImageButton) findViewById(R.id.itunes);

        new DownloadImage(artworkUrl100IV).execute(artworkUrl100);
        songNameTV.setText(songName);
        collectionNameTV.setText(collectionName);
        playtimeTV.setText(playtime);
        priceTV.setText(price);
        imageButtonIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(trackViewUrl));
                startActivity(websiteIntent);
            }
        });


    }

}
