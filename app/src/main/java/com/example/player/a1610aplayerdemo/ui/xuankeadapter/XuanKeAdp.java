package com.example.player.a1610aplayerdemo.ui.xuankeadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.player.a1610aplayerdemo.MyApp;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseAdapter;
import com.example.player.a1610aplayerdemo.base.BaseViewHolder;
import com.example.player.a1610aplayerdemo.bean.XuanKeDateBean;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class XuanKeAdp extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<XuanKeDateBean.DataBean.HomeBannerBean> bannerInfoBeanList = new ArrayList<>();
    List<XuanKeDateBean.DataBean.HomeCategoryBean> homeCategoryBeanList = new ArrayList<>();
    List<XuanKeDateBean.DataBean.ZlListBean> zhuanlanList = new ArrayList<>();
    List<XuanKeDateBean.DataBean.CourseRecommendsBean> tuijianlist = new ArrayList<>();
    List<XuanKeDateBean.DataBean.MasterLivesBean> dashikeList = new ArrayList<>();


    public void addBannerDate( List<XuanKeDateBean.DataBean.HomeBannerBean> bannerInfoBeanList1){
        bannerInfoBeanList.clear();
        bannerInfoBeanList.addAll(bannerInfoBeanList1);
        notifyDataSetChanged();
    }

    public void addBean( List<XuanKeDateBean.DataBean.HomeCategoryBean> bannerInfoBeanList1){
        homeCategoryBeanList.clear();
        homeCategoryBeanList.addAll(bannerInfoBeanList1);
        notifyDataSetChanged();
    }
    public void addZhuanLan( List<XuanKeDateBean.DataBean.ZlListBean> bannerInfoBeanList1){
        zhuanlanList.clear();
        zhuanlanList.addAll(bannerInfoBeanList1);
        notifyDataSetChanged();
    }
    public void addTuiJian( List<XuanKeDateBean.DataBean.CourseRecommendsBean> bannerInfoBeanList1){
       tuijianlist.clear();
        tuijianlist.addAll(bannerInfoBeanList1);
        notifyDataSetChanged();
    }

    public void addDaShi( List<XuanKeDateBean.DataBean.MasterLivesBean> bannerInfoBeanList1){
        dashikeList.clear();
        dashikeList.addAll(bannerInfoBeanList1);
        notifyDataSetChanged();
    }

    /**
     * 横幅
     */
    public static final int BANNER = 0;

    public static final int BIAOGE = 1;
    /**
     * 活动
     */
    public static final int ZHUANLAM = 2;

    public static final int TUIJIAN = 3;

    public static final int DASHIKE = 4;

    public int currentType = BANNER;



    @Override
    public int getItemViewType(int position) {
        switch (position){
            case BANNER:
                currentType = BANNER;
                break;
            case BIAOGE:
                currentType = BIAOGE;
                break;
            case ZHUANLAM:
                currentType = ZHUANLAM;
                break;
            case TUIJIAN:
                currentType = TUIJIAN;
                break;
            case DASHIKE:
                currentType = DASHIKE;

            default:break;
        }
        return currentType;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if (i == BANNER) {

            View inflate = LayoutInflater.from(MyApp.instance).inflate(R.layout.banner, viewGroup,false);
            return new BannerViewHolder(inflate);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i)==BANNER){
            BannerViewHolder bannerViewHolder = (BannerViewHolder) viewHolder;
            bannerViewHolder.setData(bannerInfoBeanList);
        }
    }

    @Override
    public int getItemCount() {
        return 1;
    }
















    class BannerViewHolder extends RecyclerView.ViewHolder {
        Banner banner;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
        public void setData(List<XuanKeDateBean.DataBean.HomeBannerBean> banner_info){

            List<String> images = new ArrayList<>();
            for (int i = 0; i < banner_info.size(); i++) {

                images.add(banner_info.get(i).getBannerUrl());
            }

            banner.setBannerAnimation(Transformer.Accordion);
            banner.setImages(images);
            banner.setImageLoader(new MyImageLoad());
            banner.start();
        }


        class MyImageLoad extends ImageLoader {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Picasso.get()
                        .load((String)path)
                        .into(imageView);
            }
        }

    }


}
