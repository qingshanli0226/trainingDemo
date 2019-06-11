package com.example.player.a1610aplayerdemo.ui.xuankeadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import com.example.player.a1610aplayerdemo.MyApp;
import com.example.player.a1610aplayerdemo.R;
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
    List<XuanKeDateBean.DataBean.VipRecommendBean> vipBeanList = new ArrayList<>();
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

    public void addVip( List<XuanKeDateBean.DataBean.VipRecommendBean> bannerInfoBeanList1){
        vipBeanList.clear();
        vipBeanList.addAll(bannerInfoBeanList1);
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

    public static final int VIPZX = 2;

    public static final int ZHUANLAM = 3;

    public static final int TUIJIAN = 4;

    public static final int DASHIKE = 5;

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
            case VIPZX:
                currentType = VIPZX;
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

            View inflate = LayoutInflater.from(MyApp.instance).inflate(R.layout.banner_bn, viewGroup,false);
            return new BannerViewHolder(inflate);

        }else if (i == BIAOGE) {

            View inflate = LayoutInflater.from(MyApp.instance).inflate(R.layout.homecategory, viewGroup,false);
            return new HomeCategoryHolder(inflate);

        } else if (i == VIPZX) {

            View inflate = LayoutInflater.from(MyApp.instance).inflate(R.layout.huiyuanzhuanxiang, viewGroup,false);
            return new VipHolder(inflate);

        }

        else if (i == ZHUANLAM) {

            View inflate = LayoutInflater.from(MyApp.instance).inflate(R.layout.zhuanlan, viewGroup,false);
            return new ZhuanLanHolder(inflate);

        } else if (i == TUIJIAN) {

            View inflate = LayoutInflater.from(MyApp.instance).inflate(R.layout.tuijian, viewGroup,false);
            return new TuiJianHolder(inflate);

        }else if (i == DASHIKE) {

            View inflate = LayoutInflater.from(MyApp.instance).inflate(R.layout.dashike, viewGroup,false);
            return new DaShiKeHolder(inflate);
        }


        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i)==BANNER){
            BannerViewHolder bannerViewHolder = (BannerViewHolder) viewHolder;
            bannerViewHolder.setData(bannerInfoBeanList);
        }else if (getItemViewType(i)==BIAOGE){

            HomeCategoryHolder channelViewHolder = (HomeCategoryHolder) viewHolder;
            channelViewHolder.setDate(homeCategoryBeanList);

        }else if (getItemViewType(i)==VIPZX){

            VipHolder actViewHolder = (VipHolder) viewHolder;
            actViewHolder.setDate(vipBeanList);
        }
        else if (getItemViewType(i)==ZHUANLAM){

            ZhuanLanHolder actViewHolder = (ZhuanLanHolder) viewHolder;
            actViewHolder.setDate(zhuanlanList);
        }
        else if (getItemViewType(i)== TUIJIAN){

            TuiJianHolder seckillViewHolder = (TuiJianHolder) viewHolder;
            seckillViewHolder.setDate(tuijianlist);

        }else if (getItemViewType(i) == DASHIKE){

             DaShiKeHolder daShiKeHolder = (DaShiKeHolder) viewHolder;
             daShiKeHolder.setDate(dashikeList);
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class DaShiKeHolder extends RecyclerView.ViewHolder {

        ListView channel;

        public DaShiKeHolder(@NonNull View itemView) {
            super(itemView);

            channel = itemView.findViewById(R.id.dashi_lv);
        }

        public void setDate(List<XuanKeDateBean.DataBean.MasterLivesBean> channelInfoBeans){
            DaShiKeAdp channelAdp = new DaShiKeAdp();
            channelAdp.updateData(channelInfoBeans);
            channel.setAdapter(channelAdp);

        }

    }


    class HomeCategoryHolder extends RecyclerView.ViewHolder {

        GridView channel;
        public HomeCategoryHolder(@NonNull View itemView) {
            super(itemView);
            channel = itemView.findViewById(R.id.category_gv);
        }

        public void setDate(List<XuanKeDateBean.DataBean.HomeCategoryBean> channelInfoBeans){

            HomeCategoryAdp channelAdp = new HomeCategoryAdp();
            channelAdp.updateData(channelInfoBeans);
            channel.setAdapter(channelAdp);
        }
    }


    class VipHolder extends RecyclerView.ViewHolder {

        GridView vipgv;

        public VipHolder(@NonNull View itemView) {
            super(itemView);

            vipgv = itemView.findViewById(R.id.vipzhuanxiang);
        }

        public void setDate(List<XuanKeDateBean.DataBean.VipRecommendBean> channelInfoBeans){

            VipShareAdp channelAdp = new VipShareAdp();
            channelAdp.updateData(channelInfoBeans);
            vipgv.setAdapter(channelAdp);

        }

    }







    class ZhuanLanHolder extends RecyclerView.ViewHolder {

        GridView zhuangv;
        public ZhuanLanHolder(@NonNull View itemView) {
            super(itemView);

            zhuangv = itemView.findViewById(R.id.zhuanlan_gv);
        }

        public void setDate(List<XuanKeDateBean.DataBean.ZlListBean> channelInfoBeans){

            ZhuanLanAdp channelAdp = new ZhuanLanAdp();
            channelAdp.updateData(channelInfoBeans);
            zhuangv.setAdapter(channelAdp);

        }

    }

    class TuiJianHolder extends RecyclerView.ViewHolder{

        RecyclerView recyclerView;
        public TuiJianHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recy_tuijian);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyApp.instance);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(linearLayoutManager);
        }

        public void setDate(List<XuanKeDateBean.DataBean.CourseRecommendsBean> channel){

            TuiJianAdp adp = new TuiJianAdp();
            adp.refreshData(channel);
            recyclerView.setAdapter(adp);

        }

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
