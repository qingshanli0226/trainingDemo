package com.example.player.a1610aplayerdemo.study.adapter;

import android.content.Context;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.study.bean.VipBean;
import com.example.player.a1610aplayerdemo.study.view.VipPicture;

public class VipAdapter extends BaseRecyclerViewAdapter<VipBean,VipPicture> {
    @Override
    public VipPicture getItemView(Context context) {
        return new VipPicture(context);
    }

    @Override
    protected void refreshItemUi(VipPicture itemView, VipBean dataBean) {
        itemView.updateImg(dataBean.getImage());
    }
}
