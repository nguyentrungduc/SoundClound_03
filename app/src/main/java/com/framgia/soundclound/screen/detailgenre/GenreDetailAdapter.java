package com.framgia.soundclound.screen.detailgenre;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framgia.soundclound.R;
import com.framgia.soundclound.data.model.Track;
import com.framgia.soundclound.databinding.ItemGenreDetailBinding;

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
        ItemGenreDetailBinding itemGenreDetailBinding = DataBindingUtil.inflate(layoutInflater
                , R.layout.item_genre_detail,parent,false);
        return new GenreDetailViewHolder(itemGenreDetailBinding);
    }

    @Override
    public void onBindViewHolder(GenreDetailViewHolder holder, int position) {
        holder.bindData(mTracks.get(position));
    }

    @Override
    public int getItemCount() {
        return mTracks.size();
    }

    public class GenreDetailViewHolder extends RecyclerView.ViewHolder{
        private ItemGenreDetailBinding itemGenreDetailBinding;

        public GenreDetailViewHolder(ItemGenreDetailBinding itemGenreDetailBinding) {
            super(itemGenreDetailBinding.getRoot());
            this.itemGenreDetailBinding = itemGenreDetailBinding;
        }

        public void bindData(Track track){
            itemGenreDetailBinding.setTrack(track);
        }
    }
}
