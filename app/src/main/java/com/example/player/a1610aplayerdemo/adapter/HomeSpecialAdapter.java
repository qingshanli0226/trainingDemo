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

public class HomeSpecialAdapter extends RecyclerView.Adapter<HomeSpecialAdapter.MyRecomendViewHolder>  {
   private HomeBean homeBean;
   private Context rcontext;
   private  List<HomeBean.DataBean.ZlListBean> zlList;

    public HomeSpecialAdapter(HomeBean homeBeans, Context context) {
        this.homeBean = homeBeans;
        this.rcontext = context;

        zlList = homeBean.getData().getZlList();

    }

    @NonNull
    @Override
    public MyRecomendViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(rcontext).inflate(R.layout.homespecial_item, null);
        return new MyRecomendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecomendViewHolder myRecomendViewHolder, int i) {
       myRecomendViewHolder.textView.setText(zlList.get(i).getTitle());
        Glide.with(rcontext).load(zlList.get(i).getImage()).into(myRecomendViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return zlList.size() ;
    }

    class MyRecomendViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public MyRecomendViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.special_image);
            textView=itemView.findViewById(R.id.special_Text);
        }
    }

}
