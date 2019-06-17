package com.example.player.a1610aplayerdemo.cateactivity.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.player.a1610aplayerdemo.Content;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.DivToolbar;
import com.example.player.a1610aplayerdemo.cateactivity.Bean.CateGoryBean;
import com.example.player.a1610aplayerdemo.cateactivity.adapter.CaterGoryAdapter;
import com.example.player.a1610aplayerdemo.cateactivity.presenter.CateGoryComple;
import com.example.player.a1610aplayerdemo.cateactivity.presenter.CateGoryContract;

import java.util.List;

public class CategoryActivity extends AppCompatActivity implements CateGoryContract.ICateGoryState {

    private RecyclerView rvCategory;
    private CateGoryContract.ILoadCateGoryBean iLoadCateGoryBean;
    private CaterGoryAdapter goryAdapter;
    private DivToolbar toobBar;
    private String toolbarValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Intent intent = getIntent();
        int cateGory = intent.getIntExtra(Content.CATE_FLAG_GORY, 0);
         toolbarValue = intent.getStringExtra(Content.TOOL_VAULE);
        String cateGoryUrl = "http://api.immedc.com/restapi/course/getCourses?grade=0&perfesionalCategoryId=" + cateGory + "&page=1&size=20";
        iLoadCateGoryBean = new CateGoryComple(this);
        iLoadCateGoryBean.getCateGoryBean(cateGoryUrl);

        initView();
    }

    private void initView() {
        rvCategory = findViewById(R.id.rv_category);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        rvCategory.setLayoutManager(gridLayoutManager);
        goryAdapter = new CaterGoryAdapter();
        rvCategory.setAdapter(goryAdapter);

        toobBar = findViewById(R.id.toobBar);
        toobBar.setLeftImageResource(R.drawable.toolbar_back);
        toobBar.setRightLayoutVisibility(View.GONE);
        toobBar.setCenterLeftTextLayoutVisibility(View.GONE);
        toobBar.setCenterRightTextLayoutVisibility(View.VISIBLE);
        toobBar.setCenterRightText(toolbarValue);

        toobBar.setLeftLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void succssful(List<CateGoryBean.DataBean> bean) {
        goryAdapter.refreshData(bean);
    }
}
