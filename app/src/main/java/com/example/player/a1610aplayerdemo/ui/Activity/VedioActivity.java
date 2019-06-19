package com.example.player.a1610aplayerdemo.ui.Activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.adapter.Adapter_VedioPageViewPagerAdapter;
import com.example.player.a1610aplayerdemo.common.VedioBean;
import com.example.player.a1610aplayerdemo.presenter.IVedioPresenter;
import com.example.player.a1610aplayerdemo.presenter.VedioPresenter;
import com.example.player.a1610aplayerdemo.ui.Fragment.Fragment_VedioPageCourse;
import com.example.player.a1610aplayerdemo.ui.Fragment.Fragment_VedioPageDes;
import com.example.player.a1610aplayerdemo.ui.Fragment.Fragment_VedioPageHW;
import com.example.player.a1610aplayerdemo.util.Contants;
import com.example.player.a1610aplayerdemo.view.ViedioView;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.ArrayList;
import java.util.List;

public class VedioActivity extends AppCompatActivity implements View.OnClickListener, ViedioView {

    private JZVideoPlayerStandard myJZ;
    private SensorManager service;
    private JZVideoPlayer.JZAutoFullscreenListener listener;
    private ImageView vedioPageTeacherShareBtn;
    private ImageView vedioPageTeacherCollectBtn;
    private ImageView vedioPageTeacherBuyBtn;
    private ImageView vedioPageTeacherPhoto;
    private TextView vedioPageTeacherName;
    private TextView vedioPageTeacherTitle;
    private TextView vedioPageCourseName;
    private TextView vedioPageCoursePrice;
    private String vedioUrl;
    private String image;
    private String courseName;
    private String teacherName;
    private String teacherTitle;
    private String priceText;
    private String teacherAvatar;
    private String url;
    private ImageView vedioPageVedioImg;
    private TextView vedioPageTray;
    private TabLayout vedioPageTabLayout;
    private ViewPager vedioPageViewPager;
    private Fragment_VedioPageCourse fragmentCourse;
    private Fragment_VedioPageHW fragmentHw;
    private Fragment_VedioPageDes fragmentDes;
    private ImageView vedioPagerReturnBtn;
    private TextView vedioPagerTitle;
    IVedioPresenter iVedioPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio);
        iVedioPresenter = new VedioPresenter(this);
        initView();

    }
    private void initVedio() {
        //重力感应
        service = (SensorManager) getSystemService(SENSOR_SERVICE);
        listener = new JZVideoPlayer.JZAutoFullscreenListener();
    }


    private void initView() {
        myJZ = (JZVideoPlayerStandard) findViewById(R.id.myJZ);
        vedioPageTeacherShareBtn = (ImageView) findViewById(R.id.vedioPageTeacherShareBtn);
        vedioPageTeacherShareBtn.setOnClickListener(this);
        vedioPageTeacherCollectBtn = (ImageView) findViewById(R.id.vedioPageTeacherCollectBtn);
        vedioPageTeacherCollectBtn.setOnClickListener(this);
        vedioPageTeacherBuyBtn = (ImageView) findViewById(R.id.vedioPageTeacherBuyBtn);
        vedioPageTeacherBuyBtn.setOnClickListener(this);
        vedioPageTeacherPhoto = (ImageView) findViewById(R.id.vedioPageTeacherPhoto);
        vedioPageTeacherPhoto.setOnClickListener(this);
        vedioPageTeacherName = (TextView) findViewById(R.id.vedioPageTeacherName);
        vedioPageTeacherTitle = (TextView) findViewById(R.id.vedioPageTeacherTitle);
        vedioPageCourseName = (TextView) findViewById(R.id.vedioPageCourseName);
        vedioPageCoursePrice = (TextView) findViewById(R.id.vedioPageCoursePrice);
        vedioPageVedioImg = (ImageView) findViewById(R.id.vedioPageVedioImg);
        vedioPageTray = (TextView) findViewById(R.id.vedioPageTray);
        vedioPageTray.setOnClickListener(this);
        vedioPageTabLayout = (TabLayout) findViewById(R.id.vedioPageTabLayout);
        vedioPageViewPager = (ViewPager) findViewById(R.id.vedioPageViewPager);
        vedioPagerReturnBtn = (ImageView) findViewById(R.id.vedioPagerReturnBtn);
        vedioPagerReturnBtn.setOnClickListener(this);
        vedioPagerTitle = (TextView) findViewById(R.id.vedioPagerTitle);
        initNetInfo();//初始化网络数据
        initVedio();//初始化视频播放器

    }


    private void initNetInfo() {
        Intent intent = getIntent();
        vedioUrl = intent.getStringExtra("vedioUrl");//获取的视频ID
        SharedPreferences preferences = getSharedPreferences(Contants.SP, MODE_PRIVATE);
        String token = preferences.getString(Contants.TOKEN, "");
        iVedioPresenter.getVidioData(token,vedioUrl,this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.vedioPageTeacherPhoto:
                //点击进入老师信息详情页面
                break;
            case R.id.vedioPageTeacherShareBtn:
                //购买按钮
                break;
            case R.id.vedioPageTeacherCollectBtn:
                //收藏按钮
                break;
            case R.id.vedioPageTeacherBuyBtn:
                //购买按钮
                break;
            case R.id.vedioPageTray:
                //试看按钮
                vedioPageTray.setVisibility(View.INVISIBLE);
                myJZ.setVisibility(View.VISIBLE);
                vedioPageVedioImg.setVisibility(View.INVISIBLE);
                break;
            case R.id.vedioPagerReturnBtn:
                //返回按钮
                finish();
                break;

        }
    }

    @Override
    public void SuccessCourse(VedioBean vedioBean) {
        VedioBean.DataBean data = vedioBean.getData();
        image = data.getImage();
        Glide.with(VedioActivity.this).load(image).into(vedioPageVedioImg);
        courseName = data.getCourseName();
        vedioPageCourseName.setText(courseName);
        teacherName = data.getTeacherName();
        vedioPageTeacherName.setText(teacherName);
        teacherTitle = data.getTeacherTitle();
        vedioPageTeacherTitle.setText(teacherTitle);
        priceText = data.getPriceText();
        vedioPageCoursePrice.setText(priceText);
        teacherAvatar = data.getTeacherAvatar();
        Glide.with(VedioActivity.this).load(teacherAvatar).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(vedioPageTeacherPhoto);
        vedioPagerTitle.setText(data.getName());
        url = "http://1251603248.vod2.myqcloud.com/4c9adaa7vodtransgzp1251603248/cb8738429031868223003783266/f0.f40.mp4";
        //设置图片为全屏
        myJZ.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        //设置图片高度，去黑边
        JZVideoPlayer.setVideoImageDisplayType(JZVideoPlayer.VIDEO_IMAGE_DISPLAY_TYPE_FILL_PARENT);
        //播放视频
        myJZ.TOOL_BAR_EXIST = false;
        myJZ.setUp(url, JZVideoPlayerStandard.SCROLL_AXIS_HORIZONTAL);
        //播放比例
        myJZ.widthRatio = 4;
        myJZ.heightRatio = 2;
        //设置全屏播放
        JZVideoPlayer.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;//横向
        JZVideoPlayer.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT;  //纵向
        initCourse(data);//初始化课程ViewPager

    }

    private void initCourse(VedioBean.DataBean data) {
        List<String> tabs = new ArrayList<>();
        tabs.add("本课知识");
        tabs.add("课时列表");
        tabs.add("作业要求");

        for (String tab : tabs) {
            TabLayout.Tab newTab = vedioPageTabLayout.newTab();
            newTab.setText(tab);
            vedioPageTabLayout.addTab(newTab);
        }
        List<Fragment> fragments = new ArrayList<>();
        fragmentCourse = new Fragment_VedioPageCourse(this,data);
        fragmentDes = new Fragment_VedioPageDes(this,data);
        fragmentHw = new Fragment_VedioPageHW(this,data);
        fragments.add(fragmentDes);
        fragments.add(fragmentCourse);
        fragments.add(fragmentHw);
        Adapter_VedioPageViewPagerAdapter adapter = new Adapter_VedioPageViewPagerAdapter(getSupportFragmentManager(), fragments, this, tabs);
        vedioPageViewPager.setAdapter(adapter);
        vedioPageViewPager.setOffscreenPageLimit(0);
        vedioPageTabLayout.setupWithViewPager(vedioPageViewPager);
    }

    @Override
    public void FailureCourse(String e) {

    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();

    }

    @Override
    protected void onPause() {
        super.onPause();
        service.unregisterListener(listener);
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //播放重力感应
        Sensor defaultSensor = service.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        service.registerListener(listener, defaultSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
