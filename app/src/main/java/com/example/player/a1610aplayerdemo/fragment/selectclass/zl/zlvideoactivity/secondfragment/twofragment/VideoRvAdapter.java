package com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.secondfragment.twofragment;

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
import com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.bean.ZlvideoBean;

import java.util.ArrayList;
import java.util.List;

class VideoRvAdapter extends RecyclerView.Adapter<VideoRvAdapter.MyHolder>{

    private List<ZlvideoBean.DataBean> list = new ArrayList<>();
    private Context m_context;
    public void setList(List<ZlvideoBean.DataBean> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        m_context = viewGroup.getContext();
        View view = LayoutInflater.from(m_context).inflate(R.layout.item_video_rv,viewGroup,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        ZlvideoBean.DataBean dataBean = list.get(i);
        myHolder.video_title1.setText(dataBean.getTitle());
        myHolder.video_title2.setText(dataBean.getIntroduce());
        double price = dataBean.getPrice();
        String p = price+"";
        if (price == 0){
            p = "免费";
        }
        myHolder.video_price.setText(p);
        Glide.with(m_context).load(dataBean.getImage()).into(myHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView video_title1;
        TextView video_title2;
        TextView video_price;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_video_img);
            video_title1 = itemView.findViewById(R.id.item_video_title1);
            video_title2 = itemView.findViewById(R.id.item_video_duce);
            video_price = itemView.findViewById(R.id.item_video_price);
        }
    }
}
