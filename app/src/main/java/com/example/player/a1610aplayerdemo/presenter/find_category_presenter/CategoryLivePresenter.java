package com.example.player.a1610aplayerdemo.presenter.find_category_presenter;

import com.example.player.a1610aplayerdemo.base.BasePresenter;
import com.example.player.a1610aplayerdemo.bean.LiveBean;
import com.example.player.a1610aplayerdemo.bean.MusicClassBean;

import java.lang.reflect.Type;
import java.util.HashMap;

public class CategoryLivePresenter extends BasePresenter<LiveBean.DataBean>{
    @Override
    public String getAPIPath1() {
        return "live";
    }

    @Override
    public String getAPIPath2() {
        return "getMasterlives";
    }

    @Override
    public Type getDataType() {
        return LiveBean.class;
    }

    @Override
    public HashMap<String, String> getParmams() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("grade","0");
        hashMap.put("page","1");
        hashMap.put("size","20");
        return hashMap;
    }
}
