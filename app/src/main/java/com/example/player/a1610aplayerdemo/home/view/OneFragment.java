package com.example.player.a1610aplayerdemo.home.view;

import com.example.player.a1610aplayerdemo.base.BaseRecyclerFragment;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.home.adapter.HomeAdapter;
import com.example.player.a1610aplayerdemo.home.mode.NetDataBean;
import com.example.player.a1610aplayerdemo.home.presenter.HomePresenter;

public class OneFragment extends BaseRecyclerFragment<NetDataBean.DataBean, HomeItemView> {
    @Override
    public BaseRecyclerViewAdapter<NetDataBean.DataBean, HomeItemView> getAdapter() {
        return new HomeAdapter();
    }

    @Override
    public IBasePresenter getPresenter() {
        return new HomePresenter();
    }
}
