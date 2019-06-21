package com.example.player.a1610aplayerdemo.adapter.find_category_adapter;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerAdapter;
import com.example.player.a1610aplayerdemo.net.bean.EducationBean;

import java.util.List;

public class Category5Adapter extends BaseRecyclerAdapter<EducationBean.DataBean>{
    private Context context;

    public Category5Adapter(List<EducationBean.DataBean> list, Context context, int layId) {
        super(list, context, layId);
        this.context = context;
    }

    @Override
    public void refreshItemUi(BaseViewHolder holder, EducationBean.DataBean itemData) {
        ImageView img =  holder.itemView.findViewById(R.id.category5Img);
        Glide.with(context).load(itemData.getImage()).into(img);
    }
}
