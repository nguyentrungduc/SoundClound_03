package com.framgia.soundclound.data.source;

import android.support.annotation.NonNull;

import com.framgia.soundclound.data.model.Track;

import java.util.List;

/**
 * Created by Sony on 1/5/2018.
 */

public class TrackRepository implements TrackDataSource.TrackRemoteDataSource,
        TrackDataSource.TrackLocalDataSoure{

    private TrackDataSource.TrackRemoteDataSource mRemoteDataSource;
    private TrackDataSource.TrackLocalDataSoure mLocalDataSoure;

    public TrackRepository(TrackDataSource.TrackRemoteDataSource trackDataSource,
                           TrackDataSource.TrackLocalDataSoure trackLocalDataSoure) {
        mRemoteDataSource = trackDataSource;
        mLocalDataSoure = trackLocalDataSoure;

    }

    public TrackRepository(TrackDataSource.TrackRemoteDataSource trackRemoteDataSource) {
        mRemoteDataSource = trackRemoteDataSource;
    }

    public TrackRepository(TrackDataSource.TrackLocalDataSoure trackLocalDataSoure) {
        mLocalDataSoure = trackLocalDataSoure;
    }

    @Override
    public void getListTrack(String url, String genre, int limit, @NonNull int offSet,
                             TrackDataSource.Callback<List<Track>> callback) {
        mRemoteDataSource.getListTrack(url, genre, limit, offSet, callback);
    }

    @Override
    public List<Track> getLocalTrack() {
        return mRemoteDataSource.getLocalTrack();
    }

    @Override
    public List<Track> getListTrack() {
        return mLocalDataSoure.getListTrack();
    }

    @Override
    public void insertTrack(Track track) {
        mLocalDataSoure.insertTrack(track);

    }

    @Override
    public void deleteTrack(Track track) {
        mLocalDataSoure.deleteTrack(track);
    }

    @Override
    public void updateTrack(Track track) {
        mLocalDataSoure.updateTrack(track);
    }

    @Override
    public void insertOrUpdateTrack(Track track) {
        mLocalDataSoure.insertOrUpdateTrack(track);

    }

    @Override
    public List<Track> getListTrackPlay() {
        return mLocalDataSoure.getListTrackPlay();
    }

    @Override
    public Track getCurrentTrack() {
        return mLocalDataSoure.getCurrentTrack();
    }

    @Override
    public int getPositionTrack() {
        return mLocalDataSoure.getPositionTrack();
    }
}
