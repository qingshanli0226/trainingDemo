package com.example.player.a1610aplayerdemo.ui.Fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.adapter.Adapter_VIPRecyclerView;
import com.example.player.a1610aplayerdemo.common.HomeBean;

import com.example.player.a1610aplayerdemo.presenter.IVIPPresenter;
import com.example.player.a1610aplayerdemo.presenter.VIPPresenter;
import com.example.player.a1610aplayerdemo.util.Contants;
import com.example.player.a1610aplayerdemo.view.VIPView;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class Fragment_VIP extends Fragment implements VIPView,Adapter_VIPRecyclerView.OnClikcItem  {
IVIPPresenter ivipPresenter;
Context mContext;
    private SharedPreferences preferences;
    private String token;
    private HomeBean homeBean;
    private RecyclerView vipPageRecyclerView;
    private SwipeRefreshLayout vipPageSwipeRefreshLayout;


    public Fragment_VIP(Context context) {
        mContext = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__vi, container, false);
        ivipPresenter = new VIPPresenter(this);
        initView(view);
        return view;
    }

    @Override
    public void SuccessCourse(HomeBean vipBean) {
        Fragment_VIP.this.homeBean = vipBean;
        initRecyclerView();
    }

    @Override
    public void FailureCourse(String e) {
        Log.e("aa",e);

    }
    private void initNetInfo() {
        preferences = mContext.getSharedPreferences(Contants.SP, Context.MODE_PRIVATE);
        token = preferences.getString(Contants.TOKEN, "");
        Log.e("TagCourse", "==>  " + token);
        ivipPresenter.getVipData(token,mContext);

    }
    private void initRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        vipPageRecyclerView.setLayoutManager(manager);
        Adapter_VIPRecyclerView adapter_vipRecyclerView = new Adapter_VIPRecyclerView(mContext, homeBean);
        adapter_vipRecyclerView.setClikcItem(this);
        vipPageRecyclerView.setAdapter(adapter_vipRecyclerView);
    }
    private void initView(View view) {
        vipPageRecyclerView = (RecyclerView) view.findViewById(R.id.vipPageRecyclerView);
        vipPageSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.vipPageSwipeRefreshLayout);
        //设置下拉刷新回调
        vipPageSwipeRefreshLayout.setColorSchemeColors(Color.parseColor("#1CBAE5"));
        vipPageSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //刷新数据
                initNetInfo();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                vipPageSwipeRefreshLayout.setRefreshing(false);
            }
        });
        //加载数据方法
        initNetInfo();
    }

    @Override
    public void OnClikc(int i) {
        Toast.makeText(mContext, "==>" + i + "<==", Toast.LENGTH_SHORT).show();
    }
}
