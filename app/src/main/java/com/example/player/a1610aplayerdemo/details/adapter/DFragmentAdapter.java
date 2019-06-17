package com.example.player.a1610aplayerdemo.details.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.example.player.a1610aplayerdemo.details.ui.KnowLedgeFragment;
import com.example.player.a1610aplayerdemo.details.ui.PeriodListFragment;

public class DFragmentAdapter extends FragmentStatePagerAdapter {
    private String[] titles = new String[]{"本课知识","课时列表"};
    private Fragment[] fragments = new Fragment[]{new KnowLedgeFragment(),new PeriodListFragment()};
    public DFragmentAdapter(FragmentManager fm) {
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

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }



}
