package com.example.player.a1610aplayerdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.MemberBean;
import com.example.player.a1610aplayerdemo.util.MyApplication;
import com.example.player.a1610aplayerdemo.view.MemberView;

import java.util.HashMap;
import java.util.List;

public class MemberAdapter extends BaseRecyclerAdapter<MemberBean.DataBean>{

    public MemberAdapter(List<MemberBean.DataBean> list, Context context, int layId) {
        super(list, context, layId);
    }

    @Override
    public void refreshItemUi(final BaseRecyclerAdapter.BaseViewHolder holder,final MemberBean.DataBean itemData) {
        ImageView img = holder.itemView.findViewById(R.id.memberimg);
        Glide.with(MyApplication.application).load(itemData.getImage()).into(img);
    }


}
