package com.example.player.a1610aplayerdemo.my.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.player.a1610aplayerdemo.MVPApplication;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.my.bean.AuthCode;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class AuthCodePresenter implements IBasePresenter<AuthCode> {
    private IBaseView<AuthCode> iBaseView;
    SharedPreferences sp;


    @Override
    public void getData() {
        sp = MVPApplication.instance.getSharedPreferences("phone",Context.MODE_PRIVATE);
        String s1 = sp.getString("phonenumber","空值");

        Map map = new HashMap();
        map.put("messageType", "1");
        map.put("mobilePhone", s1);

        RetrofitCreator.getNetApiService().getAuthCodeData(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AuthCode>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AuthCode authCode) {
                        iBaseView.onLoadData(authCode);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iBaseView.onLoadError(1,e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachView(IBaseView<AuthCode> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}
