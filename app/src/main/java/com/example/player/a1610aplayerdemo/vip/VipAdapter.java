package com.example.player.a1610aplayerdemo.vip;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.VipDataBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class VipAdapter extends RecyclerView.Adapter<VipViewHolder> {
    private List<VipDataBean> list = new ArrayList<>();
    private Context context;

    public VipAdapter(Context context) {
        this.context = context;
    }

    public void upData(List<VipDataBean> vipDataBeans){
        list.clear();
        list.addAll(vipDataBeans);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public VipViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_vip_item, viewGroup, false);
        return new VipViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull VipViewHolder vipViewHolder, int i) {
        Picasso.with(context).load(list.get(i).getImage()).into(vipViewHolder.vip_vip_iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
