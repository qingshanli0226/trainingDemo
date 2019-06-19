package com.example.player.a1610aplayerdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.common.HomeBean;
import com.example.player.a1610aplayerdemo.ui.Activity.VedioActivity;
import com.example.player.a1610aplayerdemo.ui.Activity.homeCategoryActivity;
import com.ocnyang.pagetransformerhelp.BannerItemBean;
import com.ocnyang.pagetransformerhelp.BannerViewPager;
import com.ocnyang.pagetransformerhelp.ImageLoaderInterface;
import com.ocnyang.pagetransformerhelp.transformer.DepthPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class Adapter_CourseRecyclerView extends RecyclerView.Adapter {
    private Context mContext;
    private HomeBean mHomeBean;
    public int currentType = BANNER;
    private LayoutInflater inflater;
    //Course页面Banner
    public static final int BANNER = 0;
    public static final int CLASSIFY = 1;
    public static final int SPECIAL = 2;
    public static final int RECOMMEND = 3;
    public static final int MASTER = 4;

    public Adapter_CourseRecyclerView(Context context, HomeBean homeBean) {
        mContext = context;
        mHomeBean = homeBean;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if(viewType == BANNER){
            return new BannerViewHolder(inflater.inflate(R.layout.course_layout_banner_vh,null),mContext);
        }else if(viewType == CLASSIFY){
            return new ClassifyViewHolder(inflater.inflate(R.layout.course_layout_classify_gv,null),mContext);
        }else if(viewType == SPECIAL){
            return new SpecialViewHolder(inflater.inflate(R.layout.course_layout_special_gv,null),mContext);
        }else if(viewType == RECOMMEND){
            return new RecommendViewHolder(inflater.inflate(R.layout.course_layout_recommend_rv,null),mContext);
        }else if(viewType == MASTER){
            return new MasterViewHolder(inflater.inflate(R.layout.course_layout_master_rv,null),mContext);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(getItemViewType(i) == BANNER){
            BannerViewHolder bannerViewHolder = (BannerViewHolder)viewHolder;
            bannerViewHolder.setData();
        }else if(getItemViewType(i) == CLASSIFY){
            ClassifyViewHolder classifyViewHolder = (ClassifyViewHolder)viewHolder;
            classifyViewHolder.setData();
        }else if(getItemViewType(i) == SPECIAL){
            SpecialViewHolder specialViewHolder = (SpecialViewHolder)viewHolder;
            specialViewHolder.setData();
        }else if(getItemViewType(i) == RECOMMEND){
            RecommendViewHolder recommendViewHolder = (RecommendViewHolder)viewHolder;
            recommendViewHolder.setData();
        }else if(getItemViewType(i) == MASTER){
            MasterViewHolder masterViewHolder = (MasterViewHolder)viewHolder;
            masterViewHolder.setData();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case BANNER:
                currentType = BANNER;
                break;
            case CLASSIFY:
                currentType = CLASSIFY;
                break;
            case SPECIAL:
                currentType = SPECIAL;
                break;
            case RECOMMEND:
                currentType = RECOMMEND;
                break;
            case MASTER:
                currentType = MASTER;
                break;
            default:
                currentType = BANNER;
                break;
        }
        return currentType;
    }
    //大师课ViewHolder
    private class MasterViewHolder extends RecyclerView.ViewHolder{
        private Context mContext;
        private RecyclerView mRecyclerView;
        public MasterViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            mContext = context;
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.masterRecyclerView);
        }
        public void setData(){
            LinearLayoutManager manager = new LinearLayoutManager(mContext);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(manager);
            Adapter_CourseMasterRecylerView adapter_courseMasterRecylerView = new Adapter_CourseMasterRecylerView(mContext, mHomeBean);
            adapter_courseMasterRecylerView.setClikItem(new Adapter_CourseMasterRecylerView.OnClikItem() {
                @Override
                public void OnClick(int i) {
                    //大师课点击事件
                    Toast.makeText(mContext, "==>"+i+"<==", Toast.LENGTH_SHORT).show();
                }
            });
            mRecyclerView.setAdapter(adapter_courseMasterRecylerView);
        }
    }
    //推荐ViewHolder
    private class RecommendViewHolder extends RecyclerView.ViewHolder{
        private Context mContext;
        private RecyclerView mRecyclerView;
        public RecommendViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            mContext = context;
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.recommendRecyclerView);
        }
        public void setData(){
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            mRecyclerView.setLayoutManager(linearLayoutManager);
            Adapter_CourseRecommendRecyclerView recommendRecyclerView = new Adapter_CourseRecommendRecyclerView(mHomeBean, mContext);
            recommendRecyclerView.setClickItem(new Adapter_CourseRecommendRecyclerView.onClickItem() {
                @Override
                public void onClick(int i) {
                    //推荐课程点击事件
                    HomeBean.DataBean.CourseRecommendsBean bean = mHomeBean.getData().getCourseRecommends().get(i);
                    String courseUrl = bean.getCourseUrl();
                    Intent intent = new Intent(mContext, VedioActivity.class);
                    intent.putExtra("vedioUrl",courseUrl);
                    mContext.startActivity(intent);
                }
            });
            mRecyclerView.setAdapter(recommendRecyclerView);
        }
    }
    //专栏ViewHolder
    private class SpecialViewHolder extends RecyclerView.ViewHolder{
        private Context mContext;
        private TextView mTextView;
        private GridView mGridView;
        public SpecialViewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            this.mContext = context;
            mTextView = itemView.findViewById(R.id.specialMoreBtn);
            mGridView = itemView.findViewById(R.id.specialPageGridView);


        }
        public void setData(){
            Adapter_CourseSpecialGridView adapter_courseSpecialGridView = new Adapter_CourseSpecialGridView(mContext, mHomeBean);
            mGridView.setAdapter(adapter_courseSpecialGridView);
            mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //专栏页面点击事件
                    Toast.makeText(mContext, ""+position, Toast.LENGTH_SHORT).show();
                }
            });
            mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //更多专栏加载按钮
                    Toast.makeText(mContext, "加载更多专栏", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    //课程选择页面的ViewHolder
    private class ClassifyViewHolder extends RecyclerView.ViewHolder{
        private Context mContext;
        private GridView mGridView;

        public ClassifyViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            mContext = context;
            mGridView = itemView.findViewById(R.id.coursePageRecyclerViewClassify);
        }
        public void setData(){
            Adapter_CourseGridView adapter_courseGridView = new Adapter_CourseGridView(mContext, mHomeBean);
            mGridView.setAdapter(adapter_courseGridView);
            mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //课程页面分类选择
                    Toast.makeText(mContext, "==>"+position+"<==", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, homeCategoryActivity.class);
                    intent.putExtra("position",position);
                    mContext.startActivity(intent);
                }
            });
        }
    }
    //课程选择页面的BannerViewHolder
    private class BannerViewHolder extends RecyclerView.ViewHolder{
        private Context mContext;
        private BannerViewPager mBannerViewPager;

        public BannerViewHolder(@NonNull View itemView,Context context) {
            super(itemView);
            this.mContext = context;
            mBannerViewPager = itemView.findViewById(R.id.coursePageRecyclerViewBanner);
        }
        public void setData(){
            mBannerViewPager.setData(getImages(),//设置数据
                    new ImageLoaderInterface() {//设置图片加载器
                        @Override
                        public void displayImage(Context context, Object imgPath, ImageView imageView) {
                            Glide.with(context).load(imgPath).into(imageView);
                        }
                    }).setPageTransformer(null)//设置切换效果
                    .setAutoPlay(true)//设置是否自动播放
                    .setOnBannerItemClickListener(new BannerViewPager.OnBannerItemClickListener() {//设置item的监听事件
                        @Override
                        public void OnClickLister(View view, int currentItem) {
                            //Banner跳转到对应视频页面
                            String relationInfo = mHomeBean.getData().getHomeBanner().get(currentItem).getRelationInfo();
                            Intent intent = new Intent(mContext, VedioActivity.class);
                            intent.putExtra("vedioUrl",relationInfo);
                            mContext.startActivity(intent);
                        }
                    })
                    .setHaveTitle(false);//设置是否显示标题
            mBannerViewPager.setPageTransformer(new DepthPageTransformer());
        }
        //获取Banner 图片
        private List<BannerItemBean> getImages() {
            List<BannerItemBean> pagerItemBeanList = new ArrayList<>();
            List<HomeBean.DataBean.HomeBannerBean> homeBanner = mHomeBean.getData().getHomeBanner();
            for (HomeBean.DataBean.HomeBannerBean bannerBean : homeBanner) {
                pagerItemBeanList.add(new BannerItemBean(bannerBean.getBannerUrl(),"数据"+bannerBean.getShowIndex()));
            }
            return pagerItemBeanList;
        }

    }
}
