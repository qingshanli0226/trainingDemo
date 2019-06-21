package com.example.player.a1610aplayerdemo.ui.home.homeactivity.zllistactivity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.ui.home.homeactivity.zllistactivity.adapter.ZlListRightAdapter;
import com.example.player.a1610aplayerdemo.ui.home.homeactivity.zllistactivity.bean.ZlListRightBean;
import com.example.player.a1610aplayerdemo.ui.home.homeactivity.zllistactivity.presenter.ZlListRightPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Right_Framgent extends Fragment implements IBaseView {
    private IBasePresenter iBasePresenter;
    private ZlListRightAdapter adapter;
    private List<ZlListRightBean.DataBean> list = new ArrayList<>();
    private XRecyclerView zllistrightXrv;
    private SwipeRefreshLayout vv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.homefour_fragmentright, container, false);
        initView(view);
        adapter = new ZlListRightAdapter();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        zllistrightXrv.setLayoutManager(manager);
        zllistrightXrv.setAdapter(adapter);
        vv.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                vv.setEnabled(false);
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getActivity().getIntent();
        String id = intent.getStringExtra("id");
        iBasePresenter = new ZlListRightPresenter(id);
        iBasePresenter.attachView(this);
        iBasePresenter.getData();
    }

    @Override
    public void onLoadData(List data) {
        list.addAll(data);
        adapter.updata(getContext(), list);
    }

    @Override
    public void onLoadError(int code, String message) {

    }

    @Override
    public void onLoadObject(Object data) {

    }

    private void initView(View view) {
        zllistrightXrv = (XRecyclerView) view.findViewById(R.id.zllistright_xrv);
        vv = (SwipeRefreshLayout) view.findViewById(R.id.vv);
    }
}