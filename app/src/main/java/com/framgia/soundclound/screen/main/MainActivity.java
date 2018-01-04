package com.framgia.soundclound.screen.main;

import android.databinding.DataBindingUtil;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.framgia.soundclound.R;
import com.framgia.soundclound.databinding.ActivityMainBinding;
import com.framgia.soundclound.widget.IsSwipeViewPager;

public class MainActivity extends AppCompatActivity {

    public static final int HOME = 0;
    public static final int PLAY_LIST = 1;
    public static final int DOWNLOAD = 2;
    public static final int FAVORITE = 3;
    private IsSwipeViewPager mViewPager;
    private MainViewModel mViewModel;
    private TabLayout mTabLayout;


    private static final String TAG = MainActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewModel = new MainViewModel(this);
        ActivityMainBinding binding = DataBindingUtil.
                setContentView(this, R.layout.activity_main);
        binding.setViewModel((MainViewModel) mViewModel);

        mViewPager = binding.viewPager;
        mTabLayout = binding.tabLayout;

        if (mTabLayout.getTabAt(HOME).getIcon() != null) {
            int selectedColor = ContextCompat.getColor(this, R.color.color_orange);
            mTabLayout.getTabAt(HOME).getIcon().setColorFilter(selectedColor,
                    PorterDuff.Mode.SRC_ATOP);
        }

        getSupportActionBar().hide();
    }

    public void setPositon(int position) {
        mViewPager.setCurrentItem(position);
    }
}
