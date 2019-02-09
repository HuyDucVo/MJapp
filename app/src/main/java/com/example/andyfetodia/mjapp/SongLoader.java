package com.example.andyfetodia.mjapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class SongLoader extends AsyncTaskLoader<List<Song>> {

    private static final String LOG_TAG = SongLoader.class.getName();
    private String mUrl;

    /**
     *
     * @param context
     * @param url
     */
    public SongLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    /**
     *
     */
    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Song> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        List<Song> songs = NetworkUtils.fetchEarthquakeData(mUrl);
        return songs;
    }
}
