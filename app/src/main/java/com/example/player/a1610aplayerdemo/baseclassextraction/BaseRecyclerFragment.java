package com.example.player.a1610aplayerdemo.baseclassextraction;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;

import java.util.List;

public abstract class BaseRecyclerFragment<T,V extends View> extends Fragment implements IBaseView<T>{
    private IBasePresenter iBasePresenter;
    private  BaseRecyclerViewAdapter baseRecyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.base_recyclerview_fragment, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        RecyclerView recyclerView = rootView.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        baseRecyclerViewAdapter = getAdapter();
        recyclerView.setAdapter(baseRecyclerViewAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iBasePresenter = getPresenter();
        iBasePresenter.attachView(this);
        initData();
        initDatatwo();
    }

    private void initDatatwo() {

    }

    private  void initData(){
        iBasePresenter.loadDataByGet();
    };

    public abstract BaseRecyclerViewAdapter<T,V> getAdapter();

    public abstract IBasePresenter getPresenter();

    @Override
    public void onLoadDataList(List<T> date) {
        baseRecyclerViewAdapter.updateData(date);
    }

    @Override
    public void onLoadDateBean(T date) { }
    @Override
    public void onLoadEeeor(int code, String message) { }

    @Override
    public void onDestroy() {
        super.onDestroy();
        iBasePresenter.detachView();
    }
}
