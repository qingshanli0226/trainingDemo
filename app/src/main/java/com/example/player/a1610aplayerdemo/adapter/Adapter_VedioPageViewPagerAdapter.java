package com.example.player.a1610aplayerdemo.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Adapter_VedioPageViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments = new ArrayList<>();
    private Context mContext;
    private List<String> title = new ArrayList<>();

    public Adapter_VedioPageViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, Context context, List<String> title) {
        super(fm);
        mFragments = fragments;
        mContext = context;
        this.title = title;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}