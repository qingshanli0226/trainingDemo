package com.example.player.a1610aplayerdemo.ui.home.homeactivity.categoryactivity.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.GridView;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.ui.home.homeactivity.categoryactivity.adapter.CategoryZeroAdapter;
import com.example.player.a1610aplayerdemo.ui.home.homeactivity.categoryactivity.bean.CategoryZeroBean;
import com.example.player.a1610aplayerdemo.ui.home.homeactivity.categoryactivity.presenter.CategoryZeroPresenter;

import java.util.ArrayList;
import java.util.List;

public class CategoryZeroActivity extends AppCompatActivity implements IBaseView {
    private IBasePresenter iBasePresenter;
    private GridView categoryzeroGv;
    private CategoryZeroAdapter adapter;
    private List<CategoryZeroBean.DataBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_category_zero);
        initView();
        iBasePresenter = new CategoryZeroPresenter();
        iBasePresenter.attachView(this);
        iBasePresenter.getData();
        adapter = new CategoryZeroAdapter();
        categoryzeroGv.setAdapter(adapter);
    }

    private void initView() {
        categoryzeroGv = (GridView) findViewById(R.id.categoryzero_gv);
    }

    @Override
    public void onLoadData(List data) {
        list.addAll(data);
        adapter.updata(this,list);
    }

    @Override
    public void onLoadError(int code, String message) {

    }

    @Override
    public void onLoadObject(Object data) {

    }
}