package com.example.player.a1610aplayerdemo.ui.zhuanlan.zhuanlanFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.player.a1610aplayerdemo.Base_class_extraction.BaseRecyclerFragment;
import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.bean.ZhuanLanVideoDateBean;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhaunlanVideoFragment extends BaseRecyclerFragment<Object,View>{

    @Override
    public void onLoadDateBean(Object date) {
        super.onLoadDateBean(date);
        ZhuanLanVideoDateBean dateBean = (ZhuanLanVideoDateBean) date;

    }

    @Override
    public void onLoadDataList(List<Object> date) {
        super.onLoadDataList(date);
        ZhuanLanVideoDateBean dateBean = (ZhuanLanVideoDateBean) date;

        date.add(dateBean);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zhaunlan_video, container, false);
    }

}
