package com.example.player.a1610aplayerdemo.ui.xuankeadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.base.BaseViewHolder;
import com.example.player.a1610aplayerdemo.bean.XuanKeDateBean;
import com.squareup.picasso.Picasso;

public class TuiJianAdp extends BaseAdapter<XuanKeDateBean.DataBean.CourseRecommendsBean> {



    @Override
    protected int getLayoutId() {
        return R.layout.tuijian_item;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, int i) {
        XuanKeDateBean.DataBean.CourseRecommendsBean data = getData(i);


        ImageView im = baseViewHolder.getView(R.id.tj_img);

        Picasso.get().load(data.getImageUrl()).into(im);

        TextView textView = baseViewHolder.getView(R.id.tj_txt);

        textView.setText(data.getTeacherName());

    }

}
