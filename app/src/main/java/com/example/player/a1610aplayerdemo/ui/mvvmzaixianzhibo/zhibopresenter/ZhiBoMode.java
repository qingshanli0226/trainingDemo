package com.example.player.a1610aplayerdemo.ui.mvvmzaixianzhibo.zhibopresenter;

import com.example.player.a1610aplayerdemo.ui.mvvmzaixianzhibo.mvvmbase.BaseMode;
import com.example.player.a1610aplayerdemo.bean.NowZhiBoDateBean;
import com.example.player.a1610aplayerdemo.util.DeviceKye;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

public class ZhiBoMode extends BaseMode<List<NowZhiBoDateBean>> {
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
         return new TypeToken<List<NowZhiBoDateBean>>(){}.getType();
    }

    @Override
    public HashMap<String, String> getParmams() {
        HashMap<String, String> params = new HashMap<>();
        params.put("grade", "0");
        params.put("page", "1");
        params.put("size", "20");
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
