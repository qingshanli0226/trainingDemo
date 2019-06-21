package com.example.player.a1610aplayerdemo.ui.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.example.player.a1610aplayerdemo.secondUI.activity.MusicClassActivity;

import java.util.List;

public class HomeClassAdapter extends RecyclerView.Adapter<HomeClassAdapter.MyClassViewHolder> {
    private Context acontext;
    private HomeBean mBean;
    private List<HomeBean.DataBean.HomeCategoryBean> homeCategory;

    public HomeClassAdapter(Context context, HomeBean homeBean) {
        this.acontext = context;
        this.mBean = homeBean;
        homeCategory = mBean.getData().getHomeCategory();
    }

    @NonNull
    @Override
    public MyClassViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(acontext).inflate(R.layout.homeclass_item, viewGroup, false);
        return new MyClassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyClassViewHolder myClassViewHolder, int i) {
          myClassViewHolder.textView.setText(homeCategory.get(i).getTitle());
          Glide.with(acontext).load(homeCategory.get(i).getBannerUrl()).into(myClassViewHolder.imageView);
          myClassViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent = new Intent(acontext, MusicClassActivity.class);
                  acontext.startActivity(intent);
              }
          });

    }

    @Override
    public int getItemCount() {
        return homeCategory.size();
    }

    class MyClassViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public MyClassViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.class_image);
            textView=itemView.findViewById(R.id.class_Text);
        }
    }


}
