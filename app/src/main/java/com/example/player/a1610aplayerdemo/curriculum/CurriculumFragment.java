package com.example.player.a1610aplayerdemo.curriculum;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.curriculum.adapter.KindAdapter;
import com.example.player.a1610aplayerdemo.curriculum.adapter.VipAdapter;
import com.example.player.a1610aplayerdemo.curriculum.bean.Bean;
import com.example.player.a1610aplayerdemo.curriculum.presenter.CurriculumPresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurriculumFragment extends Fragment implements IBaseView, OnBannerListener, KindAdapter.onClickItemListener,VipAdapter.onClickItemListener{
    @BindView(R.id.curriculum_search)
    EditText curriculumSearch;
    @BindView(R.id.curriculum_banner)
    Banner curriculumBanner;
    Unbinder unbinder;
    @BindView(R.id.curriculum_category_rv)
    RecyclerView curriculumCategoryRv;
    @BindView(R.id.curriculum_vip_rv)
    RecyclerView curriculumVipRv;
    private IBasePresenter iBasePresenter;

    private List<Bean.DataBean.CourseRecommendsBean> courseRecommendsBeans;
    private List<Bean.DataBean.HomeBannerBean> homeBannerBeans;
    private List<Bean.DataBean.HomeCategoryBean> homeCategoryBeans;
    private List<Bean.DataBean.VipRecommendBean> vipRecommendBeans;

    private KindAdapter kindAdapter;
    private VipAdapter vipAdapter;

    public CurriculumFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iBasePresenter = new CurriculumPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_curriculum, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        iBasePresenter.attachView(this);
        iBasePresenter.getData();
        return view;
    }

    private void initView() {
        curriculumCategoryRv.setLayoutManager(new GridLayoutManager(getActivity(), 4, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        curriculumVipRv.setLayoutManager(new GridLayoutManager(getActivity(),2,LinearLayoutManager.VERTICAL,false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
    }


    @Override
    public void onLoadData(Object data) {
        courseRecommendsBeans = new ArrayList<>();
        homeBannerBeans = new ArrayList<>();
        homeCategoryBeans = new ArrayList<>();
        vipRecommendBeans = new ArrayList<>();

        Bean bean = (Bean) data;

        courseRecommendsBeans.addAll(bean.getData().getCourseRecommends());
        homeBannerBeans.addAll(bean.getData().getHomeBanner());
        homeCategoryBeans.addAll(bean.getData().getHomeCategory());
        vipRecommendBeans.addAll(bean.getData().getVipRecommend());

        initData();
    }

    private void initData() {
        List<String> list_paths = new ArrayList<>();

        for (int i = 0; i < homeBannerBeans.size(); i++) {
            list_paths.add(homeBannerBeans.get(i).getBannerUrl());
        }

        curriculumBanner.setImageLoader(new MyLoader())
                .setDelayTime(3000)
                .isAutoPlay(true)
                .setIndicatorGravity(BannerConfig.CENTER)
                .setImages(list_paths)
                .setOnBannerListener(this)
                .start();

        kindAdapter = new KindAdapter();
        kindAdapter.setListener(this);
        kindAdapter.refresh(homeCategoryBeans);
        curriculumCategoryRv.setAdapter(kindAdapter);
        kindAdapter.notifyDataSetChanged();

        vipAdapter = new VipAdapter();
        vipAdapter.setListener(this);
        vipAdapter.refresh(vipRecommendBeans);
        curriculumVipRv.setAdapter(vipAdapter);
        vipAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadError(int code, String message) {
        Log.i("tttt", "错误信息" + message);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        iBasePresenter.detachView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.curriculum_search)
    public void onViewClicked() {

    }

    @Override
    public void OnBannerClick(int position) {
        Toast.makeText(getActivity(), "" + homeBannerBeans.get(position).getTitle(), Toast.LENGTH_SHORT).show();
    }

    //选择的监听事件
    @Override
    public void onClickKind(int index) {
        Toast.makeText(getActivity(), "" + homeCategoryBeans.get(index).getTitle(), Toast.LENGTH_SHORT).show();
    }

    //Vip的点击事件
    @Override
    public void onClickVip(int index) {
        Toast.makeText(getActivity(), "" + vipRecommendBeans.get(index).getTitle(), Toast.LENGTH_SHORT).show();
    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(context.getApplicationContext()).load((String) path).into(imageView);
        }
    }
}
