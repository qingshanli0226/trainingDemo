package com.example.player.a1610aplayerdemo.presenter;

import com.example.player.a1610aplayerdemo.base.BasePresenter;
import com.example.player.a1610aplayerdemo.net.bean.MemberBean;

import java.lang.reflect.Type;
import java.util.HashMap;

public class MemberPresenter extends BasePresenter<MemberBean.DataBean> {


    @Override
    public String getAPIPath1() {
        return "masterPackage";
    }

    @Override
    public String getAPIPath2() {
        return "getMasterPackagelist";
    }

    @Override

    public HashMap<String, String> getParmams() {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("minid","0");
        hashMap.put("size","20");
        return hashMap;
    }

    @Override
    public Type getDataType() {
        return MemberBean.class;
    }
}
