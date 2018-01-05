package com.framgia.soundclound.data.source;

import android.support.annotation.Nullable;

import com.framgia.soundclound.data.model.Track;

import java.util.List;

public class TrackRepository implements TrackDataSource{

    private TrackDataSource mRemoteDataSource;

    public TrackRepository(TrackDataSource trackDataSource) {
        mRemoteDataSource = trackDataSource;
    }


    @Override
    public void getListTrack(String url, String genre, @Nullable int offSet, Callback<List<Track>> callback) {
        mRemoteDataSource.getListTrack(url, genre, offSet, callback);
    }
}
