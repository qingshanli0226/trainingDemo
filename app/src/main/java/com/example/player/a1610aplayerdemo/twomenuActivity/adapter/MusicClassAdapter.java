package com.example.player.a1610aplayerdemo.twomenuActivity.adapter;

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
import com.example.player.a1610aplayerdemo.twomenuActivity.bean.MusicClassBean;

import java.util.ArrayList;
import java.util.List;

public class MusicClassAdapter extends RecyclerView.Adapter<MusicClassAdapter.MyMusicViewHolder> {
  private List<MusicClassBean.DataBean> data=new ArrayList<>();
  private Context context;

    public MusicClassAdapter(List<MusicClassBean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public void refresh(List<MusicClassBean.DataBean> datas){
        this.data.addAll(datas);
        notifyDataSetChanged();


    }

    @NonNull
    @Override
    public MyMusicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context=viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.musicclass_item, viewGroup, false);
        return new MyMusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyMusicViewHolder myMusicViewHolder, int i) {
        Glide.with(context).load(data.get(i).getImage()).into(myMusicViewHolder.imageView);
        myMusicViewHolder.textView.setText(data.get(i).getShortName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyMusicViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public MyMusicViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.musicclass_image);
            textView=itemView.findViewById(R.id.musicclass_Text);
        }
    }
}
