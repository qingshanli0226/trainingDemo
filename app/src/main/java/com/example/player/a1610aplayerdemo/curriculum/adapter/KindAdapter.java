package com.example.player.a1610aplayerdemo.curriculum.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.curriculum.bean.Bean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class KindAdapter extends RecyclerView.Adapter<KindAdapter.MyViewHolder>{
    private List<Bean.DataBean.HomeCategoryBean> list = new ArrayList<>();
    private onClickItemListener listener;
    private Context context;

    public void setListener(onClickItemListener listener) {
        this.listener = listener;
    }

    public void refresh(List<Bean.DataBean.HomeCategoryBean> dataList) {
        this.list.clear();
        this.list.addAll(dataList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.kind_item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        Picasso.with(context).load(list.get(i).getBannerUrl()).into(myViewHolder.imageView);
        myViewHolder.textView.setText(list.get(i).getTitle());
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickKind(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.kind_iv);
            textView = itemView.findViewById(R.id.kind_tv);
        }
    }

    public interface onClickItemListener{
        void onClickKind(int index);
    }
}
