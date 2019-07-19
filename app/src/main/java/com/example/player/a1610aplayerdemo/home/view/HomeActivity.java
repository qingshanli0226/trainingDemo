package com.example.player.a1610aplayerdemo.home.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.example.player.a1610aplayerdemo.R;

public class HomeActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private Fragment[] fragments = new Fragment[] {new OneFragment(), new TwoFragment()};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        
        initData();

        initView();
    }

    private void initData() {
    }

    private void initView() {
        viewPager = findViewById(R.id.vp);
        viewPager.setAdapter(new HomeFragmentAdapter(getSupportFragmentManager()));
        tabLayout = findViewById(R.id.tb);
        tabLayout.setupWithViewPager(viewPager);
    }

    private class HomeFragmentAdapter extends FragmentStatePagerAdapter {
        HomeFragmentAdapter(FragmentManager fm) {
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
            switch (position) {
                case 0 :
                    return "ONE";
                case 1:
                    return "TWO";
                    default:
                        return "";
            }
        }
    }
}
