package com.framgia.soundclound.util;

import android.databinding.BindingAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Created by Sony on 1/4/2018.
 */

public class BindingUtil {
    @BindingAdapter({ "bind:pageradapter" })
    public static void setViewPagerAdapter(ViewPager viewPager, PagerAdapter adapter) {
        viewPager.setAdapter(adapter);
    }

    @BindingAdapter({ "bind:tabSelectListener" })
    public static void setOnTabSelectedListener(TabLayout tabLayout,
                                                TabLayout.OnTabSelectedListener listener) {
        tabLayout.addOnTabSelectedListener(listener);
    }
}
