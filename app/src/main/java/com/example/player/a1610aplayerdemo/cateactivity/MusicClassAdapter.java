package com.example.player.a1610aplayerdemo.cateactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.cateactivity.Bean.MusicClassBean;

public class MusicClassAdapter extends BaseRecyclerViewAdapter<MusicClassBean.DataBean, View> implements BaseRecyclerViewAdapter.IItemViewClick<MusicClassBean.DataBean> {
    @Override
    protected View getItemViewHodler(ViewGroup viewGroup, Context context, int viewType) {
        return LayoutInflater.from(context).inflate(R.layout.select_itme_categroy,viewGroup,false);
    }

    @Override
    protected void setItemViewHolder(View view, MusicClassBean.DataBean data, int positon) {
        Glide.with(view.getContext()).load(data.getImage()).into((ImageView) view.findViewById(R.id.iv_cate));
        ((TextView) view.findViewById(R.id.tv_cate)).setText(data.getShortName());

        setiItemViewClick(this);
    }

    @Override
    public void onItemClik(View itme, MusicClassBean.DataBean data, int position) {
        Toast.makeText(itme.getContext(), "点击了："+data.getShortName()+":"+position, Toast.LENGTH_SHORT).show();
    }
}
