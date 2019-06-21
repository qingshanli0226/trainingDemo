package com.example.player.a1610aplayerdemo.ui.vip;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.VipBean;

import java.util.ArrayList;
import java.util.List;

public class VipAdapter extends RecyclerView.Adapter<VipAdapter.MyVipViewHolder> {

    private  List<VipBean.DataBean> data=new ArrayList<>();
    private Context context;

    public VipAdapter(List<VipBean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyVipViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context=viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.vip_item, viewGroup, false);
        return new MyVipViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVipViewHolder myVipViewHolder, int i) {
        Glide.with(context).load(data.get(i).getImage()).into(myVipViewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyVipViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyVipViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.vipf_image);
        }
    }


}
