package com.example.player.a1610aplayerdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.MemberBean;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lmz on 2019/06/12
 */
public class VipView_Adapter extends RecyclerView.Adapter<VipView_Adapter.VipViewViewhoder>{
    private Context context;
    private List<MemberBean.DataBean> data =new ArrayList<>();
    public void Refresh(List<MemberBean.DataBean> data){
            this.data =data;
            notifyDataSetChanged();
    }



    @NonNull
    @Override
    public VipViewViewhoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context =viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_vip, viewGroup, false);
        return new VipViewViewhoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VipViewViewhoder vipViewViewhoder, int i) {
        Glide.with(context).load(data.get(i).getImage()).placeholder(R.drawable.ic_launcher_background).into(vipViewViewhoder.img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



    class VipViewViewhoder extends RecyclerView.ViewHolder{
        ImageView img;
        public VipViewViewhoder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.item_vip_picture);
        }
    }
}
