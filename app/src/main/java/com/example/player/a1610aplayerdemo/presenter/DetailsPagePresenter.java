package com.example.player.a1610aplayerdemo.presenter;

import com.example.player.a1610aplayerdemo.base.BasePresenter;
import com.example.player.a1610aplayerdemo.net.bean.DetailBean2;
import okhttp3.ResponseBody;

import java.lang.reflect.Type;
import java.util.HashMap;

public class DetailsPagePresenter extends BasePresenter<ResponseBody>{

    private String courseId;
    private int type;

    public DetailsPagePresenter(String courseId, int type) {
        this.courseId = courseId;
        this.type = type;
    }

    @Override
    public HashMap<String, String> getParmams() {
        HashMap<String,String> hashMap;
        if (type==2){
            hashMap = new HashMap<>();
            hashMap.put("courseId",courseId);
            hashMap.put("packageId","0");
            return hashMap;
        }
        return null;
    }

    @Override
    public String getAPIPath1() {
        if (type==2){
            return "course";
        }
        return null;
    }

    @Override
    public String getAPIPath2() {
        if (type==2){
            return "getVideo2";
        }
        return null;
    }

    @Override
    public Type getDataType() {
        if (type==2){
            return DetailBean2.class;
        }
        return null;
    }
}
