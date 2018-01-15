package com.framgia.soundclound.data.source.local.realm;

import android.content.Context;

import com.framgia.soundclound.data.model.Track;
import com.framgia.soundclound.data.source.TrackDataSource;
import com.framgia.soundclound.data.source.local.SharePreferences;
import com.framgia.soundclound.util.Constant;

import java.util.List;

import io.realm.RealmResults;

/**
 * Created by ADMIN on 1/14/2018.
 */

public class TrackLocalDataSourceimpl implements TrackDataSource.TrackLocalDataSoure {

    private RealmApi mRealmApi;
    private static TrackLocalDataSourceimpl sTrackLocalDataSourceimpl;
    private Context mContext;

    public TrackLocalDataSourceimpl(Context context) {
        mRealmApi = RealmApi.getInstance(context);
        mContext = context;
    }

    public static TrackLocalDataSourceimpl getInstance() {
        return sTrackLocalDataSourceimpl;
    }

    public static void init(Context context) {
        if (sTrackLocalDataSourceimpl == null) {
            sTrackLocalDataSourceimpl = new TrackLocalDataSourceimpl(context);
        }
    }
    @Override
    public List<Track> getListTrack() {
        RealmResults<Track> results = mRealmApi.getmRealm().where(Track.class)
                        .findAll();
        return results;
    }

    @Override
    public void insertTrack(Track track) {
        mRealmApi.getmRealm().beginTransaction();
        mRealmApi.getmRealm().insert(track);
        mRealmApi.getmRealm().commitTransaction();

    }

    @Override
    public void deleteTrack(Track track) {
        mRealmApi.getmRealm().beginTransaction();
        Track track1 = mRealmApi.getmRealm().where(Track.class)
                .equalTo(Constant.FIELD_ID, track.getId()).findFirst();
        track1.deleteFromRealm();
        mRealmApi.getmRealm().commitTransaction();

    }

    @Override
    public void updateTrack(Track track) {
        mRealmApi.getmRealm().beginTransaction();
        mRealmApi.getmRealm().insertOrUpdate(track);
        mRealmApi.getmRealm().commitTransaction();
    }

    @Override
    public void insertOrUpdateTrack(Track track) {
        mRealmApi.getmRealm().beginTransaction();
        mRealmApi.getmRealm().insertOrUpdate(track);
        mRealmApi.getmRealm().commitTransaction();

    }

    @Override
    public List<Track> getListTrackPlay() {
        return SharePreferences.getInstance().getListTrack();
    }

    @Override
    public Track getCurrentTrack() {
        return SharePreferences.getInstance().getTrack();
    }

    @Override
    public int getPositionTrack() {
        return SharePreferences.getInstance().getIndex();
    }
}
