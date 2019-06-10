package com.example.player.a1610aplayerdemo.ui.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.player.a1610aplayerdemo.MainActivity;
import com.example.player.a1610aplayerdemo.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Activity_StartBanner extends AppCompatActivity implements View.OnClickListener{
    private int[] images = new int[]{R.mipmap.new_feature_pic1, R.mipmap.new_feature_pic2, R.mipmap.new_feature_pic3, R.mipmap.new_feature_pic4};
    private Banner startBanner;
    private TextView startBannerJumpBtn;
    private Intent intent;
    private Button StartBannerAlphaBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__start_banner);
        initView();

    }
    private void initView() {
        startBanner = (Banner) findViewById(R.id.startBanner);
        startBannerJumpBtn = (TextView) findViewById(R.id.startBannerJumpBtn);
        StartBannerAlphaBtn = (Button) findViewById(R.id.StartBannerAlphaBtn);
        StartBannerAlphaBtn.setOnClickListener(this);
        intent = new Intent(Activity_StartBanner.this, MainActivity.class);
        startBannerJumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                finish();
            }
        });
        List<Integer> mlist = new ArrayList<>();
        for (int image : images) {
            mlist.add(image);
        }
        startBanner.setImages(mlist);
        startBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
        startBanner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        startBanner.isAutoPlay(false);
        startBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                if (i == 3) {
                    startBannerJumpBtn.setVisibility(View.INVISIBLE);
                    StartBannerAlphaBtn.setVisibility(View.VISIBLE);
                    startBannerJumpBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(intent);
                            finish();
                        }
                    });

                } else {
                    startBannerJumpBtn.setVisibility(View.VISIBLE);
                    StartBannerAlphaBtn.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        startBanner.start();



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.StartBannerAlphaBtn:
                startActivity(intent);
                finish();
                break;
        }
    }
}
