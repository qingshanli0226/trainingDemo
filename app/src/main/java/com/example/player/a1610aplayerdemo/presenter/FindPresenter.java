package com.example.player.a1610aplayerdemo.presenter;

import com.example.player.a1610aplayerdemo.base.BasePresenter;
import com.example.player.a1610aplayerdemo.net.bean.HomeBean;

import java.lang.reflect.Type;

public class FindPresenter extends BasePresenter<HomeBean.DataBean> {


    @Override
    public String getAPIPath1() {
        return "loading";
    }

    @Override
    public String getAPIPath2() {
        return "getHome";
    }

    @Override
    public Type getDataType() {
        return null;
    }


}
