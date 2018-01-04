package com.ntd.themovie.data.source;

import com.ntd.themovie.data.model.Track;

import java.util.List;

/**
 * Created by ADMIN on 1/3/2018.
 */

public interface TrackDataSource {
    interface Callback<T> {
        void onStartLoading();
        void onGetSuccess(T data);
        void onGetFailure(String message);
        void onComplete();
    }

    void getListTrack(String url, Callback<List<Track>> callback);
}
