package com.example.player.a1610aplayerdemo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.adapter.InterfaceFragmentPagerAdapter;
import com.example.player.a1610aplayerdemo.discover.DiscoverFragment;
import com.example.player.a1610aplayerdemo.member.MemberFragment;
import com.example.player.a1610aplayerdemo.my.MyFragment;
import com.example.player.a1610aplayerdemo.shopping.ShoppingFragment;

import java.util.ArrayList;
import java.util.List;

public class InterfaceActivity extends AppCompatActivity {
    private ViewPager interface_pager;
    private RadioButton interface_radio1;
    private RadioButton interface_radio2;
    private RadioButton interface_radio3;
    private RadioButton interface_radio4;
    private RadioGroup interface_group;
    private List<Fragment> list=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);
        initView();
        initPager();
        initItemPager();
        initItemGroup();
    }

    private void initItemGroup() {
        interface_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==interface_radio1.getId()){
                    interface_pager.setCurrentItem(0);
                }else if (checkedId==interface_radio2.getId()){
                    interface_pager.setCurrentItem(1);
                }else if (checkedId==interface_radio3.getId()){
                    interface_pager.setCurrentItem(2);
                }else if (checkedId==interface_radio4.getId()){
                    interface_pager.setCurrentItem(3);
                }
            }
        });
    }

    private void initItemPager() {
        interface_pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i==0){
                    interface_radio1.setChecked(true);
                    interface_radio2.setChecked(false);
                    interface_radio3.setChecked(false);
                    interface_radio4.setChecked(false);
                }else if (i==1){
                    interface_radio1.setChecked(false);
                    interface_radio2.setChecked(true);
                    interface_radio3.setChecked(false);
                    interface_radio4.setChecked(false);
                }else if (i==2){
                    interface_radio1.setChecked(false);
                    interface_radio2.setChecked(false);
                    interface_radio3.setChecked(true);
                    interface_radio4.setChecked(false);
                }else if (i==3){
                    interface_radio1.setChecked(false);
                    interface_radio2.setChecked(false);
                    interface_radio3.setChecked(false);
                    interface_radio4.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initPager() {
        InterfaceFragmentPagerAdapter adapter=new InterfaceFragmentPagerAdapter(getSupportFragmentManager(),list);
        interface_pager.setAdapter(adapter);
    }

    private void initView() {
        interface_pager = (ViewPager) findViewById(R.id.interface_pager);
        interface_radio1 = (RadioButton) findViewById(R.id.interface_radio1);
        interface_radio2 = (RadioButton) findViewById(R.id.interface_radio2);
        interface_radio3 = (RadioButton) findViewById(R.id.interface_radio3);
        interface_radio4 = (RadioButton) findViewById(R.id.interface_radio4);
        interface_group = (RadioGroup) findViewById(R.id.interface_group);

        list.add(new DiscoverFragment());
        list.add(new MemberFragment());
        list.add(new ShoppingFragment());
        list.add(new MyFragment());
    }
}
