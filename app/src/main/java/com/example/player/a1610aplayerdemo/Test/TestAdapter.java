package com.example.player.a1610aplayerdemo.Test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.NetBean;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;

public class TestAdapter extends BaseRecyclerViewAdapter<NetBean.DataBean, View> {

    @Override
    protected View getItemViewHodler(ViewGroup viewGroup, Context context) {
        return LayoutInflater.from(context).inflate(R.layout.test_item_layout,viewGroup,false);
    }

    @Override
    protected void setItemViewHolder(View view, NetBean.DataBean data) {
        ((TextView)(view.findViewById(R.id.tv_test))).setText(data.getTitle());
    }


}
