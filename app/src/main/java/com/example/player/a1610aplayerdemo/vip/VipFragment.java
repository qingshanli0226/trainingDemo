package com.example.player.a1610aplayerdemo.vip;

import android.util.Log;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewFragment;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.vip.Bean.VipBean;
import com.example.player.a1610aplayerdemo.vip.adapter.VipAdatper;
import com.example.player.a1610aplayerdemo.vip.presenter.VipPresenter;

import java.util.List;

public class VipFragment extends BaseRecyclerViewFragment<VipBean.DataBean, View> {



    @Override
    protected void initToobar() {
        toolbar.setLeftLayoutVisibility(View.GONE);
        toolbar.setRightLayoutVisibility(View.GONE);
        toolbar.setCenterLeftTextLayoutVisibility(View.GONE);
        toolbar.setCenterRightTextLayoutVisibility(View.VISIBLE);
    }

    @Override
    public BaseRecyclerViewAdapter<VipBean.DataBean, View> getAdapter() {
        return new VipAdatper();
    }

    @Override
    public IBasePresenter getPresenter() {
        return new VipPresenter();
    }
}
