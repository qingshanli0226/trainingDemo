package com.example.player.a1610aplayerdemo.ui.mvvmzaixianzhibo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.NowZhiBoDateBean;
import com.example.player.a1610aplayerdemo.ui.mvvmzaixianzhibo.zhiboadapter.NowZhiBoAdp;
import com.example.player.a1610aplayerdemo.ui.mvvmzaixianzhibo.zhibopresenter.IShowingViewMode;
import com.example.player.a1610aplayerdemo.ui.mvvmzaixianzhibo.zhibopresenter.IZhiBoView;
import com.example.player.a1610aplayerdemo.ui.mvvmzaixianzhibo.zhibopresenter.NowShowingViewMode;

import java.util.List;

public class NowShowActivity extends AppCompatActivity implements IZhiBoView {


    IShowingViewMode showingViewMode;
    ViewDataBinding dataBinding;

    NowZhiBoAdp adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_now_show);

        showingViewMode = new NowShowingViewMode();
        showingViewMode.attachView(this);

        initView();
        initData();
    }

    private void initData() {
        showingViewMode.getZiBoDate();

    }

    private void initView() {
        adp = new NowZhiBoAdp();

        RecyclerView  showingRecy = dataBinding.getRoot().findViewById(R.id.showing_recy);

        showingRecy.setLayoutManager(new LinearLayoutManager(this));

        showingRecy.setAdapter(adp);


    }

    @Override
    public void onGetZhiBoList(List<NowZhiBoDateBean> zhiBoDateBeans) {
        adp.upadateBooks(zhiBoDateBeans);

    }

    @Override
    public void onGetZhiBoFailed(int code, String message) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showingViewMode.detachView();
    }

    public void fanhui(View view) {
        finish();
    }
}
