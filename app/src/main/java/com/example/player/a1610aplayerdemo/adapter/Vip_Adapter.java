package com.example.player.a1610aplayerdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.HomeBean;

import java.util.List;

/**
 * Created by Lmz on 2019/06/11
 */
public class Vip_Adapter extends RecyclerView.Adapter<Vip_Adapter.VipViewHoder>{

    private Context context;
    private List<HomeBean.DataBean.VipRecommendBean> data;
    public Vip_Adapter(List<HomeBean.DataBean.VipRecommendBean> data, Context context) {
        this.data =data;
        this.context =context;
    }

    @NonNull
    @Override
    public VipViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_vip_items,viewGroup,false);

        return new VipViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VipViewHoder vh, int i) {
        HomeBean.DataBean.VipRecommendBean bean = data.get(i);
        Glide.with(context).load(bean.getImage()).placeholder(R.drawable.ic_launcher_background).into(vh.img);
        vh.price.setText(bean.getText1());
        vh.title.setText(bean.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class VipViewHoder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title,price;
        public VipViewHoder(@NonNull View itemView) {
            super(itemView);
            img =itemView.findViewById(R.id.items_vip_img);
            title = itemView.findViewById(R.id.items_vip_title);
            price = itemView.findViewById(R.id.items_vip_price);
        }
    }
}
