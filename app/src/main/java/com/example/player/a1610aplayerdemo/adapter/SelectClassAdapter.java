package com.example.player.a1610aplayerdemo.adapter;

import android.content.Context;
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
import com.example.player.a1610aplayerdemo.fragment.BlankFragment01;
import com.example.player.a1610aplayerdemo.util.MyImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class SelectClassAdapter extends RecyclerView.Adapter {

   private HomeBean homeBean;
   private Context context;

   private int currentType=BANNER;
    //选择界面
    public static final int BANNER=0;
    public static final int CLASS=1;

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
        }

    }

    @Override
    public int getItemCount() {
        return 2;
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
            default:
                currentType=BANNER;
                break;
        }
        return currentType;
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
        private Context context;
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
