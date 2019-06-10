package com.example.player.a1610aplayerdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;

public class TestAdapter extends BaseRecyclerViewAdapter<String, View> {

    @Override
    protected View getItemViewHodler(ViewGroup viewGroup, Context context) {
        return LayoutInflater.from(context).inflate(R.layout.test_item_layout,viewGroup,false);
    }

    @Override
    protected void setItemViewHolder(View view, String data) {
        ((TextView)(view.findViewById(R.id.tv_test))).setText(data);
    }
}
