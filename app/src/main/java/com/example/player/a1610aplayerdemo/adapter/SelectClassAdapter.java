package com.example.player.a1610aplayerdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.HomeBean;
import com.example.player.a1610aplayerdemo.twomenuActivity.activity.BannerActivity;
import com.example.player.a1610aplayerdemo.twomenuActivity.activity.BannerZeroActivity;
import com.example.player.a1610aplayerdemo.util.MyImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class SelectClassAdapter extends RecyclerView.Adapter {

   private HomeBean homeBean;
   private Context context;

   private int currentType=BANNER;
    //选择界面
    public static final int BANNER=0;
    public static final int CLASS=1;
    public static final int VIP=2;
    public static final int SPECIAL=3;

    public static final int RECOMMEND=4;
    public static final int TEACH=5;


    public SelectClassAdapter(HomeBean homeBean, Context context) {
        this.homeBean = homeBean;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == BANNER){
          return new BannerViewHolder(LayoutInflater.from(context).inflate(R.layout.homebanner_view,null));
        }else if (i == CLASS){
            return new ClassViewHolder(LayoutInflater.from(context).inflate(R.layout.homeclass_view,null),context);
        }else if (i == VIP){
            return new VipViewHolder(LayoutInflater.from(context).inflate(R.layout.homevip_view,null));
        }else if (i == SPECIAL){
            return new SpecialViewHolder(LayoutInflater.from(context).inflate(R.layout.homespecial_view,null));
        }else if (i == RECOMMEND){
            return  new RecommendViewHolder(LayoutInflater.from(context).inflate(R.layout.homerecomend_view,null));
        }else if (i == TEACH){
            return new TeachViewHolder(LayoutInflater.from(context).inflate(R.layout.homebigteach_view,null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == BANNER){
            BannerViewHolder bannerViewHolder= (BannerViewHolder) viewHolder;
            bannerViewHolder.setData();
        }else if (getItemViewType(i) == CLASS){
            ClassViewHolder classViewHolder= (ClassViewHolder) viewHolder;
            classViewHolder.getAdapter();
        }else if (getItemViewType(i) == VIP){
            VipViewHolder vipViewHolder= (VipViewHolder) viewHolder;
            vipViewHolder.getVipAdapter();

        }else if (getItemViewType(i) == SPECIAL){
            SpecialViewHolder specialViewHolder= (SpecialViewHolder) viewHolder;
            specialViewHolder.getAdapter();

        }else if (getItemViewType(i) == RECOMMEND){
            RecommendViewHolder recommendViewHolder= (RecommendViewHolder) viewHolder;
            recommendViewHolder.getAdapter();
        }else if (getItemViewType(i)==TEACH){
            TeachViewHolder teachViewHolder= (TeachViewHolder) viewHolder;
            teachViewHolder.getAdapter();

        }

    }

    @Override
    public int getItemCount() {
        return 6;
    }


    @Override
    public int getItemViewType(int position) {
        switch (position){
            case BANNER:
                currentType=BANNER;
                break;
            case CLASS:
                currentType=CLASS;
                break;
            case VIP:
                currentType=VIP;
                break;
            case SPECIAL:
                currentType=SPECIAL;
                break;
            case RECOMMEND:
                currentType=RECOMMEND;
                break;
            case TEACH:
                currentType=TEACH;
                break;
            default:
                currentType=BANNER;
                break;
        }
        return currentType;
    }

    //专栏专区
       private class SpecialViewHolder extends RecyclerView.ViewHolder{
          RecyclerView recyclerView;
        public SpecialViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.homeSpecial_RV);
        }
        public void getAdapter(){
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
            gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(gridLayoutManager);

            HomeSpecialAdapter homeSpecialAdapter = new HomeSpecialAdapter(homeBean, context);
            recyclerView.setAdapter(homeSpecialAdapter);

        }

    }



    //会员专享
    private class VipViewHolder extends RecyclerView.ViewHolder{
          RecyclerView recyclerView;
        public VipViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.homeVip_RV);
        }
        public void getVipAdapter(){
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
            gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(gridLayoutManager);

            HomeVipAdapter homeVipAdapter = new HomeVipAdapter(homeBean, context);
            recyclerView.setAdapter(homeVipAdapter);
        }
    }


    //大师课
    private class TeachViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView recyclerView;
        public TeachViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.homeTeach_RV);
        }
        public void getAdapter(){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager);

            HomeTeachAdpter homeTeachAdpter = new HomeTeachAdpter(homeBean, context);
            recyclerView.setAdapter(homeTeachAdpter);

        }

    }


    //推荐
    private class RecommendViewHolder extends RecyclerView.ViewHolder{
         private RecyclerView recyclerView;
        public RecommendViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.homeRecomend_RV);
        }

        public void getAdapter(){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(linearLayoutManager);
            HomeRecomendAdapter homeRecomendAdapter = new HomeRecomendAdapter(homeBean, context);
            recyclerView.setAdapter(homeRecomendAdapter);

        }

    }



    //分类
    private class ClassViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView class_Rv;

        public ClassViewHolder(@NonNull View itemView,Context context) {
            super(itemView);

            class_Rv = itemView.findViewById(R.id.homeClass_RV);

        }
        public void getAdapter(){
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4);
            gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            class_Rv.setLayoutManager(gridLayoutManager);

            HomeClassAdapter homeClassAdapter = new HomeClassAdapter(context, homeBean);
            class_Rv.setAdapter(homeClassAdapter);
        }

    }



    //选课Banner
    private class BannerViewHolder extends RecyclerView.ViewHolder{

        private Banner banner;

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.bannerHome);
        }
        public void setData(){
            banner.setImages(getImages())
                    .setImageLoader(new MyImageLoader())
                    .setDelayTime(3000)
                    .isAutoPlay(true)
                    .start();
            //跳转二级界面

            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    if (position==0){
                        Intent intent = new Intent(context, BannerZeroActivity.class);
                        context.startActivity(intent);
                    }else{
                        String relationInfo = homeBean.getData().getHomeBanner().get(position).getRelationInfo();
                        Intent intent = new Intent(context, BannerActivity.class);
                        intent.putExtra("relation",relationInfo);
                        context.startActivity(intent);
                    }
                }
            });

        }

        private List<String> getImages(){
            List<String> imageList=new ArrayList<>();
            String code = homeBean.getCode();
            Log.d("bbbanner",""+code);
            List<HomeBean.DataBean.HomeBannerBean> homeBanner = homeBean.getData().getHomeBanner();
            for (HomeBean.DataBean.HomeBannerBean bannerBean:homeBanner ){
                imageList.add(bannerBean.getBannerUrl());
            }
            return imageList;
        }
    }
}
