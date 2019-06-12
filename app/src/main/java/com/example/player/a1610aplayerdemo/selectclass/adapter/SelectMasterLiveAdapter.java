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

public class SelectMasterLiveAdapter extends BaseRecyclerViewAdapter<SelectBean.MasterLivesBean, View> {
    @Override
    protected View getItemViewHodler(ViewGroup viewGroup, Context context, int viewType) {
        return LayoutInflater.from(context).inflate(R.layout.select_item_masterlive,viewGroup,false);
    }

    @Override
    protected void setItemViewHolder(View view, SelectBean.MasterLivesBean data, int positon) {
        Picasso.get()
                .load(data.getImageUrl())
                .into(((ImageView)(view.findViewById(R.id.iv_masterlive))));
        ((TextView)(view.findViewById(R.id.tv_masterlive_title))).setText(data.getAppTitle());
        ((TextView)(view.findViewById(R.id.tv_teach_name))).setText("讲师："+data.getTeacherName());
        ((TextView)(view.findViewById(R.id.tv_teach_title))).setText(data.getTeacherTitle());
        ((TextView)(view.findViewById(R.id.tv_master_price))).setText(data.getPrice()+"");

    }
}
