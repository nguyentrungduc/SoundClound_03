package com.framgia.soundclound.screen.playtrack;

import android.databinding.BaseObservable;
import android.view.View;

import com.framgia.soundclound.data.model.Track;

import java.util.List;

/**
 * Created by Sony on 1/11/2018.
 */

public class PlayTrackViewModel extends BaseObservable {
    private List<Track> mTrackList;
    private int mPosition;
    private Track mTrack;

    public PlayTrackViewModel(List<Track> tracks, int position) {
        mTrackList = tracks;
        mPosition = position;
        mTrack = mTrackList.get(position);
    }

    public String getTitle() {
        return mTrack != null ? mTrack.getTitle() : "";
    }

    public String getArtist() {
        if (mTrack != null) {
            return mTrack.getPublisherMetadata() != null ? mTrack.getPublisherMetadata().getArtist()
                    : "";
        }
        return "";
    }

    public void onClickLoop(View view){

    }

    public void onClickPrevious(View view) {

    }

    public void onClickPause(View view) {

    }

    public void onClickNext(View view) {

    }

    public void onClickShuffle(View view) {

    }

    public void onClickLike(View view) {

    }

    public void onClickDownload(View view) {

    }

}
