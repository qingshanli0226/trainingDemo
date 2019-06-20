package com.example.player.a1610aplayerdemo.curriculum.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.activity.VideoActivity;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.curriculum.adapter.BannerAdapter;
import com.example.player.a1610aplayerdemo.curriculum.bean.BannerBean;
import com.example.player.a1610aplayerdemo.curriculum.presenter.BannerPresenter;
import com.othershe.library.NiceImageView;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class BannerFragment extends Fragment implements IBaseView<BannerBean> {
    @BindView(R.id.banner_back)
    ImageView bannerBack;
    @BindView(R.id.banner_image)
    ImageView bannerImage;
    @BindView(R.id.banner_play)
    TextView bannerPlay;
    @BindView(R.id.banner_collect)
    TextView bannerCollect;
    @BindView(R.id.banner_share)
    TextView bannerShare;
    @BindView(R.id.banner_niv)
    NiceImageView bannerNiv;
    Unbinder unbinder;
    @BindView(R.id.banner_title)
    TextView bannerTitle;
    @BindView(R.id.banner_text1)
    TextView bannerText1;
    @BindView(R.id.banner_text2)
    TextView bannerText2;
    @BindView(R.id.banner_tab)
    TabLayout bannerTab;
    @BindView(R.id.banner_huiyue)
    TextView bannerHuiyue;
    @BindView(R.id.banner_btn)
    Button bannerBtn;
    @BindView(R.id.banner_vp)
    ViewPager bannerVp;

    private IBasePresenter iBasePresenter;
    private BannerBean bannerBean;

    public BannerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iBasePresenter = new BannerPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        iBasePresenter.attachView(this);
        iBasePresenter.getData();
        View view = inflater.inflate(R.layout.fragment_banner, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        BannerAdapter bannerAdapter = new BannerAdapter(getChildFragmentManager());
        bannerVp.setAdapter(bannerAdapter);
        bannerTab.setupWithViewPager(bannerVp);
    }

    @Override
    public void onLoadData(BannerBean data) {
        bannerBean = data;
        Intent intent = new Intent();
        intent.setAction("com.banner.message");
        Bundle bundle = new Bundle();
        bundle.putSerializable("bannerBean", bannerBean);
        intent.putExtras(bundle);
        getActivity().sendBroadcast(intent);
        initData();
    }

    private void initData() {
        bannerTitle.setText(bannerBean.getName());
        Picasso.with(getContext()).load(bannerBean.getImage()).into(bannerImage);
        Picasso.with(getContext()).load(bannerBean.getTeacherAvatar()).into(bannerNiv);
        bannerText1.setText(bannerBean.getTeacherName() + " " + bannerBean.getTeacherTitle());
        bannerText2.setText(bannerBean.getCourseName());
    }

    @Override
    public void onLoadError(int code, String message) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RadioGroup radioGroup = getActivity().findViewById(R.id.home_radioG);
        radioGroup.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.banner_back, R.id.banner_play, R.id.banner_collect, R.id.banner_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.banner_back:
                getFragmentManager().popBackStack();
                break;
            case R.id.banner_play:
                Intent intent = new Intent(getActivity(),VideoActivity.class);
                intent.putExtra("url","http://vd4.bdstatic.com/mda-ja1irnhr4cgdbp8u/hd/mda-ja1irnhr4cgdbp8u.mp4");
                startActivity(intent);
                break;
            case R.id.banner_collect:
                break;
            case R.id.banner_share:
                break;
        }
    }
}
