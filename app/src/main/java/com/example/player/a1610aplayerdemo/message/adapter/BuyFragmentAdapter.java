package com.example.player.a1610aplayerdemo.message.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.player.a1610aplayerdemo.message.fragment.BuyCourseFragment;
import com.example.player.a1610aplayerdemo.message.fragment.MemberCourseFragment;

import java.util.ArrayList;
import java.util.List;

public class BuyFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();
    private String[] titles = new String[]{"已购课程","会员课程"};

    public BuyFragmentAdapter(FragmentManager fm) {
        super(fm);
        initFragment();
    }

    private void initFragment() {
        fragments.add(new BuyCourseFragment());
        fragments.add(new MemberCourseFragment());
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
