package com.example.player.a1610aplayerdemo.selectclass.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.player.a1610aplayerdemo.cateactivity.ui.CateValueActivity;
import com.example.player.a1610aplayerdemo.Content;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.selectclass.bean.SelectBean;
import com.squareup.picasso.Picasso;

public class SelectCategorpAdapter extends BaseRecyclerViewAdapter<SelectBean.HomeCategoryBean,View> implements BaseRecyclerViewAdapter.IItemViewClick<SelectBean.HomeCategoryBean> {

    @Override
    protected View getItemViewHodler(ViewGroup viewGroup, Context context, int viewType) {
        return LayoutInflater.from(context).inflate(R.layout.select_itme_categroy,viewGroup,false);
    }

    @Override
    protected void setItemViewHolder(View view, SelectBean.HomeCategoryBean data, int positon) {
        ((TextView)(view.findViewById(R.id.tv_cate))).setText(data.getTitle());
        ImageView imageView = ((ImageView)(view.findViewById(R.id.iv_cate)));
        Picasso.get().load(data.getBannerUrl()).into(imageView);
        setiItemViewClick(this);
    }



    @Override
    public void onItemClik(View itme, SelectBean.HomeCategoryBean data, int position) {
        Toast.makeText(itme.getContext(), "点击了"+data.getTitle()+":"+position, Toast.LENGTH_SHORT).show();
        Intent intent = null;
        if(position == 0){
            intent = new Intent(itme.getContext(), CateValueActivity.class);
            intent.putExtra(Content.CATE_FLAG_VALUE,0);
            itme.getContext().startActivity(intent);
        }

    }
}
