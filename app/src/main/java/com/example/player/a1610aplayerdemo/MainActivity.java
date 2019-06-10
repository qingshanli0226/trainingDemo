package com.example.player.a1610aplayerdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.player.a1610aplayerdemo.home.fragment.Home_Fragment;
import com.example.player.a1610aplayerdemo.member.fragment.Member_Fragment;
import com.example.player.a1610aplayerdemo.study.fragment.Study_Fragment;
import com.example.player.a1610aplayerdemo.user.fragment.User_Fragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private ViewPager vp;
    private RadioGroup rg;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Main_Adapter adapter;
    private List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
        data();
        adapter();
        listener();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        rg = (RadioGroup) findViewById(R.id.rg);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        vp.addOnPageChangeListener(this);
    }

    private void data(){
        list.add(new Home_Fragment());
        list.add(new Member_Fragment());
        list.add(new Study_Fragment());
        list.add(new User_Fragment());
    }

    private void adapter(){
        adapter = new Main_Adapter(getSupportFragmentManager(),list);
        vp.setAdapter(adapter);
    }

    private void listener(){
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (R.id.rb1 == checkedId){
                    vp.setCurrentItem(0);
                }
                if (R.id.rb2 == checkedId){
                    vp.setCurrentItem(1);
                }
                if (R.id.rb3 == checkedId){
                    vp.setCurrentItem(2);
                }
                if (R.id.rb4 == checkedId){
                    vp.setCurrentItem(3);
                }
            }
        });
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        switch (i){
            case 0:
                rb1.setChecked(true);
                break;
            case 1:
                rb2.setChecked(true);
                break;
            case 2:
                rb3.setChecked(true);
                break;
            case 3:
                rb4.setChecked(true);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}