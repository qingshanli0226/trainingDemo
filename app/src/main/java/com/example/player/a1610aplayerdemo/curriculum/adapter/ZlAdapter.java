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

public class ZlAdapter extends RecyclerView.Adapter<ZlAdapter.MyViewHolder>{
    private List<Bean.DataBean.ZlListBean> list = new ArrayList<>();
    private onClickItemListener listener;
    private Context context;

    public void setListener(onClickItemListener listener) {
        this.listener = listener;
    }

    public void refresh(List<Bean.DataBean.ZlListBean> dataList) {
        this.list.clear();
        this.list.addAll(dataList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.zl_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        Picasso.with(context).load(list.get(i).getImage()).into(myViewHolder.imageView);
        myViewHolder.textView.setText(list.get(i).getTitle());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickZl(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private NiceImageView imageView;
        private TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.zl_niv);
            textView = itemView.findViewById(R.id.zl_title_tv);
        }
    }

    public interface onClickItemListener{
        void onClickZl(int index);
    }
}
