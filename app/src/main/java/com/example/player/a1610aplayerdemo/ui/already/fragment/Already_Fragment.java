package com.example.player.a1610aplayerdemo.ui.already.fragment;

import android.os.Bundle;
import android.renderscript.AllocationAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.ui.already.adapter.TabLayoutAdapter;

import java.util.ArrayList;
import java.util.List;

public class Already_Fragment extends Fragment {
    private View view;
    private TabLayout alreadyTb;
    private ViewPager alreadyVp;
    private List<Fragment> list = new ArrayList<>();
    private List<String> list1 = new ArrayList<>();
    private TabLayoutAdapter tabLayoutAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.already_fragment, container, false);
        initView(view);
        alreadyTb.setupWithViewPager(alreadyVp);
        alreadyVp.setAdapter(tabLayoutAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabLayoutAdapter = new TabLayoutAdapter(getChildFragmentManager(),list1,list);
        list.add(new One_Fragment());
        list.add(new Two_Fragment());
        list1.add("已购课程");
        list1.add("会员课程");


    }

    private void initView(View view) {
        alreadyTb = (TabLayout) view.findViewById(R.id.already_tb);
        alreadyVp = (ViewPager) view.findViewById(R.id.already_vp);
    }
}