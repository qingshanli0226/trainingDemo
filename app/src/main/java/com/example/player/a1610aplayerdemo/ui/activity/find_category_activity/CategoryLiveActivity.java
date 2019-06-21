package com.example.player.a1610aplayerdemo.ui.activity.find_category_activity;

import android.annotation.SuppressLint;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.adapter.find_category_adapter.CategoryLiveAdapter;
import com.example.player.a1610aplayerdemo.base.BaseActivity;
import com.example.player.a1610aplayerdemo.base.BasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.net.bean.LiveBean;
import com.example.player.a1610aplayerdemo.presenter.find_category_presenter.CategoryLivePresenter;
import com.google.gson.Gson;

import java.util.List;

@SuppressLint("Registered")
public class CategoryLiveActivity extends BaseActivity implements IBaseView<String>{

    ImageView returnimg;
    RecyclerView recyclerView;
    BasePresenter presenter;
    @Override
    public int getLayoutId() {
        return R.layout.category_live_activity;
    }

    @Override
    public void initData() {
        recyclerView = findViewById(R.id.categoryrecyc2);
        returnimg = findViewById(R.id.return_img);
        presenter = new CategoryLivePresenter();
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
        LiveBean liveBean = gson.fromJson(data, LiveBean.class);
        List<LiveBean.DataBean> data1 = liveBean.getData();
        CategoryLiveAdapter adapter = new CategoryLiveAdapter(data1,this,R.layout.category_live_item);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void onLoadError(int code, String message) {

    }
}
