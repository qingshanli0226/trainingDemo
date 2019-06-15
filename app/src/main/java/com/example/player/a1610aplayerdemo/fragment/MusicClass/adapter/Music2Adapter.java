package com.example.player.a1610aplayerdemo.fragment.MusicClass.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.MyApp;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.fragment.MusicClass.bean.Mb2Bean;
import com.squareup.picasso.Picasso;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Music2Adapter extends RecyclerView.Adapter<Music2Adapter.MyViewHolders> {
    List<Mb2Bean.DataBean> list = new ArrayList<>();

//    public Music2Adapter(List<Mb2Bean.DataBean> list) {
//        this.list = list;
//    }
    public void refresh(List<Mb2Bean.DataBean> s){
        list.clear();
        list.addAll(s);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolders onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.music2, viewGroup, false);
        return new MyViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolders myViewHolders, int i) {
        myViewHolders.tvname.setText(list.get(i).getAppName());
        myViewHolders.tvTcName.setText(list.get(i).getTeacherName());
        myViewHolders.tvPrice.setText(list.get(i).getPrice()+"");
        myViewHolders.textJS.setText(list.get(i).getTeacherTitle());
        Picasso.with(MyApp.instance).load(list.get(i).getImage()).into(myViewHolders.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolders extends RecyclerView.ViewHolder {
        TextView tvname;
        TextView tvPrice;
        TextView tvTcName;
        TextView textJS;
        ImageView imageView;
        public MyViewHolders(@NonNull View itemView) {
            super(itemView);
            tvname=itemView.findViewById(R.id.tv_name);
            tvPrice=itemView.findViewById(R.id.tv_money);
            tvTcName=itemView.findViewById(R.id.tv_tc_name);
            textJS=itemView.findViewById(R.id.tv_jieshao);
            imageView=itemView.findViewById(R.id.mb2_img);
        }
    }
}
