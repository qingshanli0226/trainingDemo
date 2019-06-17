package com.example.player.a1610aplayerdemo.curriculum;


import android.content.Context;
import android.content.SharedPreferences;
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
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.curriculum.adapter.*;
import com.example.player.a1610aplayerdemo.curriculum.bean.Bean;
import com.example.player.a1610aplayerdemo.curriculum.fragment.BannerFragment;
import com.example.player.a1610aplayerdemo.curriculum.presenter.CurriculumPresenter;
import com.example.player.a1610aplayerdemo.my.fragment.FeedbackFragment;
import com.scwang.smartrefresh.header.BezierCircleHeader;
import com.scwang.smartrefresh.header.WaterDropHeader;
import com.scwang.smartrefresh.header.WaveSwipeHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurriculumFragment extends Fragment implements IBaseView, OnBannerListener, KindAdapter.onClickItemListener, VipAdapter.onClickItemListener, ZlAdapter.onClickItemListener, CourseRecommendsAdapter.onClickItemListener, MasterAdapter.onClickItemListener {
    @BindView(R.id.curriculum_search)
    EditText curriculumSearch;
    @BindView(R.id.curriculum_banner)
    Banner curriculumBanner;
    Unbinder unbinder;
    @BindView(R.id.curriculum_category_rv)
    RecyclerView curriculumCategoryRv;
    @BindView(R.id.curriculum_vip_rv)
    RecyclerView curriculumVipRv;
    @BindView(R.id.curriculum_zl_rv)
    RecyclerView curriculumZlRv;
    @BindView(R.id.curriculum_courseRecommends_rv)
    RecyclerView curriculumCourseRecommendsRv;
    @BindView(R.id.vip_more_tv)
    TextView vipMoreTv;
    @BindView(R.id.curriculum_register_tv)
    TextView curriculumRegisterTv;
    @BindView(R.id.zl_more_tv)
    TextView zlMoreTv;
    @BindView(R.id.curriculum_master_rv)
    RecyclerView curriculumMasterRv;
    @BindView(R.id.curriculum_srl)
    SmartRefreshLayout curriculumSrl;
    private IBasePresenter iBasePresenter;

    private List<Bean.CourseRecommendsBean> courseRecommendsBeans;
    private List<Bean.HomeBannerBean> homeBannerBeans;
    private List<Bean.HomeCategoryBean> homeCategoryBeans;
    private List<Bean.VipRecommendBean> vipRecommendBeans;
    private List<Bean.ZlListBean> zlListBeans;
    private List<Bean.MasterLivesBean> masterLivesBeans;

    private KindAdapter kindAdapter;
    private VipAdapter vipAdapter;
    private ZlAdapter zlAdapter;
    private CourseRecommendsAdapter courseRecommendsAdapter;
    private MasterAdapter masterAdapter;
    private SharedPreferences spBannner;

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

        curriculumVipRv.setLayoutManager(new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        curriculumZlRv.setLayoutManager(new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        curriculumCourseRecommendsRv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        curriculumMasterRv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        curriculumSrl.setRefreshHeader(new WaterDropHeader(getActivity()));

        curriculumSrl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                iBasePresenter.getData();
                refreshlayout.finishRefresh();
            }
        });
    }


    @Override
    public void onLoadData(Object data) {
        courseRecommendsBeans = new ArrayList<>();
        homeBannerBeans = new ArrayList<>();
        homeCategoryBeans = new ArrayList<>();
        vipRecommendBeans = new ArrayList<>();
        zlListBeans = new ArrayList<>();
        masterLivesBeans = new ArrayList<>();

        Bean bean = (Bean) data;

        courseRecommendsBeans.addAll(bean.getCourseRecommends());
        homeBannerBeans.addAll(bean.getHomeBanner());
        homeCategoryBeans.addAll(bean.getHomeCategory());
        vipRecommendBeans.addAll(bean.getVipRecommend());
        zlListBeans.addAll(bean.getZlList());
        masterLivesBeans.addAll(bean.getMasterLives());

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

        zlAdapter = new ZlAdapter();
        zlAdapter.setListener(this);
        zlAdapter.refresh(zlListBeans);
        curriculumZlRv.setAdapter(zlAdapter);
        zlAdapter.notifyDataSetChanged();

        courseRecommendsAdapter = new CourseRecommendsAdapter();
        courseRecommendsAdapter.setListener(this);
        courseRecommendsAdapter.refresh(courseRecommendsBeans);
        curriculumCourseRecommendsRv.setAdapter(courseRecommendsAdapter);
        courseRecommendsAdapter.notifyDataSetChanged();

        masterAdapter = new MasterAdapter();
        masterAdapter.setListener(this);
        masterAdapter.refresh(masterLivesBeans);
        curriculumMasterRv.setAdapter(masterAdapter);
        masterAdapter.notifyDataSetChanged();
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

//    "title" : "钢琴即兴伴奏",
//            "bannerUrl" : "http://ali-files.yooshow.com/2019/03/20/eb32525c-4e19-47e6-be9b-d5007a48b823.png",
//            "bannerType" : 2,
//            "relationInfo" : "31",
//            "moduletype" : 0,
//            "showIndex" : 1,
//            "courseType" : 1,
//            "liveStatus" : 0,
//            "liveIsBuy" : false


    //轮播图的点击事件
    @Override
    public void OnBannerClick(int position) {
        if(homeBannerBeans.get(position).getCourseType() == 1){
            spBannner = getActivity().getSharedPreferences("spBanner",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = spBannner.edit();
            editor.putString("courseId",homeBannerBeans.get(position).getRelationInfo());
            editor.commit();
            RadioGroup radioGroup = getActivity().findViewById(R.id.home_radioG);
            radioGroup.setVisibility(View.GONE);
            getFragmentManager()
                    .beginTransaction()
                    .addToBackStack(null)  //将当前fragment加入到返回栈中
                    .replace(R.id.home_frame,new BannerFragment())
                    .commit();
        }else{
            WebView webView = new WebView(getActivity());
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("http://api.immedc.com/restapi/apph5/viphy?pkgid=16");
        }
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

    @Override
    public void onClickZl(int index) {
        Toast.makeText(getActivity(), "" + zlListBeans.get(index).getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickCourseRecommends(int index) {
        Toast.makeText(getActivity(), "" + courseRecommendsBeans.get(index).getAppTitle(), Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.vip_more_tv, R.id.curriculum_register_tv, R.id.zl_more_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.vip_more_tv:
                Toast.makeText(getActivity(), "会员专享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.curriculum_register_tv:
                Toast.makeText(getActivity(), "登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.zl_more_tv:
                Toast.makeText(getActivity(), "专栏专区", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onClickMaster(int index) {
        Toast.makeText(getActivity(), "" + masterLivesBeans.get(index).getAppTitle(), Toast.LENGTH_SHORT).show();
    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Glide.with(context.getApplicationContext()).load((String) path).into(imageView);
        }
    }
}
