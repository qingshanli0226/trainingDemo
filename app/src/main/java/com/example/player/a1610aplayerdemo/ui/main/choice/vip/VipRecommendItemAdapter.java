package com.example.player.a1610aplayerdemo.ui.main.choice.vip;

import android.content.Context;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.bean.MainBean;

public class VipRecommendItemAdapter extends BaseAdapter<MainBean.VipRecommendBean,VipRecommendItemView> {
    @Override
    protected int getViewType(int position) {
        return 0;
    }

    @Override
    protected VipRecommendItemView getView(Context context, int i) {
        return new VipRecommendItemView(context);
    }

    @Override
    protected void setItemView(View itemView, MainBean.VipRecommendBean vipRecommendBean, int i) {
        VipRecommendItemView vipRecommendItemView = (VipRecommendItemView) itemView;
        vipRecommendItemView.setItem(vipRecommendBean,i);
    }
}
