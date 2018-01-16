package com.framgia.soundclound.screen.favourite;

import android.databinding.BaseObservable;
import android.view.View;

import com.framgia.soundclound.data.model.Track;
import com.framgia.soundclound.util.Constant;

/**
 * Created by Sony on 1/15/2018.
 */

public class ItemFavoriteViewModel extends BaseObservable {
    private Track mTrack;
    private FavoriteClickListener mFavoriteClickListener;
    private ItemClickListener mItemClickListener;

    public ItemFavoriteViewModel(Track track, FavoriteClickListener favoriteClickListener,
                                 ItemClickListener itemClickListener) {
        mTrack = track;
        mFavoriteClickListener = favoriteClickListener;
        mItemClickListener = itemClickListener;
    }

    public void onClickFavorite(View view) {
        if (mFavoriteClickListener == null) {
            return;
        }
        mFavoriteClickListener.onTrackClick(mTrack);
    }

    public void onClickTrack(View view) {
        if (mItemClickListener == null) {
            return;
        }
        mItemClickListener.onItemClick(mTrack);
    }

    public String getTitle() {
        return mTrack != null ? mTrack.getTitle() : "";
    }

    public String getUrl() {
        return mTrack != null ? mTrack.getArtworkUrl() : Constant.LINK_DEFAULT;
    }

    public String getArtist() {
        if (mTrack != null) {
            return mTrack.getPublisherMetadata() != null ? mTrack.getPublisherMetadata().getArtist()
                    : "";
        }
        return "";
    }

}
