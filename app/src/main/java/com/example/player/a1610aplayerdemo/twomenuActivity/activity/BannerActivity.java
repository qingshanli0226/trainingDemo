package com.example.player.a1610aplayerdemo.twomenuActivity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseView;
import com.example.player.a1610aplayerdemo.twomenuActivity.adapter.TabFragmentAdapter;
import com.example.player.a1610aplayerdemo.twomenuActivity.bean.BannerBean;
import com.example.player.a1610aplayerdemo.twomenuActivity.fragment.ClassHoursFragment;
import com.example.player.a1610aplayerdemo.twomenuActivity.fragment.ThisClassFragment;
import com.example.player.a1610aplayerdemo.twomenuActivity.persenter.VedioPersenter;

import java.util.ArrayList;
import java.util.List;

public class BannerActivity extends AppCompatActivity implements BaseView<BannerBean> {

    private ImageView vedioPagerReturnBtn;
    private TextView vedioPagerTitle;
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
    private List<String> textList=new ArrayList<>();
    private List<Fragment> list=new ArrayList<>();


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

        textList.add("本科知识");
        textList.add("课时列表");
        list.add(new ThisClassFragment());
        list.add(new ClassHoursFragment());
         vedioPageTabLayout.setupWithViewPager(vedioPageViewPager);
        TabFragmentAdapter tabFragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager(), textList, list);
        vedioPageViewPager.setAdapter(tabFragmentAdapter);

    }

    @Override
    public void onLoadData(BannerBean datalist) {
        final BannerBean.DataBean data = datalist.getData();
        Log.d("二级菜单Bunner",datalist.getCode());


        Glide.with(this).load(data.getTeacherAvatar()).apply(RequestOptions.bitmapTransform(new RoundedCorners(50))).into(vedioPageTeacherPhoto);
        vedioPagerTitle.setText(data.getName());
        vedioPageTeacherName.setText(data.getTeacherName());
        vedioPageTeacherTitle.setText(data.getTeacherTitle());
        vedioPageCourseName.setText(data.getCourseName());
        vedioPageCoursePrice.setText(data.getCoursePrice()+"元");

        //-------------------

        vedioPageTray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vedioPageTray.setVisibility(View.INVISIBLE);
                View view = getLayoutInflater().from(BannerActivity.this).inflate(R.layout.simple_player_view_player, null);
                setContentView(view);
                final String url="http://qukufile2.qianqian.com/data2/video/3bb92059a78e3c1bdc18b6a603a7d01d/607962660/607962660.mp4";
                final PlayerView playerView = new PlayerView(BannerActivity.this,view)
                        .setTitle("这是一部电影")
                        .setScaleType(PlayStateParams.fitparent)
                        .hideMenu(true)
                        .forbidTouch(false)
                        .showThumbnail(new OnShowThumbnailListener() {
                            @Override
                            public void onShowThumbnail(ImageView ivThumbnail) {
                                Glide.with(BannerActivity.this).load(data.getImage()).into(ivThumbnail);
                            }
                        }).setPlaySource(url).startPlay();

            }
        });

    }

    @Override
    public void onLoadError(int code, String str) {
        Log.d("error二级菜单Bunner",str+"");
    }
}
