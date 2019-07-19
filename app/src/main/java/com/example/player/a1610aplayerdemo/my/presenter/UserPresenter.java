package com.example.player.a1610aplayerdemo.my.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.example.player.a1610aplayerdemo.MVPApplication;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.mistake.ErrorUtil;
import com.example.player.a1610aplayerdemo.mistake.NetFunction;
import com.example.player.a1610aplayerdemo.mistake.ResEntity;
import com.example.player.a1610aplayerdemo.my.bean.UserBean;
import com.example.player.a1610aplayerdemo.net.RetrofitCreatorUser;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class UserPresenter implements IBasePresenter<UserBean> {
    private IBaseView<UserBean> iBaseView;
    SharedPreferences sp;

    @Override
    public void getData() {
        sp = MVPApplication.instance.getSharedPreferences("userinfo",Context.MODE_PRIVATE);
        String s1 = sp.getString("loginName","空值");
        String s2 = sp.getString("password","空值");

        Map map = new HashMap();
        map.put("password", s2);
        map.put("loginName", s1);

//        String token = SpUtils.getSpUtils().getToken();
//        headMap.put(Contant.CH_TOKEN,token);
//        headMap.put("DeviceKey", Contant.DEVICEKEY);
//        headMap.put("Android-VersionCode","43");
//        headMap.put("Android-channel","guoyun");
//        headMap.put("Tingyun_Process","true");
//        headMap.put("Content-Type","application/x-www-form-urlencoded");
//        headMap.put("charset","UTF-8");
//        headMap.put("User-Agent","Dalvik/2.1.0 (Linux; U; Android 5.1.1; redmi note 3 Build/LMY47I)");


        RetrofitCreatorUser.getNetApiService().getUserData(map)
                .subscribeOn(Schedulers.io())
                .map(new NetFunction<ResEntity<UserBean>,UserBean>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        iBaseView.onLoadData(userBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("wwww",e.getMessage());
                        ErrorUtil.handleError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void attachView(IBaseView<UserBean> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}
