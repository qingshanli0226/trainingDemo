package com.example.player.a1610aplayerdemo.secondUI.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseFragment;
import com.example.player.a1610aplayerdemo.base.BaseView;
import com.example.player.a1610aplayerdemo.secondUI.bean.BannerBean;
import com.example.player.a1610aplayerdemo.secondUI.fragment.classhours_util.ClassHoursAdapter;
import com.example.player.a1610aplayerdemo.secondUI.fragment.classhours_util.ClassHoursPersenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassHoursFragment extends BaseFragment<BannerBean.DataBean,View> implements BaseView<BannerBean> {
    RecyclerView recyclerView;

    ClassHoursPersenter classHoursPersenter = new ClassHoursPersenter();

    @Override
    protected View getContentView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View view = layoutInflater.inflate(R.layout.fragment_class_hours, viewGroup, false);

        Intent intent = getActivity().getIntent();
        String relation = intent.getStringExtra("relation");

        classHoursPersenter.attachview(this);
        classHoursPersenter.gitBannerData(relation,"0");
        initView(view);
        return view;
    }



    @Override
    public void onLoadData(BannerBean datalist) {
        BannerBean.DataBean data = datalist.getData();
        List<BannerBean.DataBean.ChaptersBean> chapters = data.getChapters();
        ClassHoursAdapter classHoursAdapter = new ClassHoursAdapter(chapters, getContext(), R.layout.class_hours_item);
        recyclerView.setAdapter(classHoursAdapter);

    }

    @Override
    public void onLoadError(int code, String str) {
        Log.d("errorBanner课时列表",str+"");

    }

    private void initView(View view){
        recyclerView = view.findViewById(R.id.rv_classhours);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
