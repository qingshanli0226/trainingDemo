package com.example.player.a1610aplayerdemo.base;

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

public abstract class BaseRecyclerViewFragment<T,v extends View> extends Fragment implements IBaseView<T> {
    protected View view;
    protected BaseRecyclerViewAdapter baseRecyclerViewAdapter;
    protected IBasePresenter iBasePresenter;
    protected RecyclerView recyclerView;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iBasePresenter=getPresenter();
        iBasePresenter.attchView(this);
        initdata();
    }

    private void initdata() {
        iBasePresenter.loadDataByGet();
    }

    public abstract IBasePresenter getPresenter();
    public abstract BaseRecyclerViewAdapter<T,v> getAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_base_recyclerview,container,false);
        recyclerView=view.findViewById(R.id.rv);
        initView();
        return view;
    }

    public  void initView(){
        setRecyclerViewManager();
        baseRecyclerViewAdapter=getAdapter();
        recyclerView.setAdapter(baseRecyclerViewAdapter);
    }

    protected void setRecyclerViewManager(){
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }



    @Override
    public void onLoadDataList(List<T> data) {
            baseRecyclerViewAdapter.refresh(data);
    }

    @Override
    public void onloadDataBean(T data) {

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
