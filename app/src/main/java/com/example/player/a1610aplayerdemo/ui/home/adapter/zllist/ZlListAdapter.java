package com.example.player.a1610aplayerdemo.ui.home.adapter.zllist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.ui.home.bean.HomeBean;
import com.squareup.picasso.Picasso;

public class ZlListAdapter extends BaseRecyclerViewAdapter<HomeBean.DataBean.ZlListBean, View> {
    @Override
    protected View getItemView(Context context, int viewtype) {
        return LayoutInflater.from(context).inflate(R.layout.item_zllist_adapter,null);
    }

    @Override
    protected void refreshItemUi(View itemView, HomeBean.DataBean.ZlListBean zlListBean, int i) {
        ImageView imageView = itemView.findViewById(R.id.zllist_image);
        Picasso.get().load(zlListBean.getImage()).into(imageView);
        ((TextView)(itemView.findViewById(R.id.zllist_tv))).setText(zlListBean.getTitle());
    }
}