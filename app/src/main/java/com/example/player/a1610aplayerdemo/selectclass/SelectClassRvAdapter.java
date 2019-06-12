package com.example.player.a1610aplayerdemo.selectclass;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.selectclass.adapter.*;
import com.example.player.a1610aplayerdemo.selectclass.bean.SelectBean;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class SelectClassRvAdapter  extends BaseRecyclerViewAdapter<Object, View> {
    private final static int VIEW_TYPE_HOME_BANNER = 0;
    private final  static int VIEW_TYPE_HOME_CATEGORY = 1;
    private final  static int VIEW_TYPE_HOME_RECOMMEND = 2;
    private final  static int VIEW_TYPE_HOME_ZLLIST = 3;
    private final  static int VIEW_TYPE_HOME_COURSE= 4;
    private final  static int VIEW_TYPE_HOME_MASTER= 5;
    private int CURRENT_VIEW_TYPE = VIEW_TYPE_HOME_BANNER;

    @Override
    protected View getItemViewHodler(ViewGroup viewGroup, Context context, int viewType) {
        if(viewType == VIEW_TYPE_HOME_BANNER){
            return LayoutInflater.from(context).inflate(R.layout.select_homebanner_item,viewGroup,false);
        }else if(viewType == VIEW_TYPE_HOME_CATEGORY){
            return LayoutInflater.from(context).inflate(R.layout.select_category_item,viewGroup,false);
        }else if(viewType == VIEW_TYPE_HOME_RECOMMEND){
            return LayoutInflater.from(context).inflate(R.layout.select_recommend_item,viewGroup,false);
        }else if(viewType == VIEW_TYPE_HOME_ZLLIST){
            return LayoutInflater.from(context).inflate(R.layout.select_zllist_item,viewGroup,false);
        }else if(viewType == VIEW_TYPE_HOME_COURSE){
            return LayoutInflater.from(context).inflate(R.layout.select_course_item,viewGroup,false);
        }else if(viewType == VIEW_TYPE_HOME_MASTER){
            return LayoutInflater.from(context).inflate(R.layout.select_masterlive_item,viewGroup,false);
        }
        return null;
    }

    @Override
    protected void setItemViewHolder(View view, Object data, int positon) {
        if(getItemViewType(positon) == VIEW_TYPE_HOME_BANNER){
            List<SelectBean.HomeBannerBean> banner_info = (List<SelectBean.HomeBannerBean>) data;
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
        }else if(getItemViewType(positon)  == VIEW_TYPE_HOME_CATEGORY){
            List<SelectBean.HomeCategoryBean> cate_info = (List<SelectBean.HomeCategoryBean>) data;
            RecyclerView recyclerView = ((RecyclerView)(view.findViewById(R.id.rv_select_categor)));
            recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),4, LinearLayoutManager.VERTICAL,false));
            SelectCategorpAdapter adapter = new SelectCategorpAdapter();
            recyclerView.setAdapter(adapter);
            adapter.refreshData(cate_info);
        }else if(getItemViewType(positon) == VIEW_TYPE_HOME_RECOMMEND){
            List<SelectBean.VipRecommendBean> vipCommend_info = (List<SelectBean.VipRecommendBean>) data;
            RecyclerView recyclerView = ((RecyclerView)(view.findViewById(R.id.recommend_rv)));
            recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),2, LinearLayoutManager.VERTICAL,false));
            SelectVipRecommendAdapter adapter = new SelectVipRecommendAdapter();
            recyclerView.setAdapter(adapter);
            adapter.refreshData(vipCommend_info);
        }else if(getItemViewType(positon) == VIEW_TYPE_HOME_ZLLIST){
            List<SelectBean.ZlListBean> zlListBeans = (List<SelectBean.ZlListBean>) data;
            RecyclerView recyclerView = ((RecyclerView)(view.findViewById(R.id.zllist_rv)));
            recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),2, LinearLayoutManager.VERTICAL,false));
            SelectZLListAdapter adapter = new SelectZLListAdapter();
            recyclerView.setAdapter(adapter);
            adapter.refreshData(zlListBeans);
        }else if(getItemViewType(positon) == VIEW_TYPE_HOME_COURSE){
            List<SelectBean.CourseRecommendsBean> zlListBeans = (List<SelectBean.CourseRecommendsBean>) data;
            RecyclerView recyclerView = ((RecyclerView)(view.findViewById(R.id.course_rv)));
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false));
            SelectCourseAdapter adapter = new SelectCourseAdapter();
            recyclerView.setAdapter(adapter);
            adapter.refreshData(zlListBeans);
        }else if(getItemViewType(positon) == VIEW_TYPE_HOME_MASTER){
            List<SelectBean.MasterLivesBean> masterLivesBeans = (List<SelectBean.MasterLivesBean>) data;
            RecyclerView recyclerView = ((RecyclerView)(view.findViewById(R.id.masterlive_rv)));
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));
            SelectMasterLiveAdapter adapter = new SelectMasterLiveAdapter();
            recyclerView.setAdapter(adapter);
            adapter.refreshData(masterLivesBeans);
        }

    }


    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            CURRENT_VIEW_TYPE =  VIEW_TYPE_HOME_BANNER;
        }else if(position == 1){
            CURRENT_VIEW_TYPE =  VIEW_TYPE_HOME_CATEGORY;
        }else if(position == 2){
            CURRENT_VIEW_TYPE = VIEW_TYPE_HOME_RECOMMEND;
        }else if(position == 3){
            CURRENT_VIEW_TYPE = VIEW_TYPE_HOME_ZLLIST;
        }else if(position == 4){
            CURRENT_VIEW_TYPE = VIEW_TYPE_HOME_COURSE;
        }else if(position == 5){
            CURRENT_VIEW_TYPE = VIEW_TYPE_HOME_MASTER;
        }
        return CURRENT_VIEW_TYPE;
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
