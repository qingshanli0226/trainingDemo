package com.example.player.a1610aplayerdemo.shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.login.LoginActivity;
import com.example.player.a1610aplayerdemo.shopping.fragment.ShoppingF1;
import com.example.player.a1610aplayerdemo.shopping.fragment.ShoppingF2;
import com.example.player.a1610aplayerdemo.shopping.tabadapter.TabLayoutAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShoppingFragment extends Fragment implements View.OnClickListener {
    private TabLayout shopping_tablayout;
    private ViewPager shopping_viewPager;
    private List<Fragment> list1 = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();
    private Button buy_register_btn;
    private LinearLayout buy_Linear;
    private RelativeLayout shopping_relative;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping, container, false);
        initView(view);
        tablayout();

        return view;
    }

    private void tablayout() {
        TabLayoutAdapter adapter = new TabLayoutAdapter(getChildFragmentManager(), list1, list2);
        shopping_viewPager.setAdapter(adapter);
        shopping_tablayout.setupWithViewPager(shopping_viewPager);
    }

    private void initView(View view) {
        shopping_tablayout = (TabLayout) view.findViewById(R.id.shopping_tablayout);
        shopping_viewPager = (ViewPager) view.findViewById(R.id.shopping_viewPager);
        list1.add(new ShoppingF1());
        list1.add(new ShoppingF2());
        list2.add("已购课程");
        list2.add("会员课程");
        buy_register_btn = (Button) view.findViewById(R.id.shopping_btn);
        buy_register_btn.setOnClickListener(this);
        shopping_relative = (RelativeLayout) view.findViewById(R.id.shopping_relative);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shopping_btn:
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
