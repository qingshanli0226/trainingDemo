package com.example.player.a1610aplayerdemo.selectclass.ui;

import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewFragment;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.selectclass.bean.SelectBean;
import com.example.player.a1610aplayerdemo.selectclass.SelectClassRvAdapter;
import com.example.player.a1610aplayerdemo.selectclass.presenter.SelectPresenter;

import java.util.ArrayList;
import java.util.List;

public class SelectClassFragment extends BaseRecyclerViewFragment<Object, View> {
    private SelectClassRvAdapter selectClassRvAdapter = new SelectClassRvAdapter();

    @Override
    protected void initToobar() {
        toolbar.setLeftLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "点击了左边", Toast.LENGTH_SHORT).show();
            }
        });
    }

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
        objects.add(2,selectBean.getVipRecommend());
        objects.add(3,selectBean.getZlList());
        objects.add(4,selectBean.getCourseRecommends());
        objects.add(5,selectBean.getMasterLives());

        selectClassRvAdapter.refreshData(objects);
    }
}
