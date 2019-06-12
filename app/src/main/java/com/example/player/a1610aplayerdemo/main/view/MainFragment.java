package com.example.player.a1610aplayerdemo.main.view;

import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerFragment;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.main.adapter.MainAdapter;
import com.example.player.a1610aplayerdemo.main.mode.MainBean;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends BaseRecyclerFragment<Object, View> {
    private MainAdapter mainAdapter = new MainAdapter();
    @Override
    public BaseRecyclerViewAdapter<Object, View> getAdapter() {
        return mainAdapter;
    }

    @Override
    public IBasePresenter getPresenter() {
        return null;
    }


    @Override
    public void onLoadDataBean(Object data) {
        super.onLoadDataBean(data);
        MainBean mainBean = (MainBean)data;

        List<Object> objects = new ArrayList<>();
        objects.add(0, mainBean.getHomeBanner());
        objects.add(1, mainBean.getHomeCategory());
        objects.add(2, mainBean.getVipRecommend());
        objects.add(3, mainBean.getCourseRecommends());
        objects.add(4, mainBean.getMasterLives());
        objects.add(5, mainBean.getMasterLives());

        mainAdapter.updateData(objects);
    }
}
