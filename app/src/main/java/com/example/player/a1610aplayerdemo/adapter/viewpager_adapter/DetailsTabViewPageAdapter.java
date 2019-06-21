package com.example.player.a1610aplayerdemo.adapter.viewpager_adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class DetailsTabViewPageAdapter extends FragmentPagerAdapter{
    List<String> strlist = new ArrayList<>();
    List<Fragment> frglist = new ArrayList<>();

    public DetailsTabViewPageAdapter(FragmentManager fm, List<String> strlist, List<Fragment> frglist) {
        super(fm);
        this.strlist = strlist;
        this.frglist = frglist;
    }

    @Override
    public Fragment getItem(int i) {
        return frglist.get(i);
    }

    @Override
    public int getCount() {
        return frglist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return strlist.get(position);
    }
}
