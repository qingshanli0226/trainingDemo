package com.example.player.a1610aplayerdemo.ui.activy;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TextView;
import com.example.player.a1610aplayerdemo.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class TuiJianClassActivity extends AppCompatActivity {


    private TextView tuijianTitle;
    private SimpleDraweeView tuijianTouxiang;
    private TextView tuijianRen;
    private TableLayout tuijianTab;
    private ViewPager tuijianVpg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tui_jian_class);

        initView();

    }

    private void initView() {
        tuijianTitle = (TextView) findViewById(R.id.tuijian_title);
        tuijianTouxiang = (SimpleDraweeView) findViewById(R.id.tuijian_touxiang);
        tuijianRen = (TextView) findViewById(R.id.tuijian_ren);
        tuijianTab = (TableLayout) findViewById(R.id.tuijian_tab);
        tuijianVpg = (ViewPager) findViewById(R.id.tuijian_vpg);
    }
}
