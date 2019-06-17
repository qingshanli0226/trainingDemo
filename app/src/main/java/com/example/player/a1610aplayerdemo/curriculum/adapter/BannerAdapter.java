package com.example.player.a1610aplayerdemo.curriculum.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.player.a1610aplayerdemo.curriculum.fragment.HourListFragment;
import com.example.player.a1610aplayerdemo.curriculum.fragment.KnowledgeFragment;

import java.util.ArrayList;
import java.util.List;

public class BannerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();
    private String[] titles = new String[]{"本课知识","课时列表"};

    public BannerAdapter(FragmentManager fm) {
        super(fm);
        initFragment();
    }

    private void initFragment() {
        fragments.add(new KnowledgeFragment());
        fragments.add(new HourListFragment());
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
