package com.example.player.a1610aplayerdemo.home.presenter;

import com.example.player.a1610aplayerdemo.base.BasePresenter;
import com.example.player.a1610aplayerdemo.home.mode.NetDataBean;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

public class NewHomePresenter extends BasePresenter<NetDataBean.DataBean> {
    @Override
    public String getAPIPath() {
        return "dish_list.php";
    }

    @Override
    public Type getDataType() {
        return new TypeToken<ResEntity<List<NetDataBean.DataBean>>>(){}.getType();
    }

    @Override
    public HashMap<String, String> getParmams() {
        HashMap<String, String> params = new HashMap<>();
        params.put("stage_id", "1");
        params.put("limit", "20");
        params.put("page", "1");
        return params;
    }

    @Override
    public boolean isList() {
        return true;
    }
}
