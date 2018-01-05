package com.framgia.soundclound.data.source.remote;

import android.util.Log;

import com.framgia.soundclound.data.model.Collection;
import com.framgia.soundclound.data.model.ListTrack;
import com.framgia.soundclound.data.model.Track;
import com.framgia.soundclound.data.source.TrackDataSource;
import com.framgia.soundclound.util.StringUtil;
import com.google.gson.Gson;

import java.util.List;

public class TrackRemoteDataSource implements TrackDataSource{

    private static final String TAG = TrackRemoteDataSource.class.toString();

    public TrackRemoteDataSource() {
    }

    @Override
    public void getListTrack(String url, String genre, int offSet, final Callback<List<Track>> callback) {
        new LoadAsync(new TrackDataSource.Callback<String>() {
            @Override
            public void onStartLoading() {
                callback.onStartLoading();
            }

            @Override
            public void onGetSuccess(String data) {
                Log.d(TAG, "onGetSuccess: " + data);
                if (data == null) {
                    callback.onGetFailure("No Track");
                    return;
                }
                List<Track> listTrack = Collection.toListTrack(new Gson()
                        .fromJson(data, ListTrack.class).getCollection());

                callback.onGetSuccess(listTrack);
            }

            @Override
            public void onGetFailure(String message) {
                callback.onGetFailure(message);
            }

            @Override
            public void onComplete() {
                callback.onComplete();
            }
        }).execute(StringUtil.returnUrl(url, genre, offSet));

    }
}
