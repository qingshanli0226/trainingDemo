package com.example.player.a1610aplayerdemo.home.view;

import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerFragment;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.home.adapter.HomeAdapter;
import com.example.player.a1610aplayerdemo.home.mode.NetDataBean;
import com.example.player.a1610aplayerdemo.home.presenter.HomePresenter;

public class OneFragment extends BaseRecyclerFragment<NetDataBean.DataBean, View> {
    @Override
    public BaseRecyclerViewAdapter<NetDataBean.DataBean, View> getAdapter() {
        return new HomeAdapter();
    }

    @Override
    public IBasePresenter getPresenter() {
        return new HomePresenter();
    }
}
