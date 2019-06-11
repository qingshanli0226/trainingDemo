package com.example.player.a1610aplayerdemo.discover.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.discover.bean.DiscoverBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.RecommendViewHolder>{
    private List<DiscoverBean.CourseRecommendsBean> list=new ArrayList<>();
    private Context context;
    public void setList(List<DiscoverBean.CourseRecommendsBean> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public RecommendViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recommend,viewGroup,false);
        return new RecommendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendViewHolder optionViewHolder, int i) {
        Picasso.get().load(list.get(i).getImageUrl()).into(optionViewHolder.imageView);
        optionViewHolder.textView.setText(list.get(i).getAppTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecommendViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public RecommendViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.recommend_iv1);
            textView=itemView.findViewById(R.id.recommend_tv1);
        }
    }
}
