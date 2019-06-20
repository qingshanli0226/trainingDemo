package com.example.player.a1610aplayerdemo.ui.xuanke.xuankeadapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.base.OldBaseViewHolder;
import com.example.player.a1610aplayerdemo.bean.XuanKeDateBean;
import com.squareup.picasso.Picasso;

public class TuiJianAdp extends BaseAdapter<XuanKeDateBean.CourseRecommendsBean> {


    @Override
    protected int getLayoutId() {
        return R.layout.tuijian_item;
    }

    @Override
    protected void convert(OldBaseViewHolder oldBaseViewHolder, int i) {
        XuanKeDateBean.CourseRecommendsBean data = getData(i);


        ImageView im = oldBaseViewHolder.getView(R.id.tj_img);

        Picasso.get().load(data.getImageUrl()).into(im);

        TextView textView = oldBaseViewHolder.getView(R.id.tj_txt);

        textView.setText(data.getAppTitle());

    }

}
