package com.example.player.a1610aplayerdemo.ui.zhuanlan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import com.example.player.a1610aplayerdemo.Base_class_extraction.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.bean.ZhuanLanVideoDateBean;

public class ZhuanLanVideoAdp extends BaseRecyclerViewAdapter<ZhuanLanVideoDateBean, View> {
    @Override
    protected View getItemView(Context context, int viewType) {
        return new ZhuanLanVideoItem(context);
    }

    @Override
    protected void refreshItemUi(View itemView, ZhuanLanVideoDateBean zhuanLanVideoDateBean, int i) {
        ZhuanLanVideoItem zhuanLanVideoItem = (ZhuanLanVideoItem) itemView;
        zhuanLanVideoItem.updateImg(zhuanLanVideoDateBean.getImage());

    }

    @Override
    protected int getViewType(int position) {
        return 0;
    }


}
