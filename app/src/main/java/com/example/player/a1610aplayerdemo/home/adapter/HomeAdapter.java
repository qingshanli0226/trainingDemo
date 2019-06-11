package com.example.player.a1610aplayerdemo.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.home.mode.NetDataBean;
import com.example.player.a1610aplayerdemo.home.view.HomeItemView;

public class HomeAdapter extends BaseRecyclerViewAdapter<NetDataBean.DataBean, View> {
    private final int VIEW_TYPE_ONE = 0;
    @Override
    public HomeItemView getItemView(Context context, int viewType) {
        switch (viewType) {
            case 0: //根据position 为0 返回的view 是HOmeImteview
                return new HomeItemView(context);
                default:
                    return new HomeItemView(context);
        }

    }

    @Override
    protected void refreshItemUi(View itemView, NetDataBean.DataBean dataBean, int postion) {
        switch (postion) {
            case 0://因为是0 位置，传递的viewtype 是
                HomeItemView homeItemView = (HomeItemView)itemView;
                homeItemView.updateImg(dataBean.getPic());
                break;
                default:
                    HomeItemView homeItemViewd = (HomeItemView)itemView;
                    homeItemViewd.updateImg(dataBean.getPic());
                    break;

        }

    }

    @Override
    public int getViewType(int postiont) {
        switch (postiont) {
            case 0:
                return VIEW_TYPE_ONE;
                default:
                    return VIEW_TYPE_ONE;
        }
    }
}
