package com.example.player.a1610aplayerdemo.ui.alreadybought.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class TabLayoutAdapter extends FragmentPagerAdapter {
    private List<String> list1;
    private List<Fragment> list;


    public TabLayoutAdapter(FragmentManager fm,List<String> list1,List<Fragment> list) {
        super(fm);
        this.list1 = list1;
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list1.get(position);
    }
}