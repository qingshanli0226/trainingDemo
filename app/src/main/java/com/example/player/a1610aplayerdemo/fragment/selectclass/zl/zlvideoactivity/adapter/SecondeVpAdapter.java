package com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SecondeVpAdapter extends FragmentPagerAdapter {
    private String[] titles = {"简介","视频"};
    private List<Fragment> fragments = new ArrayList<>();
    public SecondeVpAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
       this.fragments.clear();
       this.fragments.addAll(fragments);
       notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
