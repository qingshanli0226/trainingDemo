package com.example.player.a1610aplayerdemo.ui.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.ui.home.bean.HomeBean;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CourseRecommendsAdapter extends RecyclerView.Adapter<CourseRecommendsAdapter.MyViewHolder>{
    private Context context;
    private List<HomeBean.DataBean.CourseRecommendsBean> list;

    public CourseRecommendsAdapter(Context context, List<HomeBean.DataBean.CourseRecommendsBean> list) {
        this.context = context;
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_courserecommends_adapter,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Picasso.with(context).load(list.get(i).getImageUrl()).into(myViewHolder.imageView);
        myViewHolder.textView.setText(list.get(i).getAppTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.courserecommends_image);
            textView = itemView.findViewById(R.id.courserecommends_tv);
        }
    }

}