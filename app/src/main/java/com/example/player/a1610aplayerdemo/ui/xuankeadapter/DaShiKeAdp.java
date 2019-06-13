package com.example.player.a1610aplayerdemo.ui.xuankeadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.base.BaseViewHolder;
import com.example.player.a1610aplayerdemo.bean.XuanKeDateBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DaShiKeAdp extends BaseAdapter<XuanKeDateBean.MasterLivesBean> {
    @Override
    protected int getLayoutId() {
        return R.layout.dashike_item;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, int position) {


        ImageView imageView = baseViewHolder.getView(R.id.ds_img);
        Picasso.get().load(data.get(position).getImageUrl()).into(imageView);

        TextView bt =  baseViewHolder.getView(R.id.ds_txr);
        bt.setText(data.get(position).getAppTitle());

        TextView price =  baseViewHolder.getView(R.id.ds_price);
        price.setText(data.get(position).getPrice()+"元");

        TextView js =  baseViewHolder.getView(R.id.ds_jiangshi);
        js.setText("   讲师:"+data.get(position).getTeacherName());

    }
}
