package com.framgia.soundclound.screen.favourite;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.framgia.soundclound.BR;
import com.framgia.soundclound.data.model.Track;
import com.framgia.soundclound.data.source.TrackRepository;

/**
 * Created by Sony on 1/15/2018.
 */

public class FavoriteViewModel extends BaseObservable implements ItemClickListener,
        FavoriteClickListener {
    private FavoriteTrackAdapter mFavoriteTrackAdapter;
    private Context mContext;
    private TrackRepository mTrackRepository;

    public FavoriteViewModel(Context context) {
        mContext = context;

    }

    @Bindable
    public FavoriteTrackAdapter getFavoriteTrackAdapter() {
        return mFavoriteTrackAdapter;
    }

    public void setFavoriteTrackAdapter(FavoriteTrackAdapter favoriteTrackAdapter) {
        mFavoriteTrackAdapter = favoriteTrackAdapter;
        notifyPropertyChanged(BR.favoriteTrackAdapter);
    }

    @Override
    public void onItemClick(Track track) {

    }

    @Override
    public void onTrackClick(Track track) {

    }
}
