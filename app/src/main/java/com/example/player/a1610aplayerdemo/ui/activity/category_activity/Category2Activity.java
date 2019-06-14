package com.example.player.a1610aplayerdemo.ui.activity.category_activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.adapter.find_category_adapter.Category1Adapter;
import com.example.player.a1610aplayerdemo.adapter.find_category_adapter.Category2Adapter;
import com.example.player.a1610aplayerdemo.base.BaseActivity;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.LiveBean;
import com.example.player.a1610aplayerdemo.bean.MusicClassBean;
import com.example.player.a1610aplayerdemo.presenter.find_category_presenter.CategoryLiveClassPresenter;
import com.example.player.a1610aplayerdemo.presenter.find_category_presenter.CategoryMusicClassPresenter;

public class Category2Activity extends BaseActivity implements IBaseView<LiveBean>{
    private RecyclerView category2Recycler;
    IBasePresenter iBasePresenter;
    private ImageView returnimg;
    @Override
    public int getLayoutId() {
        return R.layout.category2_activity;
    }

    @Override
    public void initData() {
        category2Recycler = findViewById(R.id.category2Recycler);
        returnimg = findViewById(R.id.return_img);
        iBasePresenter = new CategoryLiveClassPresenter();
        iBasePresenter.attachView(this);
        iBasePresenter.getData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        iBasePresenter.detachView();
    }

    @Override
    public void initListener() {
        returnimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }



    @Override
    public void onLoadData(LiveBean data) {
        Category2Adapter adapter = new Category2Adapter(data.getData(),this,R.layout.category2_item);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        category2Recycler.setAdapter(adapter);
        category2Recycler.setLayoutManager(manager);

    }

    @Override
    public void onLoadError(int code, String message) {

    }
}