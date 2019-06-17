package com.example.player.a1610aplayerdemo.ui.main.choice.zl;

import android.content.Context;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.bean.MainBean;

public class ZLItemAdapter extends BaseAdapter<MainBean.ZlListBean,ZLItemView> {
    @Override
    protected int getViewType(int position) {
        return 0;
    }

    @Override
    protected ZLItemView getView(Context context, int i) {
        return new ZLItemView(context);
    }

    @Override
    protected void setItemView(View itemView, MainBean.ZlListBean zlListBean, int i) {
        ZLItemView zlItemView = (ZLItemView) itemView;
        zlItemView.setZLItem(zlListBean,i);
    }
}
