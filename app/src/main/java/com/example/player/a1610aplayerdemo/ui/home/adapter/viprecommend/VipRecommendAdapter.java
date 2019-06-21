package com.example.player.a1610aplayerdemo.ui.home.adapter.viprecommend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.ui.home.bean.HomeBean;
import com.squareup.picasso.Picasso;

public class VipRecommendAdapter extends BaseRecyclerViewAdapter<HomeBean.DataBean.VipRecommendBean, View> {

    @Override
    protected View getItemView(Context context, int viewtype) {
        return LayoutInflater.from(context).inflate(R.layout.item_viprecommend_adapter,null);
    }

    @Override
    protected void refreshItemUi(View itemView, HomeBean.DataBean.VipRecommendBean vipRecommendBean, int i) {
        ImageView imageView = itemView.findViewById(R.id.vip_image);
        Picasso.get().load(vipRecommendBean.getImage()).into(imageView);
        ((TextView)(itemView.findViewById(R.id.vip_tv1))).setText(vipRecommendBean.getTitle());
        ((TextView)(itemView.findViewById(R.id.vip_tv2))).setText(vipRecommendBean.getText1());
    }
}