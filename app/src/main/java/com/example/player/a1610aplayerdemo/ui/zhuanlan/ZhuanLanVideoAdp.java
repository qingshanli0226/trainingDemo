package com.example.player.a1610aplayerdemo.ui.zhuanlan;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.example.player.a1610aplayerdemo.baseclassextraction.BaseRecyclerViewAdapter;
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
        zhuanLanVideoItem.updateprice(zhuanLanVideoDateBean.getPrice()+"元");
        zhuanLanVideoItem.updatetitle(zhuanLanVideoDateBean.getTitle());
        Log.d("qqqwww",zhuanLanVideoDateBean.getId()+"");

    }

    @Override
    protected int getViewType(int position) {
        return 0;
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(onItemClickListener);

    }
}
