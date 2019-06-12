package com.example.player.a1610aplayerdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.HomeBean;

import java.util.List;

/**
 * Created by Lmz on 2019/06/12
 */
public class Special_Adapter extends RecyclerView.Adapter<Special_Adapter.SpViewhoder>{
    private Context context;
    private  List<HomeBean.DataBean.ZlListBean> data;
    public Special_Adapter(Context context, List<HomeBean.DataBean.ZlListBean> data) {
        this.context =context;
        this.data = data;
    }

    @NonNull
    @Override
    public SpViewhoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_special_items, viewGroup, false);
        return new SpViewhoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpViewhoder spViewhoder, int i) {
        HomeBean.DataBean.ZlListBean bean = data.get(i);
        Glide.with(context).load(bean.getImage()).placeholder(R.drawable.ic_launcher_background)
                            .into(spViewhoder.img);
        spViewhoder.title.setText(bean.getTitle());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class SpViewhoder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        public SpViewhoder(@NonNull View itemView) {
            super(itemView);
            img =itemView.findViewById(R.id.item_special_img);
            title =itemView.findViewById(R.id.item_special_title);
        }
    }
}
