package com.example.player.a1610aplayerdemo.ui.xuankeadapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.base.OldBaseViewHolder;
import com.example.player.a1610aplayerdemo.bean.XuanKeDateBean;
import com.squareup.picasso.Picasso;

public class DaShiKeAdp extends BaseAdapter<XuanKeDateBean.MasterLivesBean> {
    @Override
    protected int getLayoutId() {
        return R.layout.dashike_item;
    }

    @Override
    protected void convert(OldBaseViewHolder oldBaseViewHolder, int position) {


        ImageView imageView = oldBaseViewHolder.getView(R.id.ds_img);
        Picasso.get().load(data.get(position).getImageUrl()).into(imageView);

        TextView bt =  oldBaseViewHolder.getView(R.id.ds_txr);
        bt.setText(data.get(position).getAppTitle());

        TextView price =  oldBaseViewHolder.getView(R.id.ds_price);
        price.setText(data.get(position).getPrice()+"元");

        TextView js =  oldBaseViewHolder.getView(R.id.ds_jiangshi);
        js.setText("   讲师:"+data.get(position).getTeacherName());

    }
}
