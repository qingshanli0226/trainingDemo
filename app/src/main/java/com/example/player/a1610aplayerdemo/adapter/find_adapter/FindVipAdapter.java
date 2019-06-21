package com.example.player.a1610aplayerdemo.adapter.find_adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.player.a1610aplayerdemo.net.bean.HomeBean;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.ui.activity.DetailsPageActivity;

import java.util.ArrayList;
import java.util.List;

public class FindVipAdapter extends RecyclerView.Adapter<FindVipAdapter.MyHolder>{

    List<HomeBean.DataBean.VipRecommendBean> list = new ArrayList<>();
    Context context;

    public void refresh(List<HomeBean.DataBean.VipRecommendBean> list){
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        return new MyHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.find_item4,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, final int i) {
        Glide.with(context)
                .load(list.get(i).getImage())
                .asBitmap()
                .into(new BitmapImageViewTarget(myHolder.simpleDraweeView){
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(15); //设置圆角弧度
                        myHolder.simpleDraweeView.setImageDrawable(circularBitmapDrawable);
                    }
                });
        myHolder.textView.setText(list.get(i).getTitle());
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myHolder.itemView.getContext(), DetailsPageActivity.class);
                intent.putExtra("dateId",String.valueOf(list.get(i).getDataId()));
                intent.putExtra("dateType",String.valueOf(list.get(i).getDataType()));
                myHolder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        ImageView simpleDraweeView;
        TextView textView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.simpleImg);
            textView = itemView.findViewById(R.id.simpleTitle);
        }
    }

}
