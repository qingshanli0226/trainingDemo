package com.example.player.a1610aplayerdemo.my.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.player.a1610aplayerdemo.MVPApplication;
import com.example.player.a1610aplayerdemo.base.IBasePresenterTwo;
import com.example.player.a1610aplayerdemo.base.IBaseViewTwo;
import com.example.player.a1610aplayerdemo.my.bean.AuthCode;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class NextPresenter implements IBasePresenterTwo<AuthCode> {
    private IBaseViewTwo<AuthCode> iBaseView;
    SharedPreferences sp;


    @Override
    public void getData() {
        sp = MVPApplication.instance.getSharedPreferences("phoneuser",Context.MODE_PRIVATE);
        String s1 = sp.getString("token","空值");
        String s2 = sp.getString("identifyingCode","空值");
        String s3 = sp.getString("loginName","空值");


        Map map = new HashMap();
        map.put("token", s1);
        map.put("identifyingCode", s2);
        map.put("loginName",s3);

        RetrofitCreator.getNetApiService().getAuthCodeDataTwo(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AuthCode>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AuthCode authCode) {
                        iBaseView.onLoadDataT(authCode);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iBaseView.onLoadErrorT(1,e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachView(IBaseViewTwo<AuthCode> iBaseView) {

        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}
