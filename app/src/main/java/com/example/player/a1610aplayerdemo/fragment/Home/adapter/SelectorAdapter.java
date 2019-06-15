package com.example.player.a1610aplayerdemo.fragment.Home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.player.a1610aplayerdemo.MyApp;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.fragment.Home.bean.SelectorBean;
import com.example.player.a1610aplayerdemo.fragment.MusicClass.present.MusciClassActivity;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class SelectorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<SelectorBean.HomeBannerBean> bannerBeans=new ArrayList<>();
    List<SelectorBean.HomeCategoryBean> homeCategoryBeans=new ArrayList<>();
    List<SelectorBean.ZlListBean> zlListBeans=new ArrayList<>();
    List<SelectorBean.VipRecommendBean> vipRecommendBeans=new ArrayList<>();
    List<SelectorBean.CourseRecommendsBean> courseRecommendsBeans=new ArrayList<>();
    List<SelectorBean.MasterLivesBean> masterLivesBeans=new ArrayList<>();
    public static final int BANNER=0;
    public static final int BIAOGE=1;
    public static final int VIP=2;
    public static final int ZHUANLAN=3;
    public static final int TUIJIAN=4;
    public static final int DASHIKE=5;
    public int currentType =BANNER;

    public Context context;

    public void addBannerData(List<SelectorBean.HomeBannerBean> list){
        bannerBeans.clear();
        bannerBeans.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case BANNER:
                currentType=BANNER;
                break;
            case BIAOGE:
                currentType=BIAOGE;
                break;
            case VIP:
                currentType=VIP;
                break;
            case ZHUANLAN:
                currentType = ZHUANLAN;
                break;
            case TUIJIAN:
                currentType = TUIJIAN;
                break;
            case DASHIKE:
                currentType = DASHIKE;
                break;
                default:break;
        }
        return currentType;
    }

    public void addBean(List<SelectorBean.HomeCategoryBean> bannerInfoBeanList1){
        homeCategoryBeans.clear();
        homeCategoryBeans.addAll(bannerInfoBeanList1);
        notifyDataSetChanged();
    }
    public void addVip(List<SelectorBean.VipRecommendBean> list){
        vipRecommendBeans.clear();
        vipRecommendBeans.addAll(list);
        notifyDataSetChanged();
    }
    public void addZhuanLan( List<SelectorBean.ZlListBean> bannerInfoBeanList1){
        zlListBeans.clear();
        zlListBeans.addAll(bannerInfoBeanList1);
        notifyDataSetChanged();
    }
    public void addTuiJian( List<SelectorBean.CourseRecommendsBean> bannerInfoBeanList1){
        courseRecommendsBeans.clear();
        courseRecommendsBeans.addAll(bannerInfoBeanList1);
        notifyDataSetChanged();
    }

    public void addDaShi( List<SelectorBean.MasterLivesBean> bannerInfoBeanList1){
        masterLivesBeans.clear();
        masterLivesBeans.addAll(bannerInfoBeanList1);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context=viewGroup.getContext();
        if (i==BANNER){
            View view= LayoutInflater.from(MyApp.instance).inflate(R.layout.banner_bn,viewGroup,false);
            return new BannerViewHolder(view);
        } else if (i == BIAOGE) {
            View view=LayoutInflater.from(MyApp.instance).inflate(R.layout.homecategory,viewGroup,false);
            return new BiaogeViewHolder(view);
        } else if (i == ZHUANLAN) {
            View view=LayoutInflater.from(MyApp.instance).inflate(R.layout.zhuanlan_item,viewGroup,false);
            return new ZhuanLanViewHolder(view);
        }
        else if (i == TUIJIAN) {
            View view=LayoutInflater.from(MyApp.instance).inflate(R.layout.tuijian,viewGroup,false);
            return new TuijianViewHolder(view);
        } else if (i == DASHIKE) {
            View view=LayoutInflater.from(MyApp.instance).inflate(R.layout.dashike,viewGroup,false);
            return new DashikeViewHolder(view);
        } else if (i == VIP) {
            View view=LayoutInflater.from(MyApp.instance).inflate(R.layout.vip,viewGroup,false);
            return new VipViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == BANNER) {
            BannerViewHolder bannerViewHolder= (BannerViewHolder) viewHolder;
            bannerViewHolder.setData(bannerBeans);
        } else if (getItemViewType(i) == BIAOGE) {
            BiaogeViewHolder biaogeViewHolder= (BiaogeViewHolder) viewHolder;
            biaogeViewHolder.setData(homeCategoryBeans);
        } else if (getItemViewType(i) == ZHUANLAN) {
            ZhuanLanViewHolder zhuanLanViewHolder= (ZhuanLanViewHolder) viewHolder;
            zhuanLanViewHolder.setData(zlListBeans);
        } else if (getItemViewType(i) == TUIJIAN) {
            TuijianViewHolder tuijianViewHolder= (TuijianViewHolder) viewHolder;
            tuijianViewHolder.setData(courseRecommendsBeans);
        } else if (getItemViewType(i) == DASHIKE) {
            DashikeViewHolder dashikeViewHolder= (DashikeViewHolder) viewHolder;
            dashikeViewHolder.setData(masterLivesBeans);
        }else if (getItemViewType(i) == VIP) {
            VipViewHolder vipViewHolder= (VipViewHolder) viewHolder;
            vipViewHolder.setData(vipRecommendBeans);
        }

    }


    @Override
    public int getItemCount() {

        return 7;

    }
    class DashikeViewHolder extends RecyclerView.ViewHolder{
        ListView l;

        public DashikeViewHolder(@NonNull View itemView) {
            super(itemView);
            l=itemView.findViewById(R.id.dashi_lv);
        }
        public void setData(List<SelectorBean.MasterLivesBean> livesBeans){
            DashikeAdapter dashikeAdapter=new DashikeAdapter();
            l.setAdapter(dashikeAdapter);
            dashikeAdapter.refresh(livesBeans);
        }
    }

    class TuijianViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;

        public TuijianViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.recy_tuijian);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MyApp.instance);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(linearLayoutManager);
        }

        public void setData(List<SelectorBean.CourseRecommendsBean> list){
            TuijianAdapter tuijianAdapter=new TuijianAdapter();
            recyclerView.setAdapter(tuijianAdapter);
            tuijianAdapter.refresh(list);
        }
    }
    class ZhuanLanViewHolder extends RecyclerView.ViewHolder{

        GridView zhuanv;
        public ZhuanLanViewHolder(@NonNull View itemView) {
            super(itemView);
            zhuanv=itemView.findViewById(R.id.zhuanlan_gv);
        }

        public void setData(List<SelectorBean.ZlListBean> listBeans){
            ZhuanLanAdapter zhuanLanAdapter=new ZhuanLanAdapter();
            zhuanv.setAdapter(zhuanLanAdapter);
            zhuanLanAdapter.refresh(listBeans);
        }
    }
    class BiaogeViewHolder extends RecyclerView.ViewHolder{
        GridView channel;
        public BiaogeViewHolder(@NonNull View itemView) {
            super(itemView);
            channel=itemView.findViewById(R.id.rv_biaoge);
            channel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) {
                        Intent intent=new Intent();
                        intent.setClass(context, MusciClassActivity.class);
                        context.startActivity(intent);
                    }
                }
            });
        }
        public void setData(List<SelectorBean.HomeCategoryBean> homeCategoryBeans){
            HomeCateAdapter homeCateAdapter=new HomeCateAdapter();
            channel.setAdapter(homeCateAdapter);
            homeCateAdapter.refresh(homeCategoryBeans);
        }
    }

    class BannerViewHolder extends RecyclerView.ViewHolder{
        Banner banner;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            banner=itemView.findViewById(R.id.banner);
        }
        public void setData(List<SelectorBean.HomeBannerBean> list){
            List<String> strings=new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                strings.add(list.get(i).getBannerUrl());

            }
            banner.setBannerAnimation(Transformer.Accordion);
            banner.setImages(strings);
            banner.setImageLoader(new MyImageLoad());
            banner.start();
        }
        class MyImageLoad extends ImageLoader{

            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Picasso.with(context)
                        .load((String) path)
                        .into(imageView);
            }
        }
    }

     class VipViewHolder extends RecyclerView.ViewHolder {
        GridView gridView;
        public VipViewHolder(@NonNull View itemView) {
            super(itemView);
            gridView=itemView.findViewById(R.id.vip_gv);
        }

         public void setData(List<SelectorBean.VipRecommendBean> vipRecommendBeans) {
            VipAdapter vipAdapter=new VipAdapter();
            gridView.setAdapter(vipAdapter);
            vipAdapter.refresh(vipRecommendBeans);
         }
     }
}
