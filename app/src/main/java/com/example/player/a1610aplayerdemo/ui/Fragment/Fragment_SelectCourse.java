package com.example.player.a1610aplayerdemo.ui.Fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.adapter.Adapter_CourseRecyclerView;
import com.example.player.a1610aplayerdemo.common.HomeBean;
import com.example.player.a1610aplayerdemo.presenter.CoursePresenter;
import com.example.player.a1610aplayerdemo.presenter.ICoursepresenter;
import com.example.player.a1610aplayerdemo.ui.Activity.VedioActivity;
import com.example.player.a1610aplayerdemo.util.Contants;
import com.example.player.a1610aplayerdemo.view.CourseView;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class Fragment_SelectCourse extends Fragment implements CourseView, View.OnClickListener {
    ICoursepresenter iPcoursePresenter;
    private Context mContext;
    private ImageView cursePageTopBtn;
    private RelativeLayout cursePageSearchBtn;
    private RecyclerView cursePageRecyclerView;
    private SharedPreferences preferences;
    private String token;
    private HomeBean homeBean;
    Adapter_CourseRecyclerView adapter;

    private SwipeRefreshLayout coursePageSwipeRefreshLayout;
    public Fragment_SelectCourse(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__select_course, container, false);
        iPcoursePresenter = new CoursePresenter(this);


        initView(view);

        return view;
    }

    private void initView(View view) {
        cursePageTopBtn = (ImageView) view.findViewById(R.id.cursePageTopBtn);
        cursePageTopBtn.setOnClickListener(this);
        cursePageSearchBtn = (RelativeLayout) view.findViewById(R.id.cursePageSearchBtn);
        cursePageSearchBtn.setOnClickListener(this);
        cursePageRecyclerView = (RecyclerView) view.findViewById(R.id.cursePageRecyclerView);
        coursePageSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.coursePageSwipeRefreshLayout);
        //设置下拉刷新回调
        coursePageSwipeRefreshLayout.setColorSchemeColors(Color.parseColor("#8E002E"));
        coursePageSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //刷新数据
                initNetInfo();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                coursePageSwipeRefreshLayout.setRefreshing(false);
            }
        });
        initNetInfo();
    }

    private void initNetInfo() {
        preferences = mContext.getSharedPreferences(Contants.SP, Context.MODE_PRIVATE);
        token = preferences.getString(Contants.TOKEN, "");
        iPcoursePresenter.getHomeData(token,mContext);

    }

    @Override
    public void SuccessCourse(HomeBean homeBean) {
        Fragment_SelectCourse.this.homeBean = homeBean;
        Log.e("aaa",homeBean.getCode());
        initRecyclerView();

    }


    @Override
    public void FailureCourse(String e) {
        Log.e("aa",e);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cursePageTopBtn:
                //随便按的按钮
                startActivity(new Intent(mContext, VedioActivity.class));
                break;
            case R.id.cursePageSearchBtn:
                //跳转到搜索页面
                Toast.makeText(mContext, "进入搜索页面", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void initRecyclerView() {
        adapter = new Adapter_CourseRecyclerView(mContext, homeBean);
        cursePageRecyclerView.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(mContext, 1);
        cursePageRecyclerView.setLayoutManager(manager);
    }

}
