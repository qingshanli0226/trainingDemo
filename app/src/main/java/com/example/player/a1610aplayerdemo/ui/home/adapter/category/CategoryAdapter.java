package com.example.player.a1610aplayerdemo.ui.home.adapter.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.ui.home.bean.HomeBean;
import com.squareup.picasso.Picasso;

public class CategoryAdapter extends BaseRecyclerViewAdapter<HomeBean.DataBean.HomeCategoryBean, View> {
    @Override
    protected View getItemView(Context context, int viewtype) {
        return LayoutInflater.from(context).inflate(R.layout.item_category_adapter,null);
    }

    @Override
    protected void refreshItemUi(View itemView, HomeBean.DataBean.HomeCategoryBean homeCategory, int i) {
        ((TextView)itemView.findViewById(R.id.category_tv)).setText(homeCategory.getTitle());
        ImageView imageView = itemView.findViewById(R.id.category_iamge);
        Picasso.get().load(homeCategory.getBannerUrl()).into(imageView);
    }
}