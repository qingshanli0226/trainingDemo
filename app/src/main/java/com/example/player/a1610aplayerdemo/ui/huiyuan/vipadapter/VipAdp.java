package com.example.player.a1610aplayerdemo.ui.huiyuan.vipadapter;

import android.widget.ImageView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.base.OldBaseViewHolder;
import com.example.player.a1610aplayerdemo.bean.VipDateBean;
import com.squareup.picasso.Picasso;

public class VipAdp extends BaseAdapter<VipDateBean> {
    @Override
    protected int getLayoutId() {
        return R.layout.vip_listview_item;
    }

    @Override
    protected void convert(OldBaseViewHolder oldBaseViewHolder, int i) {

        ImageView im =  oldBaseViewHolder.getView(R.id.vip_item_img);

        String image = data.get(i).getImage();

        Picasso.get().load(image).into(im);

    }
}
