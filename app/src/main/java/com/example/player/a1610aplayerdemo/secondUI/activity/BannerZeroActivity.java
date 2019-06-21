package com.example.player.a1610aplayerdemo.secondUI.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import com.example.player.a1610aplayerdemo.R;

public class BannerZeroActivity extends AppCompatActivity {

    private WebView wenview;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_zero);
        initView();
    }

    private void initView() {
        wenview = (WebView) findViewById(R.id.wenview);

        wenview.loadUrl("http://api.immedc.com/restapi/apph5/viphy?pkgid=16 ");
        back = (ImageView) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
