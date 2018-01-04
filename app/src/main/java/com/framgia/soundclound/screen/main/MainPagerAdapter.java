package com.framgia.soundclound.screen.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.framgia.soundclound.screen.home.HomeFragment;

/**
 * Created by Sony on 1/4/2018.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    public static final int HOME = 0;
    public static final int PLAY_LIST = 1;
    public static final int DOWNLOAD =2;
    public static final int FAVORITE = 3;

    private static final int TAB_COUNT = 4;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case HOME:
                return HomeFragment.newInstance();
            case PLAY_LIST:
                return HomeFragment.newInstance();
            case DOWNLOAD:
                return HomeFragment.newInstance();
            case FAVORITE:
                return HomeFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }
}
