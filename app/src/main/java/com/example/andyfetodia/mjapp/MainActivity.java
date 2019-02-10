package com.example.andyfetodia.mjapp;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<Song>>
{
    private static final int SONG_LOADER_ID = 1;

    private static final String LOG_TAG = MainActivity.class.getName();

    private static final String MJ_REQUEST_URL = "https://itunes.apple.com/search?term=Michael+jackson";

    private TextView mEmptyStateTextView;

    private SongAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView songListView = (ListView) findViewById(R.id.list);
        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        songListView.setEmptyView(mEmptyStateTextView);

        mAdapter = new SongAdapter(this, new ArrayList<Song>());
        songListView.setAdapter(mAdapter);

        songListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Song currentSong = mAdapter.getItem(position);
                    Intent intent  = new Intent(MainActivity.this,SongDetailActivity.class);
                    intent.putExtra("song_name",currentSong.getTrackName());
                    intent.putExtra("collection_name",currentSong.getCollectionName());
                    intent.putExtra("price",currentSong.getTrackPrice());
                    intent.putExtra("playtime",currentSong.getTrackTimeMillis());
                    startActivity(intent);
                }
            });

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(SONG_LOADER_ID, null, this);
        } else {
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }


    }

    @Override
    public Loader<List<Song>> onCreateLoader(int id, Bundle args) {
        return new SongLoader(this, MJ_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Song>> loader, List<Song> data) {
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);
        mEmptyStateTextView.setText(R.string.no_songs);

        if (data != null && !data.isEmpty()) {
            mAdapter.addAll(data);
            //updateUi(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Song>> loader) {
        mAdapter.clear();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
