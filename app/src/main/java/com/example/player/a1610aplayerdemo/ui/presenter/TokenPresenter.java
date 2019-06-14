package com.example.player.a1610aplayerdemo.ui.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.example.player.a1610aplayerdemo.base.ResEntity;
import com.example.player.a1610aplayerdemo.commit.MyApplication;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.net.SP;
import com.example.player.a1610aplayerdemo.ui.AccountManager;
import com.example.player.a1610aplayerdemo.ui.bean.Bean;
import com.example.player.a1610aplayerdemo.utils.Md5Utils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class TokenPresenter implements TokenContract.ITokenUserInfo {
    private TokenContract.ITokenInfoStatus iTokenInfoStatus;

    @SuppressLint("MissingPermission")
    private String getDeviceKey() {
        String deviceKey = null;
        TelephonyManager tm = (TelephonyManager) MyApplication.instance.getSystemService(Context.TELEPHONY_SERVICE);
        deviceKey = tm.getSimSerialNumber();
        deviceKey = Md5Utils.MD5(deviceKey);
        return deviceKey;
    }
    @Override
    public void getInfo() {
        Log.i("TagA", "设备：" + Build.DEVICE);
        Log.i("TagA", "设备的key：" + getDeviceKey());
        Log.i("TagA", "系统版本：" + String.valueOf(Build.VERSION.SDK_INT));
        Log.i("TagA", "品牌：" + Build.BOARD);
        Log.i("TagA", "产品型号：" + Build.PRODUCT);

        Map<String, String> map = new HashMap();
        map.put("device", Build.DEVICE);
        map.put("deviceKey", getDeviceKey());
        map.put("sdkVersion", String.valueOf(Build.VERSION.SDK_INT));
        map.put("brand", Build.BRAND);
        map.put("product", Build.PRODUCT);

        RetrofitCreator.getMyServiceInterface().getUser(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResEntity<Bean.DataBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResEntity<Bean.DataBean> beanResEntity) {
                        if (beanResEntity.getData() != null){
                            SP.Tokens(beanResEntity.getData().getAccessToken());
                        }else {
                            return;
                        }

//                        AccountManager.getInstance().setCurrentUser(beanResEntity.getData());
//                        AccountManager.getInstance().SaveToken(beanResEntity.getData().getAccessToken());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}