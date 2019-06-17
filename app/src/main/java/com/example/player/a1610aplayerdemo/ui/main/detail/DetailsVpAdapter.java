package com.example.player.a1610aplayerdemo.ui.main.detail;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.player.a1610aplayerdemo.ui.main.detail.list.ListFragment;
import com.example.player.a1610aplayerdemo.ui.main.detail.web.WebViewFragment;

public class DetailsVpAdapter extends FragmentPagerAdapter {
    private String[] strings = new String[]{
            "本课知识","课时列表"
    };

    private Fragment[] fragments;

    public DetailsVpAdapter(FragmentManager fm, Fragment[] fragments) {
        super(fm);
        this.fragments = fragments;
    }

    public DetailsVpAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments[i];
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return strings[position];
    }
}
