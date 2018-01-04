package com.ntd.themovie.data.source;

import com.ntd.themovie.data.model.Track;
import com.ntd.themovie.data.source.remote.TrackRemoteDataSource;

import java.util.List;

/**
 * Created by ADMIN on 1/3/2018.
 */

public class TrackRepository implements TrackDataSource{
    private TrackDataSource mRemoteDataSource;
    String url;

    public TrackRepository(TrackDataSource trackDataSource) {
        mRemoteDataSource = trackDataSource;
    }

    @Override
    public void getListTrack(String url, Callback<List<Track>> callback) {
        mRemoteDataSource.getListTrack(url, callback);
    }
}
