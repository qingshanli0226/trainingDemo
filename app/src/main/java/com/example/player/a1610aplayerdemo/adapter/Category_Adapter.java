package com.example.player.a1610aplayerdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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
 * Created by Lmz on 2019/06/11
 */
public class Category_Adapter extends RecyclerView.Adapter<Category_Adapter.ItemsViewhoder>{

    private List<HomeBean.DataBean.HomeCategoryBean> data;
    private Context context;
    public Category_Adapter(List<HomeBean.DataBean.HomeCategoryBean> data,Context context) {
        this.data=data;
        this.context =context;
    }

    @NonNull
    @Override
    public ItemsViewhoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_categoty_items, viewGroup, false);

        return new ItemsViewhoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewhoder itemsViewhoder, int i) {
        HomeBean.DataBean.HomeCategoryBean bean = data.get(i);
        itemsViewhoder.title.setText(bean.getTitle());
        Glide.with(context).load(bean.getBannerUrl())
                .placeholder(R.drawable.banner_bg)
                .into(itemsViewhoder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ItemsViewhoder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        public ItemsViewhoder(@NonNull View itemView) {
            super(itemView);
            img =itemView.findViewById(R.id.items_categoty_img);
            title =itemView.findViewById(R.id.items_categoty_title);
        }
    }
}
