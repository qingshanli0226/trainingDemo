package com.example.player.a1610aplayerdemo.ui.fragment;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseFragment;
import com.example.player.a1610aplayerdemo.base.BaseView;
import com.example.player.a1610aplayerdemo.bean.VipBean;
import com.example.player.a1610aplayerdemo.ui.fragment.vip2.VipAdapter;
import com.example.player.a1610aplayerdemo.ui.fragment.vip2.VipPersenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentVip extends BaseFragment<VipBean, View> implements BaseView<VipBean> {

    VipPersenter vipPersenter = new VipPersenter();
    private VipAdapter vipAdapter;
    private RecyclerView recyclerView;

    @Override
    protected View getContentView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View view = layoutInflater.inflate(R.layout.fragment_blank_fragment02, viewGroup, false);
        vipPersenter.attachview(this);
        vipPersenter.getVipData("0", "20");
        initView(view);
        return view;
    }

    @Override
    public void onLoadData(VipBean datalist) {
        Log.d("vipsuccess", datalist.getCode() + "0");
        List<VipBean.DataBean> data = datalist.getData();
        vipAdapter = new VipAdapter(data, getContext(), R.layout.vip_item);
        recyclerView.setAdapter(vipAdapter);
    }

    @Override
    public void onLoadError(int code, String str) {
        Log.d("errorvip",str + "2");
    }

    private void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.vipf_Rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
