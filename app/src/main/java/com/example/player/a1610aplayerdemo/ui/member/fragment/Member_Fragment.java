package com.example.player.a1610aplayerdemo.ui.member.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;
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