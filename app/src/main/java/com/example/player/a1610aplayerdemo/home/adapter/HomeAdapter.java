package com.example.player.a1610aplayerdemo.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
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
    private static final int ACT = 2;
    private static final int SECKILL = 3;
    private static final int RECOMMEND = 4;
    private static final int HOT = 5;

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
            case ACT:
                currentType = ACT;
                break;
            case SECKILL:
                currentType = SECKILL;
                break;
            case RECOMMEND:
                currentType = RECOMMEND;
                break;
            case HOT:
                currentType = HOT;
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
        }
    }

    @Override
    public int getItemCount() {
        return 2;
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
        private HomeBean.DataBean dataBean;

        public BannerViewHolder(@NonNull View itemView,Context context,HomeBean.DataBean dataBean) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
            this.context = context;
            this.dataBean = dataBean;
        }

        public void setData(List<HomeBean.DataBean.HomeBannerBean> list){
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            List<String> imageUrs = new ArrayList<>();
            for (int i = 0; i < list.size();i++){
                imageUrs.add(list.get(i).getBannerUrl());
            }
            banner.setBannerAnimation(Transformer.Default);
            banner.setImageLoader(new OnLoadUrl());
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