package com.example.andyfetodia.mjapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getName();

    private static final String MJ_REQUEST_URL = "https://itunes.apple.com/search?term=Michael+jackson";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new AsyncTask<Void, Void, List<Song>>() {

            @Override
            protected void onPostExecute(List<Song> songs) {
                for(int i =0; i< songs.size();i++){
                    Log.e(LOG_TAG,songs.get(i).getTrackName());
                }

            }

            @Override
            protected List<Song>  doInBackground(Void... voids) {
                List<Song> mjSong = NetworkUtils.fetchEarthquakeData(MJ_REQUEST_URL);
                return mjSong;
            }
        }.execute();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
