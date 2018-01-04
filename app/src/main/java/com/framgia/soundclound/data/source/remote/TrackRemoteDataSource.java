package com.ntd.themovie.data.source.remote;

import android.util.Log;

import com.google.gson.Gson;
import com.ntd.themovie.Constant;
import com.ntd.themovie.data.model.Collection;
import com.ntd.themovie.data.model.ListTrack;
import com.ntd.themovie.data.model.Track;
import com.ntd.themovie.data.model.User;
import com.ntd.themovie.data.source.TrackDataSource;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by ADMIN on 1/3/2018.
 */

public class TrackRemoteDataSource implements TrackDataSource{

    public TrackRemoteDataSource() {
    }

    private static final String TAG = TrackRemoteDataSource.class.toString();
    @Override
    public void getListTrack(String url, final Callback<List<Track>> callback) {
        //String url = Constant.ENDPOINT;
        new LoadAsync(new Callback<String>() {
            @Override
            public void onStartLoading() {
                callback.onStartLoading();
            }

            @Override
            public void onGetSuccess(String data) {
                Log.d(TAG, "onGetSuccess: " + data);
                if (data == null) {
                    callback.onGetFailure("No Track :'<");
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
        }).execute(url);
    }
}
