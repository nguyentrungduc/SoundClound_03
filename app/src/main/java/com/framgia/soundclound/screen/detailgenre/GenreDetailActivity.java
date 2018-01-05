package com.framgia.soundclound.screen.detailgenre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.framgia.soundclound.R;

public class GenreDetailActivity extends AppCompatActivity {

    private GenreDetailViewModel mGenreDetailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_detail);
        mGenreDetailViewModel = new GenreDetailViewModel();
    }
}
