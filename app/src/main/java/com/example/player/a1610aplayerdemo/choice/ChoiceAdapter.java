package com.example.player.a1610aplayerdemo.choice;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.bean.MainBean;
import com.example.player.a1610aplayerdemo.choice.banner.BannerItemView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ChoiceAdapter extends BaseAdapter<Object, BannerItemView> {
    private final int BANNER = 0;
    private final int CATEGORY = 1;//Category种类
    private final int VIPRECOMMEND = 2;//VIP专享
    private final int ZLLIST = 3;//专栏
    private final int COURSERECOMMENDS = 4;//推荐课程
    private final int MASTERLIVES = 5;
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
        }
        Log.e("yn", "getViewType: "+count);
        return count;
    }

    @Override
    protected BannerItemView getView(Context context, int i) {
       if(count == BANNER){
           return new BannerItemView(context);
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
        }
    }



}
