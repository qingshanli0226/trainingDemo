package com.example.player.a1610aplayerdemo.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseView;
import com.example.player.a1610aplayerdemo.bean.VipBean;
import com.example.player.a1610aplayerdemo.vip.VipAdapter;
import com.example.player.a1610aplayerdemo.vip.VipPresenter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment02 extends Fragment implements BaseView<VipBean> {

    private VipPresenter presenter;
    private RecyclerView vipf_Rv;
    private Context context;

    public BlankFragment02() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment02, container, false);

        presenter = new VipPresenter(this);
        presenter.getVipData("0", "20");


        initView(view);
        return view;
    }

    @Override
    public void onLoadData(VipBean datalist) {
        Log.d("sxx", "" + datalist.getCode());
        List<VipBean.DataBean> data = datalist.getData();
        VipAdapter vipAdapter = new VipAdapter(data, context);
        vipf_Rv.setAdapter(vipAdapter);


    }

    @Override
    public void onLoadError(int code, String str) {
        Log.d("errorvipf",""+str);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destoryView();
    }

    private void initView(View view) {
        vipf_Rv = (RecyclerView) view.findViewById(R.id.vipf_Rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        vipf_Rv.setLayoutManager(linearLayoutManager);

    }
}
