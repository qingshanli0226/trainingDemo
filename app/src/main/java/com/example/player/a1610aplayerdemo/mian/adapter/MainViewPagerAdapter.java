package com.example.player.a1610aplayerdemo.mian.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.example.player.a1610aplayerdemo.*;
import com.example.player.a1610aplayerdemo.selectclass.SelectClassFragment;

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {
    private Fragment[] fragments = new Fragment[]{new SelectClassFragment(),new StudyFragment(),new VipFragment(),new MyFragment()};
    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragments[i];

    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
