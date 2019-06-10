package com.example.player.a1610aplayerdemo.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyViewPager extends ViewPager {
    public MyViewPager(@NonNull Context context) {
        super(context);
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private Boolean isScoll = false;

    public void setScoll(Boolean scoll) {
        isScoll = scoll;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isScoll;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isScoll;
    }
}
