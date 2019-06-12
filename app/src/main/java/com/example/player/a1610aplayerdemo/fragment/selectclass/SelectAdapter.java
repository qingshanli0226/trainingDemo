package com.example.player.a1610aplayerdemo.fragment.selectclass;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.fragment.selectclass.banner.BannerItemView;
import com.example.player.a1610aplayerdemo.fragment.selectclass.bean.GetHomeBean;
import com.example.player.a1610aplayerdemo.fragment.selectclass.category.CategoryItemView;
import com.example.player.a1610aplayerdemo.fragment.selectclass.course.CourseItewView;
import com.example.player.a1610aplayerdemo.fragment.selectclass.master.MasterItemView;
import com.example.player.a1610aplayerdemo.fragment.selectclass.vip.VIPItemView;
import com.example.player.a1610aplayerdemo.fragment.selectclass.zl.ZlItemView;

import java.util.ArrayList;
import java.util.List;

class SelectAdapter extends BaseRecyclerViewAdapter<Object, View> {

    private final int VIEW_TYPE_ONE = 0;
    private final int VIEW_TYPE_TWO = 1;
    private final int VIEW_TYPE_THREE = 2;
    private final int VIEW_TYPE_FORE = 3;
    private final int VIEW_TYPE_FIVE = 4;
    private final int VIEW_TYPE_SIX = 5;

    @Override
    public View getItemView(Context context, int viewType) {
        Log.i("aaa", "getItemView: "+viewType);
            switch (viewType){
          case 0:
              return new BannerItemView(context);
          case 1:
              return new CategoryItemView(context);
          case 2:
               return new VIPItemView(context);
          case 3:
                return new ZlItemView(context);
          case 4:
               return new CourseItewView(context);
                case 5:
                    return new MasterItemView(context);
                default:
                  return new CategoryItemView(context);

      }
    }


  // 没有执行此方法
    @Override
    protected int getViewType(int position) {
        return 0;
    }


    @Override
    public int getItemViewType(int position) {
        Log.i("aaa", "getViewType: "+position);
        switch (position) {
            case 0:
                return VIEW_TYPE_ONE;
            case 1:
                return VIEW_TYPE_TWO;
            case 2:
                return VIEW_TYPE_THREE;
            case 3:
                return VIEW_TYPE_FORE;
            case 4:
                return VIEW_TYPE_FIVE;
            case 5:
                return VIEW_TYPE_SIX;
            default:
                return VIEW_TYPE_THREE;
        }
    }



    @Override
    public void refreshItemUi(View itemView, Object o, int position) {
        Log.i("aaa", "refreshItemUi: "+position);
        switch (position) {
            case 0://因为是0 位置，传递的viewtype 是

                List<GetHomeBean.DataBean.HomeBannerBean> homeBanner = (List<GetHomeBean.DataBean.HomeBannerBean>) o;
                List<String> list = new ArrayList<>();
                for (int i = 0; i < homeBanner.size(); i++) {
                    list.add(homeBanner.get(i).getBannerUrl());
                }
                BannerItemView bannerItemView = (BannerItemView) itemView;
                bannerItemView.setBanner(list);
                break;
            case 1:
                List<GetHomeBean.DataBean.HomeCategoryBean> categoryBeans = (List<GetHomeBean.DataBean.HomeCategoryBean>) o;
                CategoryItemView categoryItemView = (CategoryItemView) itemView;
                categoryItemView.setCategoryData(categoryBeans);
                break;
            case 2:
                List<GetHomeBean.DataBean.VipRecommendBean> vipRecommendBeans = (List<GetHomeBean.DataBean.VipRecommendBean>) o;
                Log.i("bbb", "refreshItemUi: "+vipRecommendBeans.size());
                VIPItemView vipItemView = (VIPItemView) itemView;
                vipItemView.setGrideViewData(vipRecommendBeans);
                break;
            case 3:
                List<GetHomeBean.DataBean.ZlListBean> zlListBeans = (List<GetHomeBean.DataBean.ZlListBean>) o;
                Log.i("bbb", "refreshItemUi: "+zlListBeans.size());
               ZlItemView zlItemView = (ZlItemView) itemView;
                zlItemView.setGrideViewData(zlListBeans);
                break;
            case 4:
                List<GetHomeBean.DataBean.CourseRecommendsBean> courseRecommendsBeans = (List<GetHomeBean.DataBean.CourseRecommendsBean>) o;
                Log.i("bbb", "refreshItemUi: "+courseRecommendsBeans.size());
                CourseItewView courseItewView = (CourseItewView) itemView;
                courseItewView.setRvData(courseRecommendsBeans);
                break;

            case 5:
                List<GetHomeBean.DataBean.MasterLivesBean> masterLivesBeans = (List<GetHomeBean.DataBean.MasterLivesBean>) o;
                Log.i("bbb", "refreshItemUi: "+masterLivesBeans.size());
                MasterItemView masterItemView = (MasterItemView) itemView;
                masterItemView.setData(masterLivesBeans);
                break;

            default:

                break;
        }

    }

}
