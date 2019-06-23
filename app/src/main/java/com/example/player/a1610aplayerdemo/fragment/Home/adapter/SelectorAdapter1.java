package com.example.player.a1610aplayerdemo.fragment.Home.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.fragment.Home.bean.SelectorBean;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class SelectorAdapter1 extends BaseRecyclerViewAdapter<Object, View> {
    public static final int BANNER1=0;
    public static final int BIAOGE1=1;
    public static final int VIP1=2;
    public static final int ZHUANLAN1=3;
    public static final int TUIJIAN1=4;
    public static final int DASHIKE1=5;
    private int CURRENTER=BANNER1;
    @Override
    protected View getItemViewHolder(ViewGroup viewGroup, Context context, int ViewType) {
        if (ViewType == BANNER1) {
            return LayoutInflater.from(context).inflate(R.layout.banner_bn,viewGroup,false);
        }
        return null;
    }

    @Override
    protected void setItemViewHolder(View view, Object data, int position) {
        if (getItemViewType(position) == BANNER1) {
            List<SelectorBean.HomeBannerBean> list= (List<SelectorBean.HomeBannerBean>) data;
            Banner banner=view.findViewById(R.id.banner);
            List<String> imageUrl=new ArrayList<>();
            for (int i = 0; i <list.size(); i++) {
                imageUrl.add(list.get(i).getBannerUrl());
            }
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            banner.setBannerAnimation(Transformer.Accordion);
            banner.setImages(imageUrl);
            banner.setImageLoader(new MyImageLoad());
            banner.start();
        }
    }

    @Override
    public void setItemClickItem(IItemClickItem<Object> itemClickItem) {
        super.setItemClickItem(itemClickItem);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            CURRENTER=BANNER1;
        }
        return CURRENTER;
    }
    class MyImageLoad extends ImageLoader{
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Picasso.with(context).load((String) path).into(imageView);
        }
    }
}
