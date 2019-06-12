package com.example.player.a1610aplayerdemo.home.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.home.adapter.HomeAdapter;
import com.example.player.a1610aplayerdemo.home.bean.HomeBean;
import com.example.player.a1610aplayerdemo.home.presenter.HomePeresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Home_Fragment extends Fragment implements IBaseView {
    private IBasePresenter iBasePresenter;
    private List<HomeBean.DataBean> list = new ArrayList<>();
    private HomeAdapter adapter;
    private XRecyclerView xr;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.home_fragment, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iBasePresenter = new HomePeresenter();
        iBasePresenter.attachView(this);
        iBasePresenter.getData();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onLoadData(Object data) {
        list.add((HomeBean.DataBean) data);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        xr.setLayoutManager(manager);
        adapter = new HomeAdapter(getContext(), (HomeBean.DataBean) data);
        xr.setAdapter(adapter);
        Log.i("aaa", "" + list.get(0).getHomeBanner().size());
    }

    @Override
    public void onLoadError(int code, String message) {
        Log.i("error", message);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        iBasePresenter.detachView();
    }

    private void initView(View view) {
        xr = (XRecyclerView) view.findViewById(R.id.xr);
    }
}