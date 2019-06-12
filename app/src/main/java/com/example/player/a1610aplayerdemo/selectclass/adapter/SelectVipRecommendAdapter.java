package com.example.player.a1610aplayerdemo.selectclass.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.selectclass.bean.SelectBean;
import com.squareup.picasso.Picasso;

public class SelectVipRecommendAdapter extends BaseRecyclerViewAdapter<SelectBean.VipRecommendBean, View> {
    @Override
    protected View getItemViewHodler(ViewGroup viewGroup, Context context, int viewType) {
        return LayoutInflater.from(context).inflate(R.layout.select_item_recommend,viewGroup,false);
    }

    @Override
    protected void setItemViewHolder(View view, SelectBean.VipRecommendBean data, int positon) {
        TextView tvTitle = ((view).findViewById(R.id.tv_title));
        TextView tvIsVip = ((view).findViewById(R.id.tv_isvip));
        TextView tvPrice = ((view).findViewById(R.id.tv_price));
        ImageView ivCommend = ((view).findViewById(R.id.iv_recommend));

        tvTitle.setText(data.getTitle());
        if(!data.isVip()){
            tvIsVip.setText("仅会员可看");
        }else {
            tvIsVip.setText("公开");
        }

        tvPrice.setText(data.getText1());
        Picasso.get()
                .load(data.getImage())
                .into(ivCommend);
    }


}
