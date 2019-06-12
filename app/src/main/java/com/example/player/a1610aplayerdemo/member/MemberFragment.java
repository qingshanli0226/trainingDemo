package com.example.player.a1610aplayerdemo.member;

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
import com.example.player.a1610aplayerdemo.base.BaseViewAdapter;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.member.adapter.MemberAdapter;
import com.example.player.a1610aplayerdemo.member.bean.MemberBean;
import com.example.player.a1610aplayerdemo.member.presenter.MemberPresenter;

import java.util.ArrayList;
import java.util.List;

public class MemberFragment extends Fragment implements IBaseView {
    private RecyclerView member_recycler;
    private IBasePresenter iBasePresenter;
    private List<MemberBean> list1=new ArrayList<>();
    private BaseViewAdapter baseViewAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iBasePresenter=new MemberPresenter();
        iBasePresenter.attachView(this);
        baseViewAdapter=new MemberAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_member, container, false);
        initView(view);
        iBasePresenter.getData();
        return view;
    }

    private void initView(View view) {
        member_recycler = (RecyclerView) view.findViewById(R.id.member_recycler);
    }

    @Override
    public void onLoadData(Object data) {
        List<MemberBean> list= (List<MemberBean>) data;
        this.list1.addAll(list);
        member();

    }

    private void member() {
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        baseViewAdapter.updateData(list1);
        member_recycler.setLayoutManager(manager);
        member_recycler.setAdapter(baseViewAdapter);
    }

    @Override
    public void onLoadError(String message) {

    }
}
