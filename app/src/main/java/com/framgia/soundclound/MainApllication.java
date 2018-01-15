package com.framgia.soundclound;

import android.app.Application;

import com.framgia.soundclound.data.source.local.SharePreferences;
import com.framgia.soundclound.data.source.local.realm.RealmApi;
import com.framgia.soundclound.data.source.local.realm.TrackLocalDataSourceimpl;
import com.framgia.soundclound.data.source.remote.TrackRemoteDataSource;

/**
 * Created by Sony on 1/9/2018.
 */

public class MainApllication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RealmApi.init(this);
        TrackRemoteDataSource.init(this);
        SharePreferences.init(this);
        TrackLocalDataSourceimpl.init(this);

    }
}
