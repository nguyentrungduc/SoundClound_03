package com.framgia.soundclound.screen.detailgenre;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.framgia.soundclound.BR;
import com.framgia.soundclound.data.model.Track;
import com.framgia.soundclound.data.source.TrackDataSource;
import com.framgia.soundclound.data.source.TrackRepository;
import com.framgia.soundclound.data.source.remote.TrackRemoteDataSource;

import java.util.List;

/**
 * Created by Sony on 1/5/2018.
 */

public class GenreDetailViewModel extends BaseObservable{
    private TrackRepository mTrackRepository;

    private GenreDetailAdapter mGenreDetailAdapter;

    public GenreDetailViewModel() {
        mTrackRepository = new TrackRepository(new TrackRemoteDataSource());
        mTrackRepository.getListTrack("", "",0, new TrackDataSource.Callback<List<Track>>() {
            @Override
            public void onStartLoading() {

            }

            @Override
            public void onGetSuccess(List<Track> data) {
                mGenreDetailAdapter = new GenreDetailAdapter(data);
                notifyPropertyChanged(BR.mGenreDetailAdapter);

            }

            @Override
            public void onGetFailure(String message) {

            }

            @Override
            public void onComplete() {

            }
        });


    }

    @Bindable
    public GenreDetailAdapter getmGenreDetailAdapter() {
        return mGenreDetailAdapter;
    }

    public void setmGenreDetailAdapter(GenreDetailAdapter mGenreDetailAdapter) {
        this.mGenreDetailAdapter = mGenreDetailAdapter;
        notifyPropertyChanged(BR.mGenreDetailAdapter);
    }

}
