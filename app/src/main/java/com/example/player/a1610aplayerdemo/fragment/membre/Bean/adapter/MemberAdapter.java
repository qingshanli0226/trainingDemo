package com.example.player.a1610aplayerdemo.fragment.membre.Bean.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.player.a1610aplayerdemo.MyApp;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.fragment.membre.Bean.bean.MenmberBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MemberAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<MenmberBean.DataBean> list=new ArrayList<>();
    public void refresh(List<MenmberBean.DataBean> lists){
        list.clear();
        list.addAll(lists);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.member,viewGroup,false);

        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        Picasso.with(MyApp.instance).load(list.get(i).getImage()).into(((MemberViewHolder) viewHolder).imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MemberViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.mem_img);
        }


    }





















}
