package com.example.player.a1610aplayerdemo.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.home.bean.HomeBean;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private HomeBean.DataBean homeBean;

    private static final int BANNNER = 0;
    private static final int CATEGORY = 1;
    private static final int VIPRECOMMEND = 2;
    private static final int ZLLIST = 3;
    private static final int COURSERECOMMENDS = 4;
    private static final int MASTERLIVES = 5;

    public int currentType = BANNNER;
    private LayoutInflater layoutInflater;

    public HomeAdapter(Context context,HomeBean.DataBean homeBean){
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.homeBean = homeBean;
    }


    @Override
    public int getItemViewType(int position) {
        switch (position){
            case BANNNER:
                currentType = BANNNER;
                break;
            case CATEGORY:
                currentType = CATEGORY;
                break;
            case VIPRECOMMEND:
                currentType = VIPRECOMMEND;
                break;
            case ZLLIST:
                currentType = ZLLIST;
                break;
            case COURSERECOMMENDS:
                currentType = COURSERECOMMENDS;
                break;
            case MASTERLIVES:
                currentType = MASTERLIVES;
                break;
        }
        return currentType;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == BANNNER){
            return new BannerViewHolder(layoutInflater.inflate(R.layout.item_banner,viewGroup,false),context,homeBean);
        }else if (i == CATEGORY){
            return new CategoryViewHolder(layoutInflater.inflate(R.layout.item_category,viewGroup,false),context);
        }else if (i == VIPRECOMMEND){
            return new VipRecommendViewHolder(layoutInflater.inflate(R.layout.item_viprecommend,viewGroup,false),context);
        }else if (i == ZLLIST){
            return new ZlListViewHolder(layoutInflater.inflate(R.layout.item_zllist,viewGroup,false),context);
        }else if (i == COURSERECOMMENDS){
            return new CourseRecommendsViewHolder(layoutInflater.inflate(R.layout.item_courserecommends,viewGroup,false),context);
        }else if (i == MASTERLIVES){
            return new MasterLivesViewHolder(layoutInflater.inflate(R.layout.item_masterlives,viewGroup,false),context);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == BANNNER){
            BannerViewHolder viewHolder1 = (BannerViewHolder) viewHolder;
            viewHolder1.setData(homeBean.getHomeBanner());
        }else if (getItemViewType(i) == CATEGORY){
            CategoryViewHolder viewHolder1 = (CategoryViewHolder) viewHolder;
            viewHolder1.setData(homeBean.getHomeCategory());
        }else if (getItemViewType(i) == VIPRECOMMEND){
            VipRecommendViewHolder viewHolder1 = (VipRecommendViewHolder) viewHolder;
            viewHolder1.setData(homeBean.getVipRecommend());
        }else if (getItemViewType(i) == ZLLIST){
            ZlListViewHolder viewHolder1 = (ZlListViewHolder) viewHolder;
            viewHolder1.setData(homeBean.getZlList());
        }else if (getItemViewType(i) == COURSERECOMMENDS){
            CourseRecommendsViewHolder viewHolder1 = (CourseRecommendsViewHolder) viewHolder;
            viewHolder1.setData(homeBean.getCourseRecommends());
        }else if (getItemViewType(i) == MASTERLIVES){
            MasterLivesViewHolder viewHolder1 = (MasterLivesViewHolder) viewHolder;
            viewHolder1.setData(homeBean.getMasterLives());
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class MasterLivesViewHolder extends RecyclerView.ViewHolder {
        private ListView listView;
        private Context context;

        public MasterLivesViewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            listView = itemView.findViewById(R.id.lv_masterlives);
            this.context = context;
        }

        public void setData(List<HomeBean.DataBean.MasterLivesBean> livesBeans){
            listView.setAdapter(new MasterLivesAdpater(context,livesBeans));
        }

    }

    class CourseRecommendsViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        private Context context;

        public CourseRecommendsViewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rv_courserecommends);
            this.context = context;
        }

        public void setData(List<HomeBean.DataBean.CourseRecommendsBean> list){
            LinearLayoutManager manager = new LinearLayoutManager(context);
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(manager);
            recyclerView.setAdapter(new CourseRecommendsAdapter(context,list));
        }

    }

    class ZlListViewHolder extends RecyclerView.ViewHolder {
        private GridView gridView;
        private Context context;

        public ZlListViewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            gridView = itemView.findViewById(R.id.gv_zllist);
            this.context = context;
        }

        public void setData(List<HomeBean.DataBean.ZlListBean> listBeans){
            gridView.setAdapter(new ZlListAdapter(context,listBeans));
        }

    }

    class VipRecommendViewHolder extends RecyclerView.ViewHolder {
        private GridView gridView;
        private Context context;

        public VipRecommendViewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            gridView = itemView.findViewById(R.id.gv_vip);
            this.context = context;
        }

        public void setData(List<HomeBean.DataBean.VipRecommendBean> list){
            gridView.setAdapter(new VipRecommendAdapter(context,list));
        }
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        public GridView gvCategory;
        public Context context;

        public CategoryViewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            gvCategory = itemView.findViewById(R.id.gv_category);
            this.context = context;
        }

        public void setData(List<HomeBean.DataBean.HomeCategoryBean> list){
            gvCategory.setAdapter(new CategoryAdapter(context,list));
        }

    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        public Banner banner;
        public Context context;

        public BannerViewHolder(@NonNull View itemView,Context context,HomeBean.DataBean dataBean) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
            this.context = context;
        }

        public void setData(List<HomeBean.DataBean.HomeBannerBean> list){
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            List<String> imageUrs = new ArrayList<>();
            for (int i = 0; i < list.size();i++){
                imageUrs.add(list.get(i).getBannerUrl());
            }
            banner.setBannerAnimation(Transformer.Default);
            banner.setImageLoader(new OnLoadUrl());
            banner.setDelayTime(3000);
            banner.setImages(imageUrs)
                    .start();
        }

        class OnLoadUrl extends ImageLoader{
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Picasso.with(context).load(path + "").into(imageView);
            }
        }

    }


}