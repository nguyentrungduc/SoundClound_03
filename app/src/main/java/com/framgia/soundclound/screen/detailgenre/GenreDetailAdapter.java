package com.framgia.soundclound.screen.detailgenre;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framgia.soundclound.data.model.Track;

import java.util.List;

/**
 * Created by Sony on 1/5/2018.
 */

public class GenreDetailAdapter extends RecyclerView.Adapter<GenreDetailAdapter.GenreDetailViewHolder>{

    private List<Track> mTracks;

    public GenreDetailAdapter(List<Track> mTracks) {
        this.mTracks = mTracks;
    }

    @Override
    public GenreDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    }

    @Override
    public void onBindViewHolder(GenreDetailViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class GenreDetailViewHolder extends RecyclerView.ViewHolder{
        public GenreDetailViewHolder(View itemView) {
            super(itemView);
        }
    }
}
