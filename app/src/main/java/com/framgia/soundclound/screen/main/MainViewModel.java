package com.framgia.soundclound.screen.main;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;

import com.framgia.soundclound.BR;
import com.framgia.soundclound.R;


/**
 * Created by Sony on 1/4/2018.
 */

public class MainViewModel extends BaseObservable {
    private Context mContext;
    private MainActivity mActivity;
    private MainPagerAdapter mPagerAdapter;

    public MainViewModel(Context context) {
        mContext = context;
        mActivity = (MainActivity) context;
        mPagerAdapter = new MainPagerAdapter(mActivity.getSupportFragmentManager());
    }

    @Bindable
    public MainPagerAdapter getPagerAdapter() {
        return mPagerAdapter;
    }

    public void setPagerAdapter(MainPagerAdapter pagerAdapter) {
        mPagerAdapter = pagerAdapter;
        notifyPropertyChanged(BR.pagerAdapter);
    }

    public TabLayout.OnTabSelectedListener getTabSelectedListener() {
        final int selectedColor = ContextCompat.getColor(mContext, R.color.color_orange);
        final int unSelectedColor = ContextCompat.getColor(mContext, R.color.color_gray);
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getIcon() != null) {
                    tab.getIcon().setColorFilter(selectedColor, PorterDuff.Mode.SRC_ATOP);
                }
                switch (tab.getPosition()) {
                    case MainActivity.HOME:
                        mActivity.setPositon(MainPagerAdapter.HOME);
                        break;
                    case MainActivity.PLAY_LIST:
                        mActivity.setPositon(MainPagerAdapter.PLAY_LIST);
                        break;
                    case MainActivity.DOWNLOAD:
                        mActivity.setPositon(MainPagerAdapter.DOWNLOAD);
                        break;
                    case MainActivity.FAVORITE:
                        mActivity.setPositon(MainPagerAdapter.FAVORITE);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getIcon() != null) {
                    tab.getIcon().setColorFilter(unSelectedColor, PorterDuff.Mode.SRC_ATOP);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };
    }

}
