package com.example.player.a1610aplayerdemo.ui.home.homeactivity.zllistactivity.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class Home_Four_TabAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private List<String> list1;

    public Home_Four_TabAdapter(FragmentManager fm,List<Fragment> list,List<String> list1) {
        super(fm);
        this.list = list;
        this.list1 = list1;
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