package com.example.player.a1610aplayerdemo.test;


import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewFragment;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;


public class TestFragment extends BaseRecyclerViewFragment<NetBean.DataBean, View> {


    @Override
    public BaseRecyclerViewAdapter<NetBean.DataBean, View> getAdapter() {
        return new TestAdapter();
    }

    @Override
    public IBasePresenter getPresenter() {
        return new TestPresent();
    }
}
