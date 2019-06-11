package com.example.player.a1610aplayerdemo.fragment.selectclass;

import android.content.Context;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.net.Contance;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

class BannerAdapter extends BaseRecyclerViewAdapter<GetHomeBean.DataBean, View> {
    List<String> bannerList = new ArrayList<>();
    private final int VIEW_TYPE_ONE = 0;

    @Override
    public View getItemView(Context context, int viewType) {
      switch (viewType){
          case 0:
              return new BannerItemView(context);
              default:
                  return new BannerItemView(context);
      }


    }

    @Override
    protected int getViewType(int position) {
        switch (position) {
            case 0:
                return VIEW_TYPE_ONE;
            default:
                return VIEW_TYPE_ONE;
        }
    }

    @Override
    public void refreshItemUi(View itemView, GetHomeBean.DataBean dataBean, int position) {
        switch (position) {
            case 0://因为是0 位置，传递的viewtype 是
                List<GetHomeBean.DataBean.HomeBannerBean> homeBanner = dataBean.getHomeBanner();
                List<String> list = new ArrayList<>();
                for (int i = 0; i < homeBanner.size(); i++) {
                    list.add(homeBanner.get(i).getBannerUrl());
                }
                BannerItemView bannerItemView = (BannerItemView) itemView;
                bannerItemView.setBanner(list);
                break;
            default:

                break;

        }

    }
}
