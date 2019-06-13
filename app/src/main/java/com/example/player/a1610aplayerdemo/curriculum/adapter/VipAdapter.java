package com.example.player.a1610aplayerdemo.curriculum.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.curriculum.bean.Bean;
import com.othershe.library.NiceImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class VipAdapter extends RecyclerView.Adapter<VipAdapter.MyViewHolder>{
    private List<Bean.VipRecommendBean> list = new ArrayList<>();
    private onClickItemListener listener;
    private Context context;

    public void setListener(onClickItemListener listener) {
        this.listener = listener;
    }

    public void refresh(List<Bean.VipRecommendBean> dataList) {
        this.list.clear();
        this.list.addAll(dataList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.curriculum_vip_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        Picasso.with(context).load(list.get(i).getImage()).into(myViewHolder.imageView);
        myViewHolder.textView.setText(list.get(i).getTitle());
        myViewHolder.vipText.setText(list.get(i).getText1());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickVip(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private NiceImageView imageView;
        private TextView textView,vipText;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.vip_niv);
            textView = itemView.findViewById(R.id.vip_title_tv);
            vipText = itemView.findViewById(R.id.vip_vip_tv);
        }
    }

    public interface onClickItemListener{
        void onClickVip(int index);
    }
}
