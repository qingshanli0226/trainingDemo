package com.example.player.a1610aplayerdemo.fragment.selectclass;


import android.content.Context;
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
public class SelectClass_Fragment extends BaseRecyclerFragment<GetHomeBean.DataBean,View > {


    public SelectClass_Fragment() {
        // Required empty public constructor
    }


    @Override
    public BaseRecyclerViewAdapter<GetHomeBean.DataBean, View> getAdapter() {
        return new BannerAdapter();
    }

    @Override
    public IBasePresenter getPresenter() {
        return new BannerPresent();
    }
}
