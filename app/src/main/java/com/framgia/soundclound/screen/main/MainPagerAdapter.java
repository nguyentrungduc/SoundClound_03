package com.framgia.soundclound.screen.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.framgia.soundclound.screen.home.HomeFragment;

/**
 * Created by Sony on 1/4/2018.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private static final int TAB_COUNT = 4;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(@TabType int position) {
        switch (position) {
            case TabType.HOME:
                return HomeFragment.newInstance();
            case TabType.PLAY_LIST:
                return HomeFragment.newInstance();
            case TabType.LOCAL:
                return HomeFragment.newInstance();
            case TabType.FAVORITE:
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
