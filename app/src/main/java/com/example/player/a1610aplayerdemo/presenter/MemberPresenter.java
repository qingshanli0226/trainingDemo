package com.example.player.a1610aplayerdemo.presenter;

import android.util.Log;
import com.example.player.a1610aplayerdemo.base.BasePresenter;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.MemberBean;
import com.example.player.a1610aplayerdemo.service.BaseService;
import com.example.player.a1610aplayerdemo.util.CreatorUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

import java.io.IOException;
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
