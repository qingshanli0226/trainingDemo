package com.example.player.a1610aplayerdemo.curriculum.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.activity.VideoActivity;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.curriculum.adapter.BannerAdapter;
import com.example.player.a1610aplayerdemo.curriculum.bean.BannerBean;
import com.example.player.a1610aplayerdemo.curriculum.presenter.BannerPresenter;
import com.othershe.library.NiceImageView;
import com.squareup.picasso.Picasso;

public class BannerActivity extends AppCompatActivity implements IBaseView<BannerBean> {

    @BindView(R.id.banner_back)
    ImageView bannerBack;
    @BindView(R.id.banner_title)
    TextView bannerTitle;
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
    @BindView(R.id.banner_text1)
    TextView bannerText1;
    @BindView(R.id.banner_text2)
    TextView bannerText2;
    @BindView(R.id.banner_tab)
    TabLayout bannerTab;
    @BindView(R.id.banner_vp)
    ViewPager bannerVp;
    @BindView(R.id.banner_huiyue)
    TextView bannerHuiyue;
    @BindView(R.id.banner_btn)
    Button bannerBtn;

    private IBasePresenter iBasePresenter;
    private BannerBean bannerBean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        ButterKnife.bind(this);
        iBasePresenter = new BannerPresenter();
        iBasePresenter.attachView(this);
        iBasePresenter.getData();
        initView();
    }

    private void initView() {
        BannerAdapter bannerAdapter = new BannerAdapter(getSupportFragmentManager());
        bannerVp.setAdapter(bannerAdapter);
        bannerTab.setupWithViewPager(bannerVp);
    }

    @OnClick({R.id.banner_back, R.id.banner_play, R.id.banner_collect, R.id.banner_share})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.banner_back:
                finish();
                break;
            case R.id.banner_play:
                Intent intent = new Intent(this,VideoActivity.class);
                intent.putExtra("url","http://vd4.bdstatic.com/mda-ja1irnhr4cgdbp8u/hd/mda-ja1irnhr4cgdbp8u.mp4");
                startActivity(intent);
                break;
            case R.id.banner_collect:
                break;
            case R.id.banner_share:
                break;
        }
    }

    @Override
    public void onLoadData(BannerBean data) {
        bannerBean = data;
        Intent intent = new Intent();
        intent.setAction("com.banner.message");
        Bundle bundle = new Bundle();
        bundle.putSerializable("bannerBean", bannerBean);
        intent.putExtras(bundle);
        sendBroadcast(intent);
        initData();
    }

    private void initData() {
        bannerTitle.setText(bannerBean.getName());
        Picasso.with(this).load(bannerBean.getImage()).into(bannerImage);
        Picasso.with(this).load(bannerBean.getTeacherAvatar()).into(bannerNiv);
        bannerText1.setText(bannerBean.getTeacherName() + " " + bannerBean.getTeacherTitle());
        bannerText2.setText(bannerBean.getCourseName());
    }

    @Override
    public void onLoadError(int code, String message) {

    }
}
