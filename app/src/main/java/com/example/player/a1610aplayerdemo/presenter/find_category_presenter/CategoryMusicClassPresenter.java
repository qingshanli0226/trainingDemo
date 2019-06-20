package com.example.player.a1610aplayerdemo.presenter.find_category_presenter;

import com.example.player.a1610aplayerdemo.base.BasePresenter;
import com.example.player.a1610aplayerdemo.bean.MusicClassBean;

import java.lang.reflect.Type;
import java.util.HashMap;

public class CategoryMusicClassPresenter extends BasePresenter<MusicClassBean.DataBean>{
    @Override
    public String getAPIPath1() {
        return "category";
    }

    @Override
    public String getAPIPath2() {
        return "getPerfesional";
    }

    @Override
    public Type getDataType() {
        return MusicClassBean.class;
    }

    @Override
    public HashMap<String, String> getParmams() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("pid","1");
        return hashMap;
    }
}
