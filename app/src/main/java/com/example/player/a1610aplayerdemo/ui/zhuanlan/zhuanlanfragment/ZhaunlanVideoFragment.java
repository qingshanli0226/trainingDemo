package com.example.player.a1610aplayerdemo.ui.zhuanlan.zhuanlanfragment;


import android.support.v4.app.Fragment;
import android.view.View;

import com.example.player.a1610aplayerdemo.baseclassextraction.BaseRecyclerFragment;
import com.example.player.a1610aplayerdemo.baseclassextraction.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.baseclassextraction.IBasePresenter;
import com.example.player.a1610aplayerdemo.bean.ZhuanLanVideoDateBean;
import com.example.player.a1610aplayerdemo.ui.zhuanlan.ZhuanLanVideoAdp;
import com.example.player.a1610aplayerdemo.ui.zhuanlan.zhuanlanpresenter.ZhuanLanVideoPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhaunlanVideoFragment extends BaseRecyclerFragment<ZhuanLanVideoDateBean,View>{

    @Override
    public BaseRecyclerViewAdapter<ZhuanLanVideoDateBean, View> getAdapter() {
        return  new ZhuanLanVideoAdp();
    }
    @Override
    public IBasePresenter getPresenter() {
        return new ZhuanLanVideoPresenter();
    }
}
