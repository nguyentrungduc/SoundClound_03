package com.framgia.soundclound.screen.playtrack;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.framgia.soundclound.R;
import com.framgia.soundclound.data.model.Track;
import com.framgia.soundclound.data.source.TrackRepository;
import com.framgia.soundclound.data.source.local.realm.TrackLocalDataSourceimpl;
import com.framgia.soundclound.databinding.ActivityPlayTrackBinding;

import java.util.List;

/**
 * Created by Sony on 1/11/2018.
 */
public class PlayTrackActivity extends AppCompatActivity {
    private TrackRepository mTrackRepository;

    public static Intent getInstance(Context context, @Nullable List<Track> trackList,
                                     @Nullable int position) {
        Intent intent = new Intent(context, PlayTrackActivity.class);
        return new Intent(context, PlayTrackActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPlayTrackBinding activityPlayTrackBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_play_track);
        mTrackRepository = new TrackRepository(TrackLocalDataSourceimpl.getInstance());
        PlayTrackViewModel mPlayTrackViewModel = new PlayTrackViewModel(
                mTrackRepository.getListTrackPlay(), mTrackRepository.getPositionTrack());
        activityPlayTrackBinding.setViewModel(mPlayTrackViewModel);
        getSupportActionBar().hide();
    }

}
