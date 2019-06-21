package com.example.player.a1610aplayerdemo.ui.main.choice.banner;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.example.player.a1610aplayerdemo.Constant;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.MainBean;
import com.example.player.a1610aplayerdemo.ui.main.choice.second.detail.DetailsActivity;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class BannerItemView extends LinearLayout {
    private Banner choice_banner;
    private List<String> url = new ArrayList<>();
    private Context context;
    public BannerItemView(Context context) {
        super(context);
        initView(context);
        this.context = context;
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_item_banner, this);
        choice_banner = inflate.findViewById(R.id.choice_banner);
    }

    private void getDataUrl(List<String> id) {
        url.clear();
        url.add("/restapi/apph5/viphy?pkgid=16");
        url.add("/restapi/course/getVideo2?courseId="+id.get(1)+"&packageId=0");
        url.add("/restapi/course/getVideo2?courseId="+id.get(2)+"&packageId=0");
        url.add("/restapi/course/getVideo2?courseId="+id.get(3)+"&packageId=0");
    }

    public BannerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        this.context = context;

    }


    public void setChoice_bannerData(List<MainBean.HomeBannerBean> homeBanner){
        List<String> list = new ArrayList<>();
        List<String> id = new ArrayList<>();
        for (int i1 = 0; i1 < homeBanner.size(); i1++) {
            MainBean.HomeBannerBean homeBannerBean = homeBanner.get(i1);
            list.add(homeBannerBean.getBannerUrl());
            id.add(homeBannerBean.getRelationInfo());
        }

        getDataUrl(id);

        choice_banner
                .setImages(list)
                .setIndicatorGravity(Gravity.CENTER)
                .isAutoPlay(true)
                .setDelayTime(3000)
                .setImageLoader(new MyBannerLoder())
                .start();

        choice_banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Log.e("click", "OnBannerClick: 轮播图"+position);
                getIntentActivity(url.get(position));
            }
        });
    }

    private void getIntentActivity(String s) {
        Intent intent = new Intent(getContext(), DetailsActivity.class);
        intent.putExtra(Constant.URL, s);
        Log.e("yn", "getIntentActivity: "+s);
        context.startActivity(intent);
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
