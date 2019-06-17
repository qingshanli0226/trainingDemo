package com.example.player.a1610aplayerdemo.ui.member.fragment;

import android.view.View;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerFragment;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.ui.member.adapter.MemberAdapter;
import com.example.player.a1610aplayerdemo.ui.member.presenter.MemberPeresenter;

public class Member_Fragment extends BaseRecyclerFragment<Object,View> {

    @Override
    public BaseRecyclerViewAdapter getAdapter() {
        return new MemberAdapter();
    }

    @Override
    public IBasePresenter getiBasePresenter() {
        return new MemberPeresenter();
    }
}