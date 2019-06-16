package com.example.player.a1610aplayerdemo.vip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.vip.Bean.VipBean;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VipAdatper extends BaseRecyclerViewAdapter<VipBean.DataBean, View> {


    @Override
    protected View getItemViewHodler(ViewGroup viewGroup, Context context, int viewType) {
        return LayoutInflater.from(context).inflate(R.layout.vip_item,viewGroup,false);
    }

    @Override
    protected void setItemViewHolder(View view, VipBean.DataBean data, int positon) {
//        Picasso.get().load(data.getImage()).into((ImageView) view.findViewById(R.id.iv_vip));
        Glide.with(view.getContext())
                .load(data.getImage())
                .into((ImageView) view.findViewById(R.id.iv_vip));
    }
}
