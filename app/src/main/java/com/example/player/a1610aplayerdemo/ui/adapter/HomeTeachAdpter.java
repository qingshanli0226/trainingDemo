package com.example.player.a1610aplayerdemo.ui.adapter;

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

public class HomeTeachAdpter extends RecyclerView.Adapter<HomeTeachAdpter.MyTeachViewHolder> {
   private HomeBean thomeBean;
   private Context tcontext;
   private List<HomeBean.DataBean.MasterLivesBean> masterLives;

    public HomeTeachAdpter(HomeBean homeBean, Context context) {
        this.thomeBean = homeBean;
        this.tcontext = context;

        masterLives = thomeBean.getData().getMasterLives();

//        Log.d("111",""+vipRecommend.size());
    }

    @NonNull
    @Override
    public MyTeachViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(tcontext).inflate(R.layout.homebigteach_item, null);
        return new MyTeachViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyTeachViewHolder myTeachAdapter, int i) {
         myTeachAdapter.textView.setText(masterLives.get(i).getAppTitle());
        Glide.with(tcontext).load(masterLives.get(i).getImageUrl()).into(myTeachAdapter.imageView);
        myTeachAdapter.teachTitle.setText(masterLives.get(i).getTeacherTitle());
        myTeachAdapter.teachName.setText(masterLives.get(i).getTeacherName());
        myTeachAdapter.textPrice.setText("￥"+masterLives.get(i).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return masterLives.size();
    }

    class MyTeachViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView teachTitle;
        TextView teachName;
        TextView textPrice;

        public MyTeachViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.teach_image);
            textView=itemView.findViewById(R.id.teach_Text);
            teachTitle=itemView.findViewById(R.id.teachTitle);
            teachName=itemView.findViewById(R.id.teachName);
            textPrice=itemView.findViewById(R.id.teachPrice);
        }
    }

}
