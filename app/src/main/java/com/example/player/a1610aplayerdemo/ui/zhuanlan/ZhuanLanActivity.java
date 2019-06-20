package com.example.player.a1610aplayerdemo.ui.zhuanlan;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.ui.zhuanlan.zhuanlanFragment.ZhanlanViewPagerAdp;
import com.facebook.drawee.view.SimpleDraweeView;

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
        initView();
        adp = new ZhanlanViewPagerAdp(getSupportFragmentManager());
        zhuanlanVpg.setAdapter(adp);
        zhuanlanTitleTab.setupWithViewPager(zhuanlanVpg);
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
