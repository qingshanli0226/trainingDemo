package com.example.player.a1610aplayerdemo.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.bean.HomeBean;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.ui.activity.category_activity.Category1Activity;
import com.example.player.a1610aplayerdemo.ui.activity.category_activity.Category2Activity;
import com.example.player.a1610aplayerdemo.util.MyApplication;
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
    public void onBindViewHolder(@NonNull final MyHolder myHolder, int i) {
        myHolder.simpleDraweeView.setImageURI(list.get(i).getBannerUrl());
        myHolder.textView.setText(list.get(i).getTitle());
        if (i==0){
            myHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(myHolder.itemView.getContext(), Category1Activity.class);
                    myHolder.itemView.getContext().startActivity(intent);
                }
            });
        }else if (i==1){
            myHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(myHolder.itemView.getContext(), Category2Activity.class);
                    myHolder.itemView.getContext().startActivity(intent);
                }
            });
        }

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
