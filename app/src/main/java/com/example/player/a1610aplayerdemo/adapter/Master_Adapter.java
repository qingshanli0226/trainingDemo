package com.example.player.a1610aplayerdemo.adapter;

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
import com.example.player.a1610aplayerdemo.bean.HomeBean;

import java.util.List;

/**
 * Created by Lmz on 2019/06/12
 */
public class Master_Adapter extends RecyclerView.Adapter<Master_Adapter.Master_ViewHoder>{
    private Context context;
    private List<HomeBean.DataBean.MasterLivesBean> data;
    public Master_Adapter(Context context, List<HomeBean.DataBean.MasterLivesBean> data) {
        this.data =data;
        this.context =context;
    }

    @NonNull
    @Override
    public Master_ViewHoder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_master_items, viewGroup, false);
        return new Master_ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Master_ViewHoder vh, int i) {
        HomeBean.DataBean.MasterLivesBean bean = data.get(i);
        Glide.with(context).load(bean.getImageUrl()).placeholder(R.drawable.ic_launcher_background)
                            .into(vh.img);
        vh.teacher.setText("讲师："+bean.getTeacherTitle());
        vh.title.setText(bean.getAppTitle());
        vh.price.setText(bean.getPrice()+"元");
        vh.type.setText(bean.getTeacherName());
        int liveStatus = bean.getLiveStatus();
        if (liveStatus==0){
            //预告
            vh.live.setText("预告");
        }else if (liveStatus==1){
            //直播
            vh.live.setText("直播中");
        }else if (liveStatus==2){
            //录播
            vh.live.setText("录播课");
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class Master_ViewHoder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView live,title,type,price,teacher;

        public Master_ViewHoder(@NonNull View itemView) {
            super(itemView);
            img =itemView.findViewById(R.id.item_master_items_img);
            live=itemView.findViewById(R.id.item_master_items_live);
            title=itemView.findViewById(R.id.item_master_items_title);
            type = itemView.findViewById(R.id.item_master_items_type);
            price=itemView.findViewById(R.id.item_master_items_price);
            teacher =itemView.findViewById(R.id.item_master_items_teacher);
        }
    }
}
