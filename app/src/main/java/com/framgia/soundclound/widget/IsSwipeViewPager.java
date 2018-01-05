package com.framgia.soundclound.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.framgia.soundclound.R;

/**
 * Created by Sony on 1/4/2018.
 */

public class IsSwipeViewPager extends ViewPager {
    private boolean isSwipe;

    public IsSwipeViewPager(Context context) {
        super(context);
    }

    public IsSwipeViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.IsSwipeViewPager,
                0, 0);
        try {
            isSwipe = a.getBoolean(R.styleable.IsSwipeViewPager_isSwipe, false);

        } finally {
            a.recycle();
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return isSwipe && super.onInterceptTouchEvent(event);
    }

}
