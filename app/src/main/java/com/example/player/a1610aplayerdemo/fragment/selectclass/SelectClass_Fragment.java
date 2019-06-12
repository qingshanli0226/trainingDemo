package com.example.player.a1610aplayerdemo.fragment.selectclass;


import android.support.v4.app.Fragment;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerFragment;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.fragment.selectclass.bean.GetHomeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectClass_Fragment extends BaseRecyclerFragment<Object,View > {
SelectAdapter adapter = new SelectAdapter();

    public SelectClass_Fragment() {
        // Required empty public constructor
    }


    @Override
    public BaseRecyclerViewAdapter<Object, View> getAdapter() {
        return adapter;
    }

    @Override
    public IBasePresenter getPresenter() {
        return new SelectPresent();
    }

    @Override
    public void onLoadObject(Object data) {
        super.onLoadObject(data);
        List<Object> objects = new ArrayList<>();
        GetHomeBean.DataBean d = (GetHomeBean.DataBean) data;

        objects.add(0,d.getHomeBanner());
        objects.add(1,d.getHomeCategory());
       objects.add(2,d.getVipRecommend());
        objects.add(3,d.getZlList());
        objects.add(4,d.getCourseRecommends());
        objects.add(5,d.getMasterLives());
        adapter.upData(objects);

    }
}
