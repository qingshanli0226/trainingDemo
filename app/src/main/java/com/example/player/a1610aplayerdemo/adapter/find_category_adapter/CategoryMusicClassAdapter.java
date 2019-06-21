package com.example.player.a1610aplayerdemo.adapter.find_category_adapter;

import android.content.Context;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerAdapter;
import com.example.player.a1610aplayerdemo.net.bean.MusicClassBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class CategoryMusicClassAdapter extends BaseRecyclerAdapter<MusicClassBean.DataBean> {

    public CategoryMusicClassAdapter(List<MusicClassBean.DataBean> list, Context context, int layId) {
        super(list, context, layId);
        Fresco.initialize(context);
    }

    @Override
    public void refreshItemUi(final BaseViewHolder holder,final MusicClassBean.DataBean itemData) {
        SimpleDraweeView simpleDraweeView = holder.itemView.findViewById(R.id.categoryimg1);
        TextView textView = holder.itemView.findViewById(R.id.categoryname1);
        simpleDraweeView.setImageURI(itemData.getImage());
        textView.setText(itemData.getShortName());
    }


}
