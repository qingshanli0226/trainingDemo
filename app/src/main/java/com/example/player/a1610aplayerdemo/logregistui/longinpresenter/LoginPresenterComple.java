package com.example.player.a1610aplayerdemo.logregistui.longinpresenter;

import com.example.player.a1610aplayerdemo.baseclassextraction.BasePresenter;
import com.example.player.a1610aplayerdemo.baseclassextraction.BasePresenterPost;
import com.example.player.a1610aplayerdemo.baseclassextraction.IBaseView;
import com.example.player.a1610aplayerdemo.bean.LogDateBean;
import com.example.player.a1610aplayerdemo.bean.NowZhiBoDateBean;
import com.example.player.a1610aplayerdemo.ui.mvvmzaixianzhibo.mvvmbase.BaseMode;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginPresenterComple extends BasePresenterPost<LogDateBean> {
    @Override
    public String getAPIPath1() {
        return "account";
    }
    @Override
    public String getAPIPath2() {
        return "signIn";
    }
    @Override
    public Type getDataType() {
        return new TypeToken<List<LogDateBean>>(){}.getType();
    }
    @Override
    public HashMap<String, String> getHeaders() {
        HashMap<String, String> map = new HashMap<>();

        map.put("Android-VersionCode", "43");
        map.put("Accept-Encoding", "gzip");
        map.put("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 5.1.1; sm-j700f Build/LMY47I)");
        map.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        map.put("Android-channel", "guoyun");
        map.put("Host", "api.immedc.com");
        map.put("Tingyun_Process", "true");
        return map;
    }

    @Override
    public HashMap<String, String> getParmams() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("loginName","13295291664");
        hashMap.put("password","sxz1318855657");

        return hashMap;
    }

    @Override
    public boolean isList() {
        return false;
    }
}
