package com.example.player.a1610aplayerdemo.ui.mvvmzaixianzhibo.zhibopresenter;

import com.example.player.a1610aplayerdemo.bean.NowZhiBoDateBean;

import java.util.List;

public interface IZhiBoView {

    void onGetZhiBoList(List<NowZhiBoDateBean> zhiBoDateBeans);
    void onGetZhiBoFailed(int code, String message);
}
