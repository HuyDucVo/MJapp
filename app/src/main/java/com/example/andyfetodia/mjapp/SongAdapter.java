package com.example.andyfetodia.mjapp;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 *
 */
public class SongAdapter extends ArrayAdapter<Song> {

    /**
     *
     * @param context
     * @param songs
     */
    public SongAdapter(Context context, List<Song> songs) {
        super(context, 0, songs);
    }


    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list_item, parent, false);
        }
        Song currentSong = getItem(position);
        TextView songNameTV = (TextView) listItemView.findViewById(R.id.song_name);
        TextView collectionnameTV = (TextView) listItemView.findViewById(R.id.song_album);
        ImageView songArtIV = (ImageView) listItemView.findViewById(R.id.song_art);
        ImageView playIcon = (ImageView) listItemView.findViewById(R.id.play_icon);

        songNameTV.setText(currentSong.getTrackName());
        collectionnameTV.setText(currentSong.getCollectionName());
        playIcon.setImageResource(R.drawable.ic_slow_motion_video_black_24dp);

        new DownloadImage(songArtIV).execute(currentSong.getArtworkUrl100());

        return listItemView;
    }

}
