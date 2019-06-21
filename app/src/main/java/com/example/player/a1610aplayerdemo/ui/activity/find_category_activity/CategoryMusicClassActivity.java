package com.example.player.a1610aplayerdemo.ui.activity.find_category_activity;

import android.annotation.SuppressLint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.adapter.find_category_adapter.CategoryMusicClassAdapter;
import com.example.player.a1610aplayerdemo.base.BaseActivity;
import com.example.player.a1610aplayerdemo.base.BasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.net.bean.MusicClassBean;
import com.example.player.a1610aplayerdemo.presenter.find_category_presenter.CategoryMusicClassPresenter;
import com.google.gson.Gson;

import java.util.List;

@SuppressLint("Registered")
public class CategoryMusicClassActivity extends BaseActivity implements IBaseView<String>{

    ImageView returnimg;
    RecyclerView recyclerView;
    BasePresenter presenter;
    @Override
    public int getLayoutId() {
        return R.layout.category_musicclass_activity;
    }

    @Override
    public void initData() {
        recyclerView = findViewById(R.id.categoryrecyc1);
        returnimg = findViewById(R.id.return_img);
        presenter = new CategoryMusicClassPresenter();
        presenter.attachView(this);
        presenter.getData();
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
    public void onLoadDataBean(String data) {
        Gson gson = new Gson();
        MusicClassBean musicClassBean = gson.fromJson(data, MusicClassBean.class);
        List<MusicClassBean.DataBean> data1 = musicClassBean.getData();
        CategoryMusicClassAdapter adapter = new CategoryMusicClassAdapter(data1,this,R.layout.category_musicclass_item);
        GridLayoutManager manager = new GridLayoutManager(this,4);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void onLoadError(int code, String message) {

    }
}
