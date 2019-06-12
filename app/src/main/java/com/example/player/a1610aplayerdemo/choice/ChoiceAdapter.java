package com.example.player.a1610aplayerdemo.choice;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.bean.MainBean;
import com.example.player.a1610aplayerdemo.choice.advertising.AdvertisingView;
import com.example.player.a1610aplayerdemo.choice.banner.BannerItemView;
import com.example.player.a1610aplayerdemo.choice.category.CategoryView;
import com.example.player.a1610aplayerdemo.choice.vip.VipRecommendView;
import com.example.player.a1610aplayerdemo.choice.zl.ZLView;

import java.util.ArrayList;
import java.util.List;

public class ChoiceAdapter extends BaseAdapter<Object, View> {
    private final int BANNER = 0;
    private final int CATEGORY = 1;//Category种类
    private final int VIPRECOMMEND = 2;//VIP专享
    private final int advertising = 3;
    private final int ZLLIST = 4;//专栏
    private final int COURSERECOMMENDS = 5;//推荐课程
    private final int MASTERLIVES = 6;
    private int count = 0;
    @Override
    protected int getViewType(int position) {
        switch (position) {
            case BANNER:
                count = BANNER;
                break;
            case CATEGORY:
                count = CATEGORY;
                break;
            case VIPRECOMMEND:
                count = VIPRECOMMEND;
                break;
            case ZLLIST:
                count = ZLLIST;
                break;
            case COURSERECOMMENDS :
                count = COURSERECOMMENDS;
                break;
            case MASTERLIVES:
                count = MASTERLIVES;
                break;
            case advertising:
                count = advertising;
                break;
        }
        Log.e("yn", "getViewType: "+count);
        return count;
    }

    @Override
    protected View getView(Context context, int i) {
       if(count == BANNER){
           return new BannerItemView(context);
       }else if(count == CATEGORY){
           return new CategoryView(context);
       }else if (count == VIPRECOMMEND){
           return new VipRecommendView(context);
       }else if(count == advertising){
           return new AdvertisingView(context);
       }else if (count == ZLLIST){
           return new ZLView(context);
       }
        return null;
    }

    @Override
    protected void setItemView(View itemView, Object o, int i) {

        if(i == BANNER){
            BannerItemView bannerItemView = (BannerItemView) itemView;
            List<MainBean.HomeBannerBean> homeBanner = (List<MainBean.HomeBannerBean>) o;
            List<String> list = new ArrayList<>();
            for (int i1 = 0; i1 < homeBanner.size(); i1++) {
                list.add(homeBanner.get(i1).getBannerUrl());
            }
            bannerItemView.setChoice_bannerData(list);
        }else if (i == CATEGORY){
            CategoryView categoryItemView = (CategoryView) itemView;
            List<MainBean.HomeCategoryBean> categoryBeans = (List<MainBean.HomeCategoryBean>) o;
            categoryItemView.setCategoryData(categoryBeans);
        }else if (i == VIPRECOMMEND){
            VipRecommendView vipRecommendView = (VipRecommendView) itemView;
            List<MainBean.VipRecommendBean> vipRecommendBeans = (List<MainBean.VipRecommendBean>) o;
            vipRecommendView.setVipData(vipRecommendBeans);
        }else if(i == advertising){
            AdvertisingView advertisingView = (AdvertisingView) itemView;
        }else if (i == ZLLIST){
            ZLView zlView = (ZLView) itemView;
            List<MainBean.ZlListBean> zlListBeans = (List<MainBean.ZlListBean>) o;
            zlView.setZLView(zlListBeans);
        }
    }



}
