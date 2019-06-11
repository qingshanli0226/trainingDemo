package com.example.player.a1610aplayerdemo.fragment.member;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerFragment;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Member_Fragment extends BaseRecyclerFragment<Bean_Member.DataBean,View> {

    @Override
    public BaseRecyclerViewAdapter<Bean_Member.DataBean, View> getAdapter() {
        return new MemberAdapter();
    }

    @Override
    public IBasePresenter getPresenter() {
        return new MemberPresenter();
    }

}
