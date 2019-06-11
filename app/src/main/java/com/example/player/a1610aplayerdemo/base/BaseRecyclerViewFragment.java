package com.example.player.a1610aplayerdemo.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseRecyclerViewFragment<T , V extends View> extends Fragment implements IBaseView<T> {


    private View view;
    private BaseRecyclerViewAdapter baseRecyclerViewAdapter;
    private IBasePresenter iBasePresenter;

    public BaseRecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iBasePresenter = getPresenter();
        iBasePresenter.attachView(this);//在这里让presenter绑定view
        initData();
    }

    private void initData() {
        iBasePresenter.getData();//通过presenter去获取数据
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_base_recycler_view, container, false);
        initView();
        return view;
    }


    //需要子类来提供适配器
    public abstract BaseRecyclerViewAdapter <T ,V> getAdapter();
    //需要子类来提供获取数据源的接口
    public abstract IBasePresenter getPresenter();
    /**
     * 初始化RecyclerView
     */
    private void initView() {
        RecyclerView recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        baseRecyclerViewAdapter = getAdapter();
        recyclerView.setAdapter(baseRecyclerViewAdapter);
    }


    @Override
    public void onLoadData(List<T> data) {
        baseRecyclerViewAdapter.refreshData(data);
    }

    @Override
    public void onLoadError(int code, String message) {

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        iBasePresenter.detachView();
    }
}
