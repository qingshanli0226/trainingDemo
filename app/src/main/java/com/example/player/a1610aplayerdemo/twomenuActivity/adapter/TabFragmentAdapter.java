package com.example.player.a1610aplayerdemo.twomenuActivity.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabFragmentAdapter extends FragmentPagerAdapter {

    private List<String> textList=new ArrayList<>();
    private List<Fragment> list=new ArrayList<>();

    public TabFragmentAdapter(FragmentManager fm, List<String> textList, List<Fragment> list) {
        super(fm);
        this.textList = textList;
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
        return textList.get(position);
    }
}
