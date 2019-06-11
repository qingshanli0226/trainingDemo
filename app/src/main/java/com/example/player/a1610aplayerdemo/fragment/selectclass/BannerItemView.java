package com.example.player.a1610aplayerdemo.fragment.selectclass;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import java.util.List;

public class BannerItemView extends LinearLayout {

    Banner banner;
    Context m_context;

    public BannerItemView(Context context) {
        super(context);
        m_context = context;
        initView(context);
    }


    public BannerItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        m_context = context;
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_banner, this);
        banner = inflate.findViewById(R.id.m_banner);
    }

    public void setBanner(List<String> homeBanner){
        banner .setImages(homeBanner)
                .isAutoPlay(true)
                .setDelayTime(1000)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {

                        Glide.with(context).load(path).into(imageView);
                    }
                })
                .start();
    }

}
