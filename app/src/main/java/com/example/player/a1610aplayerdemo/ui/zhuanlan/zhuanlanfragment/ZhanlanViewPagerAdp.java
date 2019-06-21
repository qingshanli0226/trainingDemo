package com.example.player.a1610aplayerdemo.ui.zhuanlan.zhuanlanfragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ZhanlanViewPagerAdp extends FragmentPagerAdapter {
    List<Fragment> list = new ArrayList<>();
    List<String> title = new ArrayList<>();

    public ZhanlanViewPagerAdp(FragmentManager fm) {
        super(fm);
        list.add(new ZhuanlanMsgFragment());
        list.add(new ZhaunlanVideoFragment());
        list.add(new ZhuanlanAskFragment());

        title.add("简介");
        title.add("视频");
        title.add("问答");
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
        return title.get(position);
    }
}
