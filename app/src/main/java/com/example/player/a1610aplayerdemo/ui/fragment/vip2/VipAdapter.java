package com.example.player.a1610aplayerdemo.ui.fragment.vip2;


import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.bean.VipBean;
import com.example.player.a1610aplayerdemo.service.MyApplication;

import java.util.List;

public class VipAdapter extends BaseRecyclerViewAdapter<VipBean.DataBean, View> {


    public VipAdapter(List<VipBean.DataBean> list, Context context, int type) {
        super(list, context, type);
    }

    @Override
    public void refreshItemUi(BaseViewHolder holder, VipBean.DataBean itemData, int position) {
       ImageView imageView = holder.itemView.findViewById(R.id.vipf_image);
        Glide.with(MyApplication.application).load(itemData.getImage()).into(imageView);

    }


}
