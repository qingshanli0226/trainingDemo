package com.example.player.a1610aplayerdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.HomeBean;

import java.util.List;

public class HomeTeachAdpter extends RecyclerView.Adapter<HomeTeachAdpter.MyTeachViewHolder> {
   private HomeBean thomeBean;
   private Context tcontext;
   private  List<HomeBean.DataBean.VipRecommendBean> vipRecommend;

    public HomeTeachAdpter(HomeBean homeBean, Context context) {
        this.thomeBean = homeBean;
        this.tcontext = context;

        vipRecommend = homeBean.getData().getVipRecommend();
//        Log.d("111",""+vipRecommend.size());
    }

    @NonNull
    @Override
    public MyTeachViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(tcontext).inflate(R.layout.homebigteach_item, null);
        return new MyTeachViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTeachViewHolder myTeachAdapter, int i) {
         myTeachAdapter.textView.setText(vipRecommend.get(i).getTitle());
        Glide.with(tcontext).load(vipRecommend.get(i).getImage()).into(myTeachAdapter.imageView);

    }

    @Override
    public int getItemCount() {
        return vipRecommend.size();
    }

    class MyTeachViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public MyTeachViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.teach_image);
            textView=itemView.findViewById(R.id.teach_Text);
        }
    }

}
