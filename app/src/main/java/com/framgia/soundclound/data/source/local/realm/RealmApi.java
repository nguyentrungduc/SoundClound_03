package com.framgia.soundclound.data.source.local.realm;

import android.content.Context;

import io.realm.Realm;

/**
 * Created by ADMIN on 1/14/2018.
 */

public class RealmApi {
    private Realm mRealm;

    private static RealmApi sRealmApi;

    public RealmApi(Context context) {
        Realm.init(context);
        mRealm = Realm.getDefaultInstance();

    }

    public static RealmApi getInstance(Context context) {
        return sRealmApi;
    }

    public static void init(Context context) {
        if (sRealmApi == null) {
            sRealmApi = new RealmApi(context);
        }
    }

    public Realm getmRealm() {
        return mRealm;
    }
}
