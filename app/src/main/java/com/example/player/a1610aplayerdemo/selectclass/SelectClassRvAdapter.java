package com.example.player.a1610aplayerdemo.selectclass;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.player.a1610aplayerdemo.MyApp;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class SelectClassRvAdapter  extends BaseRecyclerViewAdapter<SelectBean, View> {
    private final int VIEW_TYPE_HOME_BANNER = 0;

    @Override
    protected View getItemViewHodler(ViewGroup viewGroup, Context context, int viewType) {
        if(viewType == VIEW_TYPE_HOME_BANNER){
            return LayoutInflater.from(context).inflate(R.layout.select_homebanner_item,viewGroup,false);
        }
        return null;
    }

    @Override
    protected void setItemViewHolder(View view, SelectBean data, int positon) {
        if(getViewType(positon) == VIEW_TYPE_HOME_BANNER){

            List<SelectBean.DataBean.HomeBannerBean> banner_info = data.getData().getHomeBanner();
            Banner banner = ((Banner)(view.findViewById(R.id.homeBanner)));
            List<String> imageUris = new ArrayList<>();
            for (int i = 0; i < banner_info.size(); i++) {
                imageUris.add(banner_info.get(i).getBannerUrl());
            }
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            banner.setBannerAnimation(Transformer.Accordion);
            banner.setImages(imageUris);
            banner.setImageLoader(new MyImageLoad());
            banner.start();
        }
    }

    @Override
    protected int getViewType(int positon) {
        if(positon == 0){
            return VIEW_TYPE_HOME_BANNER;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    /**
     * 轮播图片加载器
     */
    class MyImageLoad extends ImageLoader{
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Picasso.get().load((String) path).into(imageView);
        }
    }
}
