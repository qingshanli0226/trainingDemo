package com.example.player.a1610aplayerdemo.ui.home.fragment;

import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerFragment;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.ui.home.adapter.HomeAdapter;
import com.example.player.a1610aplayerdemo.ui.home.bean.HomeBean;
import com.example.player.a1610aplayerdemo.ui.home.presenter.HomePeresenter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseRecyclerFragment<Object,View>{
    private HomeAdapter adapter = new HomeAdapter();

    @Override
    public BaseRecyclerViewAdapter<Object, View> getAdapter() {
        return adapter;
    }

    @Override
    public IBasePresenter getiBasePresenter() {
        return new HomePeresenter();
    }


    @Override
    public void onLoadObject(Object data) {
        super.onLoadObject(data);
        List<Object> list = new ArrayList<>();
        HomeBean.DataBean dataBean = (HomeBean.DataBean) data;
        list.add(0,dataBean.getHomeBanner());
        list.add(1,dataBean.getHomeCategory());
        list.add(2,dataBean.getVipRecommend());
        list.add(3,dataBean.getZlList());
        list.add(4,dataBean.getCourseRecommends());
        list.add(5,dataBean.getMasterLives());
        adapter.updateData(list);
    }

}