package com.framgia.soundclound.data.source;

import com.framgia.soundclound.data.model.Track;

import java.util.List;

/**
 * Created by Sony on 1/5/2018.
 */
public interface TrackDataSource {
    /**
     * @return <T> specified type of object
     */
    interface Callback<T> {
        void onStartLoading();
        void onGetSuccess(T data);
        void onGetFailure(String message);
        void onComplete();
    }

    /**
     * Created by Sony on 1/15/2018.
     */
    interface TrackRemoteDataSource {

        void getListTrack(String url, String genre, int limit, int offSet,
                          Callback<List<Track>> callback);

        List<Track> getLocalTrack();
    }

    /**
     * Created by Sony on 1/15/2018.
     */
    interface TrackLocalDataSoure {
        List<Track> getListTrack();

        void insertTrack(Track track);

        void deleteTrack(Track track);

        void updateTrack(Track track);

        void insertOrUpdateTrack(Track track);

        List<Track> getListTrackPlay();

        Track getCurrentTrack();

        int getPositionTrack();

    }
}
