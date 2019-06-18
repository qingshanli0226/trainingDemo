package com.example.player.a1610aplayerdemo.fragment.MusicClass;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.player.a1610aplayerdemo.fragment.MusicClass.fragment.ClassKnowFragment;
import com.example.player.a1610aplayerdemo.fragment.MusicClass.fragment.TimeFragment;

public class MyViewpagerFragment extends FragmentPagerAdapter {
    Fragment[] fragments=new Fragment[]{new ClassKnowFragment(),new TimeFragment()};
    String[] strings=new String[]{"11","22"};
    public MyViewpagerFragment(FragmentManager fm) {
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
        return strings[position];
    }
}
