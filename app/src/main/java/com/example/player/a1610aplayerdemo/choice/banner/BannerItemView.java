package com.example.player.a1610aplayerdemo.choice.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.player.a1610aplayerdemo.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import retrofit2.http.Url;

import java.util.ArrayList;
import java.util.List;
public class BannerItemView extends LinearLayout {
    private Banner choice_banner;
    public BannerItemView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_item_banner, this);
        choice_banner = inflate.findViewById(R.id.choice_banner);
    }

    public BannerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }


    public void setChoice_bannerData(List<String> url){
        choice_banner
                .setImages(url)
                .setIndicatorGravity(Gravity.CENTER)
                .isAutoPlay(true)
                .setDelayTime(3000)
                .setImageLoader(new MyBannerLoder())
                .start();
    }


    public BannerItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    class MyBannerLoder extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Picasso.with(context)
                    .load(Uri.parse((String) path))
                    .into(imageView);
        }
    }


}
