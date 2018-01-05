package com.framgia.soundclound.data.source;

import com.framgia.soundclound.data.model.Track;

import java.util.List;

public interface TrackDataSource {
    interface Callback<T> {
        void onStartLoading();
        void onGetSuccess(T data);
        void onGetFailure(String message);
        void onComplete();
    }

    void getListTrack(String url,String genre, int offSet, Callback<List<Track>> callback);
}
