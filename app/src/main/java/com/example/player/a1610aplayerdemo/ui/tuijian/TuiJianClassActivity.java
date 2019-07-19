package com.example.player.a1610aplayerdemo.ui.tuijian;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.TuiJianDateBean;
import com.example.player.a1610aplayerdemo.net.MVPObserver;
import com.example.player.a1610aplayerdemo.net.MyNetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.ui.adapter.TuiJianVpgAdp;
import com.example.player.a1610aplayerdemo.ui.tuijian.tuijianfragment.BenKeKnowFragment;
import com.example.player.a1610aplayerdemo.ui.tuijian.tuijianfragment.KeShiFragment;
import com.example.player.a1610aplayerdemo.util.DeviceKye;
import com.example.player.a1610aplayerdemo.util.SpUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;
import com.umeng.socialize.UMShareAPI;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TuiJianClassActivity extends AppCompatActivity {


    private TextView tuijianTitle;
    private SimpleDraweeView tuijianTouxiang;
    private TextView tuijianRen;
    PlayerView player;
    private ViewPager tuijianVpg;
    private TextView tuijianCourseName;

    List<Fragment> lv = new ArrayList<>();
    List<String> tt = new ArrayList<>();
    private TabLayout tuijianTab;
    private TextView tuijianJiaqian;
    private Button tjShikan;
    TuiJianVpgAdp tuiJianVpgAdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tui_jian_class);

        Intent intent = getIntent();
        String id = intent.getStringExtra("courseId");

        SpUtil.saveId(id);

        lv.add(new BenKeKnowFragment());
        lv.add(new KeShiFragment());

        tt.add("本课知识");
        tt.add("课时列表");



        initView();

        tuiJianVpgAdp = new TuiJianVpgAdp(getSupportFragmentManager(), lv, tt);

        tuijianVpg.setAdapter(tuiJianVpgAdp);

        tuijianTab.setupWithViewPager(tuijianVpg);

        iniDate(id);


    }



    private void iniDate(String s) {

        Map<String, String> headmap = new HashMap<>();
        headmap.put("DeviceKey", DeviceKye.getDeviceKye());

        Map<String, String> map = new HashMap<>();
        map.put("courseId", s);
        map.put("packageId", "0");


        RetrofitCreator.getApiService().getTuiJianDate(headmap, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new MyNetFunction<ResEntity<TuiJianDateBean>, TuiJianDateBean>())
                .subscribe(new MVPObserver<TuiJianDateBean>() {
                    @Override
                    public void onNext(TuiJianDateBean tuiJianDateBean) {
                        super.onNext(tuiJianDateBean);

                        iniBean(tuiJianDateBean);
                    }
                });

    }

    private void iniBean(final TuiJianDateBean tuiJianDateBean) {

        tuijianTitle.setText(tuiJianDateBean.getName());

        tuijianTouxiang.setImageURI(tuiJianDateBean.getTeacherAvatar());

        tuijianRen.setText(tuiJianDateBean.getTeacherName());

        tuijianCourseName.setText(tuiJianDateBean.getCourseName());

        tuijianJiaqian.setText(tuiJianDateBean.getPriceText());

        player = new PlayerView(TuiJianClassActivity.this).setTitle("bt")
                .setScaleType(PlayStateParams.fitparent)
                .forbidTouch(false)
                .hideMenu(true)
                .showThumbnail(new OnShowThumbnailListener() {
                    @Override
                    public void onShowThumbnail(ImageView ivThumbnail) {
                        Picasso.get().load(tuiJianDateBean.getImage())
                                .into(ivThumbnail);
                    }
                })
                .setPlaySource("http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8");


       // playVideo(tuiJianDateBean);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (player != null) {
            player.onConfigurationChanged(newConfig);
        }
    }

    private void initView() {
        tuijianTitle = (TextView) findViewById(R.id.tuijian_title);
        tuijianTouxiang = (SimpleDraweeView) findViewById(R.id.tuijian_touxiang);
        tuijianRen = (TextView) findViewById(R.id.tuijian_ren);

        tuijianVpg = (ViewPager) findViewById(R.id.tuijian_vpg);
        tuijianCourseName = (TextView) findViewById(R.id.tuijian_courseName);
        tuijianTab = (TabLayout) findViewById(R.id.tuijian_tab);
        tuijianJiaqian = (TextView) findViewById(R.id.tuijian_jiaqian);
        tjShikan = (Button) findViewById(R.id.tj_shikan);

        tjShikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                player.startPlay();

                tjShikan.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    public void fanhui(View view) {
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.onDestroy();
    }

    public void shareQQ(View view) {

    }
}
