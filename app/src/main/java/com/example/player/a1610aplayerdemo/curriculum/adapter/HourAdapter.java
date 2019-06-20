package com.example.player.a1610aplayerdemo.curriculum.adapter;

import android.content.Context;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.curriculum.bean.BannerBean;
import com.example.player.a1610aplayerdemo.curriculum.view.HourView;

public class HourAdapter extends BaseRecyclerViewAdapter<BannerBean.ChaptersBean,HourView> {
    @Override
    public HourView getItemView(Context context) {
        return new HourView(context);
    }

    @Override
    protected void refreshItemUi(HourView itemView, BannerBean.ChaptersBean chaptersBean) {
        itemView.updataText(chaptersBean.getShowIndexText(),chaptersBean.getName());
    }
}
