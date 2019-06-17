package com.example.player.a1610aplayerdemo.twomenuActivity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseView;
import com.example.player.a1610aplayerdemo.twomenuActivity.bean.BannerBean;
import com.example.player.a1610aplayerdemo.twomenuActivity.persenter.VedioPersenter;

public class BannerActivity extends AppCompatActivity implements BaseView<BannerBean> {

    private ImageView vedioPagerReturnBtn;
    private TextView vedioPagerTitle;
    private LinearLayout vedioPagerLinerLayout;

    private ImageView vedioPageVedioImg;
    private TextView vedioPageTray;
    private ImageView vedioPageTeacherShareBtn;
    private ImageView vedioPageTeacherCollectBtn;
    private ImageView vedioPageTeacherBuyBtn;
    private ImageView vedioPageTeacherPhoto;
    private TextView vedioPageTeacherName;
    private TextView vedioPageTeacherTitle;
    private TextView vedioPageCourseName;
    private TextView vedioPageCoursePrice;
    private TabLayout vedioPageTabLayout;
    private ViewPager vedioPageViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banners);
        initView();
        Intent intent = getIntent();
        String relation = intent.getStringExtra("relation");

        new VedioPersenter(this).getVedioData(relation,"0");

    }

    private void initView() {
        vedioPagerReturnBtn = (ImageView) findViewById(R.id.vedioPagerReturnBtn);
        vedioPagerTitle = (TextView) findViewById(R.id.vedioPagerTitle);
        vedioPagerLinerLayout = (LinearLayout) findViewById(R.id.vedioPagerLinerLayout);
        vedioPageVedioImg = (ImageView) findViewById(R.id.vedioPageVedioImg);
        vedioPageTray = (TextView) findViewById(R.id.vedioPageTray);
        vedioPageTeacherShareBtn = (ImageView) findViewById(R.id.vedioPageTeacherShareBtn);
        vedioPageTeacherCollectBtn = (ImageView) findViewById(R.id.vedioPageTeacherCollectBtn);
        vedioPageTeacherBuyBtn = (ImageView) findViewById(R.id.vedioPageTeacherBuyBtn);
        vedioPageTeacherPhoto = (ImageView) findViewById(R.id.vedioPageTeacherPhoto);
        vedioPageTeacherName = (TextView) findViewById(R.id.vedioPageTeacherName);
        vedioPageTeacherTitle = (TextView) findViewById(R.id.vedioPageTeacherTitle);
        vedioPageCourseName = (TextView) findViewById(R.id.vedioPageCourseName);
        vedioPageCoursePrice = (TextView) findViewById(R.id.vedioPageCoursePrice);
        vedioPageTabLayout = (TabLayout) findViewById(R.id.vedioPageTabLayout);
        vedioPageViewPager = (ViewPager) findViewById(R.id.vedioPageViewPager);
    }

    @Override
    public void onLoadData(BannerBean datalist) {
        BannerBean.DataBean data = datalist.getData();
        Log.d("二级菜单Bunner",datalist.getCode());

        Glide.with(this).load(data.getImage()).into(vedioPageVedioImg);
        Glide.with(this).load(data.getTeacherAvatar()).apply(RequestOptions.bitmapTransform(new RoundedCorners(50))).into(vedioPageTeacherPhoto);
        vedioPagerTitle.setText(data.getName());
        vedioPageTeacherName.setText(data.getTeacherName());
        vedioPageTeacherTitle.setText(data.getTeacherTitle());
        vedioPageCourseName.setText(data.getCourseName());
        vedioPageCoursePrice.setText(data.getCoursePrice()+"元");

    }

    @Override
    public void onLoadError(int code, String str) {
        Log.d("error二级菜单Bunner",str+"");
    }
}
