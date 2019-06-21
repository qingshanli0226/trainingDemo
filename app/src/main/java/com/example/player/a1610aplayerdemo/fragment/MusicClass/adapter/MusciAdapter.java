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
import com.example.player.a1610aplayerdemo.fragment.MusicClass.bean.MbBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MusciAdapter extends RecyclerView.Adapter<MusciAdapter.MyViewHolders> {
    List<MbBean.DataBean> dataBeans=new ArrayList<>();

    public MusciAdapter(List<MbBean.DataBean> dataBeans, ItemClick itemClick) {
        this.dataBeans = dataBeans;
        this.itemClick = itemClick;
    }

    public void refresh(List<MbBean.DataBean> m){
        dataBeans.clear();
        dataBeans.addAll(m);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolders onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mbitem,viewGroup,false);

        return new MyViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolders myViewHolders, final int i) {
        myViewHolders.textView.setText(dataBeans.get(i).getShortName());
        Picasso.with(MyApp.instance).load(dataBeans.get(i).getImage()).into(myViewHolders.imageView);
//        dataBeans.get(i).get
//        dataBeans.get(i).get
        myViewHolders.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.onClick(i);
//                Toast.makeText(MyApp.instance, ""+i, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    class MyViewHolders extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MyViewHolders(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.mb_img);
            textView=itemView.findViewById(R.id.tv_img);
        }
    }
    public interface ItemClick{
        void onClick(int position);
    }
    private ItemClick  itemClick;

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public MusciAdapter(ItemClick itemClick) {
        this.itemClick = itemClick;
    }
}
