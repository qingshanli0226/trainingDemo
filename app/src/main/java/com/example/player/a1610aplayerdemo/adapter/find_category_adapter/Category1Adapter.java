package com.example.player.a1610aplayerdemo.adapter.find_category_adapter;

import android.content.Context;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerAdapter;
import com.example.player.a1610aplayerdemo.net.bean.MusicClassBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class Category1Adapter extends BaseRecyclerAdapter<MusicClassBean.DataBean>{
    public Category1Adapter(List<MusicClassBean.DataBean> list, Context context, int layId) {
        super(list, context, layId);
        Fresco.initialize(context);
    }

    @Override
    public void refreshItemUi(BaseViewHolder holder, MusicClassBean.DataBean itemData) {
        SimpleDraweeView img =  holder.itemView.findViewById(R.id.category1Img);
        TextView name =  holder.itemView.findViewById(R.id.category1Name);
        img.setImageURI(itemData.getImage());
        name.setText(itemData.getShortName());
    }
}
