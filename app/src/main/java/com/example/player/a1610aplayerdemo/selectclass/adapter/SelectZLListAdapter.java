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

public class SelectZLListAdapter extends BaseRecyclerViewAdapter<SelectBean.ZlListBean, View> {
    @Override
    protected View getItemViewHodler(ViewGroup viewGroup, Context context, int viewType) {
        return LayoutInflater.from(context).inflate(R.layout.select_item_zllist,viewGroup,false);
    }

    @Override
    protected void setItemViewHolder(View view, SelectBean.ZlListBean data, int positon) {
        Picasso.get()
                .load(data.getImage())
                .into(((ImageView)(view.findViewById(R.id.iv_zllist))));
        ((TextView)(view.findViewById(R.id.tv_zllist_title))).setText(data.getTitle());
    }
}
