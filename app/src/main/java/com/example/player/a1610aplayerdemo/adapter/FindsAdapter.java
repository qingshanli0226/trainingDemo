package com.example.player.a1610aplayerdemo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.player.a1610aplayerdemo.bean.HomeBean;
import com.example.player.a1610aplayerdemo.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class FindsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    HomeBean.DataBean dataBean;
    Context context;

    public void  refresh(HomeBean.DataBean dataBean){
        this.dataBean = dataBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        RecyclerView.ViewHolder viewHolder = null;
        if ( i==1){
            View view = LayoutInflater.from(context).inflate(R.layout.find_banner, viewGroup,false);
            viewHolder = new BannnerViewHolder(view);
        }else if (i==2){
            View view = LayoutInflater.from(context).inflate(R.layout.find_category2, viewGroup,false);
            viewHolder = new CategoryViewHolder(view);
        }else if (i==3){
            View view = LayoutInflater.from(context).inflate(R.layout.find_viprecommend3, viewGroup,false);
            viewHolder = new VipViewHolder(view);
        } else if (i==4){
            View view = LayoutInflater.from(context).inflate(R.layout.find_zlist4, viewGroup,false);
            viewHolder = new ZListViewHolder(view);
        }else if (i==5){
            View view = LayoutInflater.from(context).inflate(R.layout.find_course5, viewGroup,false);
            viewHolder = new CourseViewHolder(view);
        }else if (i==6){
            View view = LayoutInflater.from(context).inflate(R.layout.find_master6, viewGroup,false);
            viewHolder = new MasterViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof BannnerViewHolder){
            BannnerViewHolder bannnerViewHolder = (BannnerViewHolder) viewHolder;
            List<String> imgs = new ArrayList<>();
            for (int j =0;j<dataBean.getHomeBanner().size();j++){
                imgs.add(dataBean.getHomeBanner().get(j).getBannerUrl());
            }
            bannnerViewHolder.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            bannnerViewHolder.banner.setImageLoader(new MyImageLoader());
            bannnerViewHolder.banner.setImages(imgs);
            bannnerViewHolder.banner.setIndicatorGravity(BannerConfig.CENTER);
            bannnerViewHolder.banner.setDelayTime(3000);
            bannnerViewHolder.banner.start();
        }else if (viewHolder instanceof CategoryViewHolder){
            CategoryViewHolder categoryViewHolder = (CategoryViewHolder) viewHolder;
            GridLayoutManager manager = new GridLayoutManager(context,4);
            categoryViewHolder.recyclerView.setLayoutManager(manager);
            FindCategoryAdapter adapter = new FindCategoryAdapter();
            adapter.refresh(dataBean.getHomeCategory());
            categoryViewHolder.recyclerView.setAdapter(adapter);
        }else if (viewHolder instanceof VipViewHolder){
            VipViewHolder vipViewHolder = (VipViewHolder) viewHolder;
            GridLayoutManager manager = new GridLayoutManager(context,2);
            vipViewHolder.recyclerView.setLayoutManager(manager);
            FindVipAdapter adapter = new FindVipAdapter();
            adapter.refresh(dataBean.getVipRecommend());
            vipViewHolder.recyclerView.setAdapter(adapter);
        }else if (viewHolder instanceof ZListViewHolder){
            ZListViewHolder zListViewHolder = (ZListViewHolder) viewHolder;
            GridLayoutManager manager = new GridLayoutManager(context,2);
            zListViewHolder.recyclerView.setLayoutManager(manager);
            FindZListAdapter adapter = new FindZListAdapter();
            adapter.refresh(dataBean.getZlList());
            zListViewHolder.recyclerView.setAdapter(adapter);
        }else if (viewHolder instanceof CourseViewHolder){
            CourseViewHolder courseViewHolder = (CourseViewHolder) viewHolder;
            LinearLayoutManager manager = new LinearLayoutManager(context);
            manager.setOrientation(LinearLayoutManager.HORIZONTAL);
            courseViewHolder.recyclerView.setLayoutManager(manager);
            FindCourseAdapter adapter = new FindCourseAdapter();
            adapter.refresh(dataBean.getCourseRecommends());
            courseViewHolder.recyclerView.setAdapter(adapter);
        }else if (viewHolder instanceof MasterViewHolder){
            MasterViewHolder masterViewHolder = (MasterViewHolder) viewHolder;
            LinearLayoutManager manager = new LinearLayoutManager(context);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            masterViewHolder.recyclerView.setLayoutManager(manager);
            FindMasterAdapter adapter = new FindMasterAdapter();
            adapter.refresh(dataBean.getMasterLives());
            masterViewHolder.recyclerView.setAdapter(adapter);
        }
    }

    private class MyImageLoader extends ImageLoader {
        @Override
        public void displayImage(final Context context, Object path, final ImageView imageView) {
            Glide.with(context)
                    .load(path)
                    .asBitmap()
                    .into(new BitmapImageViewTarget(imageView){
                        @Override
                        protected void setResource(Bitmap resource) {
                            super.setResource(resource);
                            RoundedBitmapDrawable circularBitmapDrawable =
                                    RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                            circularBitmapDrawable.setCornerRadius(15);
                            imageView.setImageDrawable(circularBitmapDrawable);
                        }
                    });
        }
    }

    @Override
    public int getItemCount() {

        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return  1;
        }else if (position==1){
            return  2;
        }else if (position==2){
            return 3;
        }else if (position==3){
            return 4;
        }else if (position==4){
            return 5;
        }else {
            return 6;
        }

    }

    public class BannnerViewHolder extends RecyclerView.ViewHolder {
        private Banner banner;


        public BannnerViewHolder(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.item2recyc);

        }
    }

    public class ZListViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;

        public ZListViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.item3recyc);

        }
    }

    public class VipViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;

        public VipViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.item4recyc);

        }
    }

    public class CourseViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.item5recyc);

        }
    }

    public class MasterViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;

        public MasterViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.item6recyc);

        }
    }


}
