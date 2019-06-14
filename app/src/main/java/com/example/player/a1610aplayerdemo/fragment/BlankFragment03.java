package com.example.player.a1610aplayerdemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseView;
import com.example.player.a1610aplayerdemo.bean.LoginBean;
import com.example.player.a1610aplayerdemo.cartfragment.BuyFragment;
import com.example.player.a1610aplayerdemo.cartfragment.CartFragMentAdapter;
import com.example.player.a1610aplayerdemo.cartfragment.VipFragment;
import com.example.player.a1610aplayerdemo.vip.VipPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment03 extends Fragment implements BaseView<LoginBean> {
    private VipPresenter vipPresenter;
    private BottomNavigationBar buttonBar;
    private ViewPager vp;
    private List<Fragment> list=new ArrayList<>();

    public BlankFragment03() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment03, container, false);
        vipPresenter = new VipPresenter(this);
        vipPresenter.getLogin("4046381F8C1C2C1D0A4AB66B15205D7B", "16", "0", "20");
        initView(view);
        initAdapter();
        return view;
    }

    @Override
    public void onLoadData(LoginBean datalist) {
        Log.d("login", "" + datalist.getMessage());
    }

    @Override
    public void onLoadError(int code, String str) {
        Log.d("loginerror", "" + str);
    }



    private void initAdapter(){
        CartFragMentAdapter cartFragMentAdapter = new CartFragMentAdapter(getFragmentManager(), list);
        vp.setAdapter(cartFragMentAdapter);

        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                   buttonBar.selectTab(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        buttonBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                vp.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

    }

    private void initView(View view) {
        buttonBar = (BottomNavigationBar) view.findViewById(R.id.buttonBar);
        vp = (ViewPager) view.findViewById(R.id.cartvp);

        buttonBar.setBarBackgroundColor("#ffffff")
                .setActiveColor("#000000")
                 .setInActiveColor("#808080")
                 .addItem(new BottomNavigationItem(R.drawable.ic_icon,"已购课程"))
                 .addItem(new BottomNavigationItem(R.drawable.ic_icon2,"会员课程"))
                 .setFirstSelectedPosition(0)
                 .initialise();

        list.add(new BuyFragment());
        list.add(new VipFragment());

    }

}
