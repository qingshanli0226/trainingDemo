package com.example.player.a1610aplayerdemo.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseRecyclerFragment<T, V extends View> extends Fragment implements IBaseView<T> {
    private IBasePresenter iBasePresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initView();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initView() {
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {
        iBasePresenter = getPresenter();
        iBasePresenter.getData();
    }


    public abstract BaseRecyclerViewAdapter<T, V> getAdapter();

    public abstract IBasePresenter getPresenter();
}
