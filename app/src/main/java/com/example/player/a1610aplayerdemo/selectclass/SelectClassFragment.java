package com.example.player.a1610aplayerdemo.selectclass;

import android.util.Log;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewFragment;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.selectclass.presenter.SelectPresenter;

import java.util.ArrayList;
import java.util.List;

public class SelectClassFragment extends BaseRecyclerViewFragment<Object, View> {
    private SelectClassRvAdapter selectClassRvAdapter = new SelectClassRvAdapter();
    @Override
    public BaseRecyclerViewAdapter<Object, View> getAdapter() {
        return selectClassRvAdapter;
    }

    @Override
    public IBasePresenter getPresenter() {
        return new SelectPresenter();
    }


    public void onLoadObject(Object data) {
        super.onLoadObject(data);
        List<Object> objects = new ArrayList<>();
        SelectBean selectBean = (SelectBean) data;
        Log.d("Mh",selectBean.getHomeBanner().get(1).getTitle());
        objects.add(0,selectBean.getHomeBanner());
        objects.add(1,selectBean.getHomeCategory());
        Log.d("Mh",selectBean.getHomeCategory().get(1).getTitle());
//        objects.add(2,selectBean.getCourseRecommends());
//        objects.add(3,selectBean.getMasterLives());
//        objects.add(4,selectBean.getZlList());
//        objects.add(5,selectBean.getVipRecommend());

        selectClassRvAdapter.refreshData(objects);
    }
}
