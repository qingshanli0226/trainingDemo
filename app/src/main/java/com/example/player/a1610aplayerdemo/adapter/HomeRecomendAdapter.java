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

public class HomeRecomendAdapter extends RecyclerView.Adapter<HomeRecomendAdapter.MyRecomendViewHolder>  {
   private HomeBean homeBean;
   private Context rcontext;
   private List<HomeBean.DataBean.CourseRecommendsBean> courseRecommends;

    public HomeRecomendAdapter(HomeBean homeBeans, Context context) {
        this.homeBean = homeBeans;
        this.rcontext = context;

        courseRecommends = homeBean.getData().getCourseRecommends();
    }

    @NonNull
    @Override
    public MyRecomendViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(rcontext).inflate(R.layout.homerecommend_item, null);
        return new MyRecomendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecomendViewHolder myRecomendViewHolder, int i) {
       myRecomendViewHolder.textView.setText(courseRecommends.get(i).getAppTitle());
        Glide.with(rcontext).load(courseRecommends.get(i).getImageUrl()).into(myRecomendViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return courseRecommends.size()  ;
    }

    class MyRecomendViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public MyRecomendViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.recomend_image);
            textView=itemView.findViewById(R.id.recomends_Text);
        }
    }

}
