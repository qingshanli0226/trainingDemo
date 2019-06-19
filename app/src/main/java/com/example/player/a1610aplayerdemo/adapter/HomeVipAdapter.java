package com.example.player.a1610aplayerdemo.adapter;

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
import com.example.player.a1610aplayerdemo.twomenuActivity.activity.BannerActivity;

import java.util.List;

public class HomeVipAdapter extends RecyclerView.Adapter<HomeVipAdapter.MyVipViewHolder> {

    private HomeBean vHomeBean;
    private Context vContext;
    private  List<HomeBean.DataBean.VipRecommendBean> vipRecommend;

    public HomeVipAdapter(HomeBean homeBean, Context context) {
        this.vHomeBean = homeBean;
        this.vContext = context;

        vipRecommend = vHomeBean.getData().getVipRecommend();

    }

    @NonNull
    @Override
    public MyVipViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(vContext).inflate(R.layout.homevip_item, null);
        return new MyVipViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVipViewHolder myVipViewHolder, final int i) {
       myVipViewHolder.textView.setText(vipRecommend.get(i).getTitle());
       myVipViewHolder.textView1.setText(vipRecommend.get(i).getText1());
        Glide.with(vContext).load(vipRecommend.get(i).getImage()).into(myVipViewHolder.imageView);


        myVipViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vContext, BannerActivity.class);
                intent.putExtra("relation",vipRecommend.get(i).getDataId()+"");
                vContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return vipRecommend.size();
    }

    class MyVipViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView textView1;
        public MyVipViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.vip_image);
            textView=itemView.findViewById(R.id.vip_Text);
            textView1=itemView.findViewById(R.id.viptext1);

        }
    }
}
