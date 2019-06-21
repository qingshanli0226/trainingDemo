package com.example.player.a1610aplayerdemo.ui.zhuanlan;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.TuiJianDateBean;
import com.example.player.a1610aplayerdemo.bean.ZhuanLanDateBean;
import com.example.player.a1610aplayerdemo.net.MVPObserver;
import com.example.player.a1610aplayerdemo.net.MyNetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.ui.zhuanlan.zhuanlanfragment.ZhanlanViewPagerAdp;
import com.example.player.a1610aplayerdemo.util.DeviceKye;
import com.example.player.a1610aplayerdemo.util.SpUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class ZhuanLanActivity extends AppCompatActivity {

    private TextView fanhui;
    private TextView titleZhuanlan;
    private SimpleDraweeView zhuanlanImg;
    private TabLayout zhuanlanTitleTab;
    private ViewPager zhuanlanVpg;

    ZhanlanViewPagerAdp adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuan_lan);

        Intent intent = getIntent();
        String id = intent.getStringExtra("zhuanlanvideo");

        SpUtil.savevideoid(id);

        initView();
        getDate(id);

        adp = new ZhanlanViewPagerAdp(getSupportFragmentManager());
        zhuanlanVpg.setAdapter(adp);
        zhuanlanTitleTab.setupWithViewPager(zhuanlanVpg);
    }

    private void getDate(String id) {

        Map<String, String> headmap = new HashMap<>();
        headmap.put("DeviceKey", DeviceKye.getDeviceKye());

        Map<String, String> map = new HashMap<>();
        map.put("id", id);


        RetrofitCreator.getApiService().getZhuanLanDate(headmap, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new MyNetFunction<ResEntity<ZhuanLanDateBean>,ZhuanLanDateBean>())
                .subscribe(new MVPObserver<ZhuanLanDateBean>() {
                    @Override
                    public void onNext(ZhuanLanDateBean zhuanLanDateBean) {
                        super.onNext(zhuanLanDateBean);

                        inshuju(zhuanLanDateBean);
                    }
                });


    }

    private void inshuju(ZhuanLanDateBean zhuanLanDateBean) {

        titleZhuanlan.setText(zhuanLanDateBean.getBarTitle());
        zhuanlanImg.setImageURI(zhuanLanDateBean.getImage());

    }

    private void initView() {
        fanhui = (TextView) findViewById(R.id.fanhui);
        titleZhuanlan = (TextView) findViewById(R.id.title_zhuanlan);
        zhuanlanImg = (SimpleDraweeView) findViewById(R.id.zhuanlan_img);
        zhuanlanTitleTab = (TabLayout) findViewById(R.id.zhuanlan_title_tab);
        zhuanlanVpg = (ViewPager) findViewById(R.id.zhuanlan_vpg);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
