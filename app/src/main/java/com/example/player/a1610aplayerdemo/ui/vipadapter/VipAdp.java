package com.example.player.a1610aplayerdemo.ui.vipadapter;

import android.widget.ImageView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.base.BaseViewHolder;
import com.example.player.a1610aplayerdemo.bean.VipDateBean;
import com.squareup.picasso.Picasso;

public class VipAdp extends BaseAdapter<VipDateBean.DataBean> {
    @Override
    protected int getLayoutId() {
        return R.layout.vip_listview_item;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, int i) {

        ImageView im =  baseViewHolder.getView(R.id.vip_item_img);

        String image = data.get(i).getImage();

        Picasso.get().load(image).into(im);

    }
}
