package com.example.player.a1610aplayerdemo.ui.activity.category_activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.adapter.find_category_adapter.Category1Adapter;
import com.example.player.a1610aplayerdemo.adapter.find_category_adapter.Category5Adapter;
import com.example.player.a1610aplayerdemo.base.BaseActivity;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.EducationBean;
import com.example.player.a1610aplayerdemo.bean.MusicClassBean;
import com.example.player.a1610aplayerdemo.presenter.find_category_presenter.CategoryEducationPresenter;
import com.example.player.a1610aplayerdemo.presenter.find_category_presenter.CategoryMusicClassPresenter;

import java.util.List;

public class Category5Activity extends BaseActivity implements IBaseView<EducationBean>{
    private RecyclerView category5Recycler;
    IBasePresenter iBasePresenter;
    private ImageView returnimg;
    @Override
    public int getLayoutId() {
        return R.layout.category5_activity;
    }

    @Override
    public void initData() {
        category5Recycler = findViewById(R.id.category5Recycler);
        returnimg = findViewById(R.id.return_img);
        iBasePresenter = new CategoryEducationPresenter();
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
    public void onLoadData(EducationBean data) {
        List<EducationBean.DataBean> data1 = data.getData();
        Category5Adapter adapter = new Category5Adapter(data1,this,R.layout.category5_item);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        category5Recycler.setAdapter(adapter);
        category5Recycler.setLayoutManager(manager);

    }

    @Override
    public void onLoadError(int code, String message) {

    }
}
