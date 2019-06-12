package com.example.player.a1610aplayerdemo.token;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.example.player.a1610aplayerdemo.MVPApplication;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class TokenPresenter implements IBasePresenter<TokenBean> {
    IBaseView<TokenBean> iBaseView;


    @Override
    public void getData() {
        Map map = new HashMap();
        map.put("device", Build.DEVICE);
        map.put("deviceKey", getDeviceKey());
        map.put("sdkVersion", String.valueOf(Build.VERSION.SDK_INT));
        map.put("brand", Build.BRAND);
        map.put("product", Build.PRODUCT);

        RetrofitCreatorToken.getNetApiService().getToken(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TokenBean>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TokenBean tokenBean) {
                        iBaseView.onLoadData(tokenBean);
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
    public void attachView(IBaseView<TokenBean> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }

    @SuppressLint("MissingPermission")
    private String getDeviceKey() {
        String deviceKey = null;
        TelephonyManager tm = (TelephonyManager) MVPApplication.instance.getSystemService(Context.TELEPHONY_SERVICE);
        deviceKey = tm.getSimSerialNumber();
        deviceKey = Md5Utils.MD5(deviceKey);
        return deviceKey;
    }
}
