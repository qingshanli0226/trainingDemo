package com.example.player.a1610aplayerdemo.ui.activity.category_activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.adapter.find_category_adapter.Category1Adapter;
import com.example.player.a1610aplayerdemo.base.BaseActivity;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.MusicClassBean;
import com.example.player.a1610aplayerdemo.presenter.find_category_presenter.CategoryMusicClassPresenter;

public class Category1Activity extends BaseActivity implements IBaseView<MusicClassBean>{
    private RecyclerView category1Recycler;
    IBasePresenter iBasePresenter;
    private ImageView returnimg;
    @Override
    public int getLayoutId() {
        return R.layout.category1_activity;
    }

    @Override
    public void initData() {
        category1Recycler = findViewById(R.id.category1Recycler);
        returnimg = findViewById(R.id.return_img);
        iBasePresenter = new CategoryMusicClassPresenter();
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
    public void onLoadData(MusicClassBean data) {
        Category1Adapter adapter = new Category1Adapter(data.getData(),this,R.layout.category1_item);
        GridLayoutManager manager = new GridLayoutManager(this,4);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        category1Recycler.setAdapter(adapter);
        category1Recycler.setLayoutManager(manager);

    }

    @Override
    public void onLoadError(int code, String message) {

    }
}
