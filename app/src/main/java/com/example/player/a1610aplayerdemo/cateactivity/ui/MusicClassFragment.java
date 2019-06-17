package com.example.player.a1610aplayerdemo.cateactivity.ui;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewFragment;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.cateactivity.Bean.MusicClassBean;
import com.example.player.a1610aplayerdemo.cateactivity.adapter.MusicClassAdapter;
import com.example.player.a1610aplayerdemo.cateactivity.presenter.MusicClassPresenter;

public class MusicClassFragment extends BaseRecyclerViewFragment<MusicClassBean.DataBean, View> {

    @Override
    protected void initToobar() {
        toolbar.setLeftImageResource(R.drawable.toolbar_back);
        toolbar.setRightLayoutVisibility(View.GONE);
        toolbar.setCenterLeftTextLayoutVisibility(View.GONE);
        toolbar.setCenterRightTextLayoutVisibility(View.VISIBLE);
        toolbar.setCenterRightText("音乐课堂");

    }

    @Override
    public BaseRecyclerViewAdapter<MusicClassBean.DataBean, View> getAdapter() {
        return new MusicClassAdapter();
    }

    @Override
    public IBasePresenter getPresenter() {
        return new MusicClassPresenter();
    }

    @Override
    protected void setRecyclerViewManager() {
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),4,LinearLayoutManager.VERTICAL,false));
    }
}
