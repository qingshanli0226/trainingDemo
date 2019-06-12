package com.example.player.a1610aplayerdemo.fragment.Home.adapter;

import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.MyApp;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.base.BaseViewHolder;
import com.example.player.a1610aplayerdemo.fragment.Home.bean.SelectorBean;
import com.squareup.picasso.Picasso;
import org.w3c.dom.Text;

public class TuijianAdapter extends BaseAdapter<SelectorBean.CourseRecommendsBean> {
    @Override
    public int getLayout() {
        return R.layout.tuijian_item;
    }

    @Override
    public void convert(BaseViewHolder baseViewHolder, int i) {
        SelectorBean.CourseRecommendsBean courseRecommendsBean=getData(i);
        ImageView imageView=baseViewHolder.getView(R.id.tj_img);
        Picasso.with(MyApp.instance).load(courseRecommendsBean.getImageUrl())
                .into(imageView);
        TextView textView=baseViewHolder.getView(R.id.tj_txt);
        textView.setText(courseRecommendsBean.getTeacherName());
    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {

    }
}
