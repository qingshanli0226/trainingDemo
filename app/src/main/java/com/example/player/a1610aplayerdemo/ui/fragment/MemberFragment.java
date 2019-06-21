package com.example.player.a1610aplayerdemo.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.adapter.MemberAdapter;
import com.example.player.a1610aplayerdemo.base.BaseFragment;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.net.bean.MemberBean;
import com.example.player.a1610aplayerdemo.presenter.MemberPresenter;

import com.google.gson.Gson;

import java.util.List;

public class MemberFragment extends BaseFragment implements IBaseView<String> {

    RecyclerView recyclerView;
    IBasePresenter iBasePresenter;
    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_member, container, false);
        recyclerView = view.findViewById(R.id.memberrecyc);
        iBasePresenter = new MemberPresenter();
        iBasePresenter.attachView(this);
        iBasePresenter.getData();
        return view;
    }


    @Override
    public void onLoadDataBean(String string) {
        Gson gson = new Gson();
        MemberBean memberBean = gson.fromJson(string, MemberBean.class);
        List<MemberBean.DataBean> data = memberBean.getData();
        MemberAdapter adapter= new MemberAdapter(data,getContext(),R.layout.member_item);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void onLoadError(int code, String message) {

    }
}
