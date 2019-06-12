package com.example.player.a1610aplayerdemo.selectclass.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.selectclass.bean.SelectBean;
import com.squareup.picasso.Picasso;

public class SelectCourseAdapter extends BaseRecyclerViewAdapter<SelectBean.CourseRecommendsBean, View> {
    @Override
    protected View getItemViewHodler(ViewGroup viewGroup, Context context, int viewType) {
        return LayoutInflater.from(context).inflate(R.layout.select_item_course,viewGroup,false);
    }

    @Override
    protected void setItemViewHolder(View view, SelectBean.CourseRecommendsBean data, int positon) {
        Picasso.get()
                .load(data.getImageUrl())
                .into(((ImageView)(view.findViewById(R.id.iv_course))));
        ((TextView)(view.findViewById(R.id.tv_course_title))).setText(data.getAppTitle());
    }
}
