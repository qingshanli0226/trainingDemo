package com.example.player.a1610aplayerdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
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
public class RecommendAdapter extends PagerAdapter{
    private List<HomeBean.DataBean.CourseRecommendsBean> data;
    private Context context;
    public RecommendAdapter(List<HomeBean.DataBean.CourseRecommendsBean> data,Context context) {
        this.data =data;
        this.context = context;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

        return view ==o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_recommend_items,container,false);
        ImageView  img =view.findViewById(R.id.item_recommend_img);
        TextView title =view.findViewById(R.id.item_recommend_title);
        HomeBean.DataBean.CourseRecommendsBean bean = data.get(position);
        Glide.with(context).load(bean.getImageUrl()).placeholder(R.drawable.ic_launcher_background).into(img);
        title.setText(bean.getAppTitle());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
