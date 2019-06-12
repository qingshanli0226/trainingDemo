package com.example.player.a1610aplayerdemo.selectclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.squareup.picasso.Picasso;

public class SelectCategorpAdapter extends BaseRecyclerViewAdapter<SelectBean.HomeCategoryBean,View> {

    @Override
    protected View getItemViewHodler(ViewGroup viewGroup, Context context, int viewType) {
        return LayoutInflater.from(context).inflate(R.layout.select_itme_categroy,viewGroup,false);
    }

    @Override
    protected void setItemViewHolder(View view, SelectBean.HomeCategoryBean data, int positon) {
        ((TextView)(view.findViewById(R.id.tv_cate))).setText(data.getTitle());
        ImageView imageView = ((ImageView)(view.findViewById(R.id.iv_cate)));
        Picasso.get().load(data.getBannerUrl()).into(imageView);
    }


}
