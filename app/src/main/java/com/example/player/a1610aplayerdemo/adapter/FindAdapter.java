package com.example.player.a1610aplayerdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.HomeBean;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lmz on 2019/06/11
 */
public class FindAdapter extends RecyclerView.Adapter{

    // 设置类型
    public static final int BANNER =0;
    public static final int CATEGORY=1;
    public static final int VIP=2;
    public static final int  SPECIALLY =3;
    public static final int RECOMMEND=4;
    public static final int LIST=5;

    //设置当前类型 默认为0
    private int currType=0;
    private Context context;
    private HomeBean bean;
    //初始化布局用
    private LayoutInflater inflater;

    public FindAdapter(@Nullable Context context, @Nullable HomeBean bean) {
         this.context =context;
         this.bean =bean;
         inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case BANNER:currType=BANNER;break;
            case CATEGORY: currType =CATEGORY; break;
            case VIP:currType =VIP;break;
            case SPECIALLY:currType =SPECIALLY;break;
            case RECOMMEND:currType = RECOMMEND ;break;
            case LIST:currType=LIST;break;
        }
        return currType;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i){
            case BANNER: return new BannerViewhoder(inflater.inflate(R.layout.item_banner_find,viewGroup,false));
            case CATEGORY: return new CategoytViewhoder(inflater.inflate(R.layout.item_category_find,viewGroup,false));
            case VIP:return new VipViewhoder(inflater.inflate(R.layout.item_vip_find,viewGroup,false));
         /*

            case SPECIALLY:currType =SPECIALLY;break;
            case RECOMMEND:currType = RECOMMEND ;break;
            case LIST:currType=LIST;break;*/
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        HomeBean.DataBean data = bean.getData();
        switch (getItemViewType(i)) {
            case BANNER:
                BannerViewhoder vh = (BannerViewhoder) viewHolder;
                vh.setData(data.getHomeBanner());
                break;
            case CATEGORY:
                CategoytViewhoder cate = (CategoytViewhoder) viewHolder;
                cate.setData(data.getHomeCategory());
                break;
            case VIP:
                VipViewhoder vip = (VipViewhoder) viewHolder;
                vip.setData(data.getVipRecommend());

                break;
            /*

            case SPECIALLY:currType =SPECIALLY;break;
            case RECOMMEND:currType = RECOMMEND ;break;
            case LIST:currType=LIST;break;*/
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    //设置banner viewhoder
    class BannerViewhoder extends RecyclerView.ViewHolder{
        Banner banner;
        private List<HomeBean.DataBean.HomeBannerBean> data;

        public BannerViewhoder(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.find_item_banner);
        }

        public void setData(List<HomeBean.DataBean.HomeBannerBean> data) {
            this.data = data;
            // 存放图片路径
            List<String> imglist =new ArrayList<>();
            for (int i=0;i<data.size();i++){
                imglist.add(data.get(i).getBannerUrl());
            }
            banner.setImages(imglist)
                            .setImageLoader(new ImageLoader() {
                                @Override
                                public void displayImage(Context context, Object path, ImageView imageView) {
                                    Glide.with(context).load(path)
                                            .fitCenter()
                                            .into(imageView);
                                }
                            })
                            .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                            .isAutoPlay(true)
                            .setDelayTime(2500)
                            .start();
        }
    }
    //设置 CATEGORY 分类
    class CategoytViewhoder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        Category_Adapter adapter;
        private List<HomeBean.DataBean.HomeCategoryBean> data;

        public CategoytViewhoder(@NonNull View itemView) {
            super(itemView);
            recyclerView =itemView.findViewById(R.id.find_item_categoty_recyclerview);
            GridLayoutManager manager =new GridLayoutManager(context,4);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(manager);
        }

        public void setData(List<HomeBean.DataBean.HomeCategoryBean> data) {
            this.data = data;
            adapter =new Category_Adapter(data,context);
            recyclerView.setAdapter(adapter);
        }
    }
    //设置 VIP
    class VipViewhoder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        private List<HomeBean.DataBean.VipRecommendBean> data;
        private Vip_Adapter adapter;
        public VipViewhoder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.item_vip_recycler);
            GridLayoutManager manager =new GridLayoutManager(context,2);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(manager);
        }

        public void setData(List<HomeBean.DataBean.VipRecommendBean> data) {
            this.data = data;
            adapter = new Vip_Adapter(data,context);
            recyclerView.setAdapter(adapter);

        }
    }
}
