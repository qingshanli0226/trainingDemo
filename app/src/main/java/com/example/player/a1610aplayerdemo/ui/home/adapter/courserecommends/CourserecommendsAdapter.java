package com.example.player.a1610aplayerdemo.ui.home.adapter.courserecommends;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.ui.home.bean.HomeBean;
import com.squareup.picasso.Picasso;

public class CourserecommendsAdapter extends BaseRecyclerViewAdapter<HomeBean.DataBean.CourseRecommendsBean, View> {
    @Override
    protected View getItemView(Context context, int viewtype) {
        return LayoutInflater.from(context).inflate(R.layout.item_courserecommends_adapter,null);
    }

    @Override
    protected void refreshItemUi(View itemView, HomeBean.DataBean.CourseRecommendsBean courseRecommendsBean, int i) {
        ImageView imageView = itemView.findViewById(R.id.courserecommends_image);
        Picasso.get().load(courseRecommendsBean.getImageUrl()).into(imageView);
        ((TextView)itemView.findViewById(R.id.courserecommends_tv)).setText(courseRecommendsBean.getAppTitle());
    }
}