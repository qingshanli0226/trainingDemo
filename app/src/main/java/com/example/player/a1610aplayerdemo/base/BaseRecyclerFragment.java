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

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerFragment<T, V extends View> extends Fragment implements IBaseView<T>{
    private IBasePresenter iBasePresenter;
    private BaseRecyclerViewAdapter baseRecyclerViewAdapter;
    private List<T> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.base_recyclerview_fragment,container,false);
        initView(view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initView(View rootView){
        RecyclerView recyclerView = rootView.findViewById(R.id.base_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        baseRecyclerViewAdapter = getAdapter();
        recyclerView.setAdapter(baseRecyclerViewAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iBasePresenter = getiBasePresenter();
        iBasePresenter.attachView(this);
        iBasePresenter.getData();
    }


    @Override
    public void onLoadData(List<T> data) {
        list.clear();
        list.addAll(data);
        baseRecyclerViewAdapter.updateData(list);
    }

    @Override
    public void onLoadError(int code, String message) {

    }

    public abstract BaseRecyclerViewAdapter<T,  V> getAdapter();

    public abstract IBasePresenter getiBasePresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        iBasePresenter.detachView();
    }
}