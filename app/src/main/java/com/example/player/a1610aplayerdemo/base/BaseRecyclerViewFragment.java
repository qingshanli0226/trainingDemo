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


    protected View view;
    protected BaseRecyclerViewAdapter baseRecyclerViewAdapter;
    protected IBasePresenter iBasePresenter;
    protected  DivToolbar toolbar;
    protected  RecyclerView recyclerView;
    public BaseRecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void initData() {
        iBasePresenter.getData();//通过presenter去获取数据
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_base_recycler_view, container, false);
        iBasePresenter = getPresenter();
        iBasePresenter.attachView(this);//在这里让presenter绑定view
        initData();
        toolbar = view.findViewById(R.id.toolbar);
        recyclerView  = view.findViewById(R.id.rv);
        initToobar();//子类可重写自己界面的toolbar
        initView();
        return view;
    }

    protected abstract void initToobar();


    //需要子类来提供适配器
    public abstract BaseRecyclerViewAdapter <T ,V> getAdapter();
    //需要子类来提供获取数据源的接口
    public abstract IBasePresenter getPresenter();

    /**
     * 初始化RecyclerView
     */
    protected void initView() {
        setRecyclerViewManager();   //子类不重写该方法默认LinearLayoutManager竖向排列
        baseRecyclerViewAdapter = getAdapter();
        recyclerView.setAdapter(baseRecyclerViewAdapter);
    }
    //向子类提空重写RecyclerView布局方向的方法
    protected void setRecyclerViewManager() {
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    //集合刷新适配器
    @Override
    public void onLoadData(List<T> data) {
        baseRecyclerViewAdapter.refreshData(data);
    }

    //对象刷新适配器
    @Override
    public void onLoadObject(T data) {
//        baseRecyclerViewAdapter.
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
