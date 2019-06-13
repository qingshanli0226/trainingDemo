package com.example.player.a1610aplayerdemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.bean.HomeBean;
import com.example.player.a1610aplayerdemo.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class FindCategoryAdapter extends RecyclerView.Adapter<FindCategoryAdapter.MyHolder>{

    List<HomeBean.DataBean.HomeCategoryBean> list = new ArrayList<>();

    public void refresh(List<HomeBean.DataBean.HomeCategoryBean> list){
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.find_item2,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        myHolder.simpleDraweeView.setImageURI(list.get(i).getBannerUrl());
        myHolder.textView.setText(list.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView simpleDraweeView;
        TextView textView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.simpleImg);
            textView = itemView.findViewById(R.id.simpleTitle);
        }
    }

}
