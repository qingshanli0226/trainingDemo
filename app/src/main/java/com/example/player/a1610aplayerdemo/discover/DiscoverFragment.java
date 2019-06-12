package com.example.player.a1610aplayerdemo.discover;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.discover.adapter.*;
import com.example.player.a1610aplayerdemo.discover.bean.DiscoverBean;
import com.example.player.a1610aplayerdemo.discover.presenter.DisPresenter;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class DiscoverFragment extends Fragment implements IBaseView, OnBannerListener, RecommendAdapter.onItemRecommendClickListener, OptionAdapter.onItemOptionClickListener, MemberAdapter.onItemMemberClickListener, CourseAdapter.onItemCourseClickListener, SpecialAdapter.onItemSpecialClickListener {
    private IBasePresenter iBasePresenter;
    private Banner discover_banner;
    private OptionAdapter optionadapter = new OptionAdapter(getContext());
    private MemberAdapter memberAdapter = new MemberAdapter();
    private SpecialAdapter specialAdapter = new SpecialAdapter();
    private RecommendAdapter recommendAdapter = new RecommendAdapter();
    private CourseAdapter courseAdapter = new CourseAdapter();
    private List<DiscoverBean.HomeBannerBean> list0 = new ArrayList<>();
    private List<DiscoverBean.HomeCategoryBean> list1 = new ArrayList<>();
    private List<DiscoverBean.VipRecommendBean> list2 = new ArrayList<>();
    private List<DiscoverBean.ZlListBean> list3 = new ArrayList<>();
    private List<DiscoverBean.CourseRecommendsBean> list4 = new ArrayList<>();
    private List<DiscoverBean.MasterLivesBean> list5 = new ArrayList<>();
    private RecyclerView discover_option_recyc;
    private RecyclerView discover_member_recyc;
    private RecyclerView discover_special_recyc;
    private RecyclerView discover_recommend_recyc;
    private RecyclerView discover_course_recyc;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iBasePresenter = new DisPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        initView(view);
        iBasePresenter.attachView(this);
        iBasePresenter.getData();
        return view;
    }

    private void banner() {
        List<String> list = new ArrayList<>();
        for (DiscoverBean.HomeBannerBean bannerBean : list0) {
            list.add(bannerBean.getBannerUrl());
        }
        MyBannerLoder loder = new MyBannerLoder();
        discover_banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        discover_banner.setImageLoader(loder);
        discover_banner.setDelayTime(3000);
        discover_banner.isAutoPlay(true);
        discover_banner.setIndicatorGravity(BannerConfig.CENTER);
        discover_banner.setImages(list)
                .setOnBannerListener(this)
                .start();
    }

    private void initView(View view) {
        discover_banner = (Banner) view.findViewById(R.id.discover_banner);
        discover_option_recyc = (RecyclerView) view.findViewById(R.id.discover_option_recyc);
        discover_member_recyc = (RecyclerView) view.findViewById(R.id.discover_member_recyc);
        discover_special_recyc = (RecyclerView) view.findViewById(R.id.discover_special_recyc);
        discover_recommend_recyc = (RecyclerView) view.findViewById(R.id.discover_recommend_recyc);
        discover_course_recyc = (RecyclerView) view.findViewById(R.id.discover_course_recyc);

        courseAdapter.setListener(this);
        memberAdapter.setListener(this);
        optionadapter.setListener(this);
        recommendAdapter.setListener(this);
        specialAdapter.setListener(this);

    }

    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(getContext(), "你点击了" + list1.get(position).getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadData(Object data) {
        DiscoverBean bean = (DiscoverBean) data;
        list0 = bean.getHomeBanner();
        list1 = bean.getHomeCategory();
        list2 = bean.getVipRecommend();
        list3 = bean.getZlList();
        list4 = bean.getCourseRecommends();
        list5 = bean.getMasterLives();
        banner();
        option();
        member();
        special();
        recommend();
        course();
    }

    private void course() {
        LinearLayoutManager manager=new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        courseAdapter.setList(list5);
        discover_course_recyc.setLayoutManager(manager);
        discover_course_recyc.setAdapter(courseAdapter);
    }

    private void recommend() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recommendAdapter.setList(list4);
        discover_recommend_recyc.setLayoutManager(manager);
        discover_recommend_recyc.setAdapter(recommendAdapter);
    }

    private void member() {
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setOrientation(GridLayoutManager.VERTICAL);
        memberAdapter.setList(list2);
        discover_member_recyc.setLayoutManager(manager);
        discover_member_recyc.setAdapter(memberAdapter);
    }

    private void special() {
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setOrientation(GridLayoutManager.VERTICAL);
        specialAdapter.setList(list3);
        discover_special_recyc.setLayoutManager(manager);
        discover_special_recyc.setAdapter(specialAdapter);
    }

    private void option() {
        GridLayoutManager manager = new GridLayoutManager(getContext(), 4) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        manager.setOrientation(GridLayoutManager.VERTICAL);
        optionadapter.setList(list1);
        discover_option_recyc.setLayoutManager(manager);
        discover_option_recyc.setAdapter(optionadapter);
    }

    @Override
    public void onLoadError(String message) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        iBasePresenter.detachView();
    }

    @Override
    public void onItemCourse(DiscoverBean.MasterLivesBean bean, int index) {
        Toast.makeText(getContext(), ""+bean.getAppTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemMember(DiscoverBean.VipRecommendBean bean, int index) {
        Toast.makeText(getContext(), ""+bean.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemOption(DiscoverBean.HomeCategoryBean bean, int index) {
        Toast.makeText(getContext(), ""+bean.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemRecommend(DiscoverBean.CourseRecommendsBean bean, int index) {
        Toast.makeText(getContext(), ""+bean.getAppTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSpecial(DiscoverBean.ZlListBean bean, int index) {
        Toast.makeText(getContext(), ""+bean.getTitle(), Toast.LENGTH_SHORT).show();
    }

    private class MyBannerLoder extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Picasso.get().load(path + "").into(imageView);
        }
    }
}
