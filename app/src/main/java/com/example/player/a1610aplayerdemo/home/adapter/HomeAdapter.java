package com.example.player.a1610aplayerdemo.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.home.mode.NetDataBean;
import com.example.player.a1610aplayerdemo.home.view.HomeItemView;

public class HomeAdapter extends BaseRecyclerViewAdapter<NetDataBean.DataBean, HomeItemView> {
    @Override
    public HomeItemView getItemView(Context context) {
        return new HomeItemView(context);
    }

    @Override
    protected void refreshItemUi(HomeItemView itemView, NetDataBean.DataBean dataBean) {
         itemView.updateImg(dataBean.getPic());
    }
}
