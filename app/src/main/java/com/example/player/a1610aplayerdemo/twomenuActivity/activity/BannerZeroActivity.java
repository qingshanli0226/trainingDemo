package com.example.player.a1610aplayerdemo.twomenuActivity.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import com.example.player.a1610aplayerdemo.R;

public class BannerZeroActivity extends AppCompatActivity {

    private WebView wenview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_zero);
        initView();
    }

    private void initView() {
        wenview = (WebView) findViewById(R.id.wenview);
        wenview.loadUrl("http://api.immedc.com/restapi/apph5/viphy?pkgid=16 ");
    }
}
