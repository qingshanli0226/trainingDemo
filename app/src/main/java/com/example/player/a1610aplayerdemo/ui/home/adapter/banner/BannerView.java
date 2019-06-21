package com.example.player.a1610aplayerdemo.ui.home.adapter.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.ui.home.bean.HomeBean;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class BannerView extends LinearLayout {
    private Banner banner;

    public BannerView(Context context) {
        super(context);
        initView(context);
    }

    public BannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public BannerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context context){
        LayoutInflater.from(getContext()).inflate(R.layout.item_banner,this);
        banner = findViewById(R.id.banner);
    }

    public void setdata(List<HomeBean.DataBean.HomeBannerBean> list){
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        List<String> imageUrs = new ArrayList<>();
        for (int i = 0; i < list.size();i++){
            imageUrs.add(list.get(i).getBannerUrl());
        }
        banner.setBannerAnimation(Transformer.Default);
        banner.setImageLoader(new OnLoadUrl());
        banner.setDelayTime(3000);
        banner.setImages(imageUrs)
                .start();
    }

    class OnLoadUrl extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Picasso.get().load(path + "").into(imageView);
        }
    }

}