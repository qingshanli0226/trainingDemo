package com.example.player.a1610aplayerdemo.ui.zhuanlan.zhuanlanpresenter;

import com.example.player.a1610aplayerdemo.baseclassextraction.BasePresenter;
import com.example.player.a1610aplayerdemo.bean.ZhuanLanVideoDateBean;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.util.DeviceKye;
import com.example.player.a1610aplayerdemo.util.SpUtil;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

public class ZhuanLanVideoPresenter extends BasePresenter<ZhuanLanVideoDateBean> {

    @Override
    public String getAPIPath1() {
        return "zhuanLan";
    }

    @Override
    public String getAPIPath2() {
        return "getArticleList";
    }

    @Override
    public Type getDataType() {
        return new TypeToken<ResEntity<List<ZhuanLanVideoDateBean>>>(){}.getType();
    }
    @Override
    public HashMap<String, String> getParmams() {
        HashMap<String, String> params = new HashMap<>();

        params.put("zlId", SpUtil.getvideoid());

        params.put("page","1");

        params.put("size","20");

        return params;

    }
    @Override
    public HashMap<String, String> getHeaders() {
        HashMap<String, String> heand = new HashMap<>();
        heand.put("deviceKey", DeviceKye.getDeviceKye());
        return heand;
    }

    @Override
    public boolean isList() {
        return true;
    }
}
