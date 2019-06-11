package com.example.player.a1610aplayerdemo.mian.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.example.player.a1610aplayerdemo.AccountManager;
import com.example.player.a1610aplayerdemo.MyApp;
import com.example.player.a1610aplayerdemo.mian.bean.UserBean;
import com.example.player.a1610aplayerdemo.net.CreatorRetorfitApi;
import com.example.player.a1610aplayerdemo.utils.Md5Utils;
import com.google.gson.Gson;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.HashMap;

public class MainPresenterComple implements MainContract.IMainGetUserInfo {
    private MainContract.IMainUserInfoStatus iMainUserInfoStatus;

    @SuppressLint("MissingPermission")
    private String getDeviceKey() {
        String deviceKey = null;
        TelephonyManager tm = (TelephonyManager) MyApp.instance.getSystemService(Context.TELEPHONY_SERVICE);
        deviceKey = tm.getSimSerialNumber();
        deviceKey = Md5Utils.MD5(deviceKey);
        return deviceKey;
    }

    @Override
    public void getUserInfo() {
        Log.i("TagA", "设备:" + Build.DEVICE);
        Log.i("TagA", "设备的key:" + getDeviceKey());
        Log.i("TagA", "系统版本:" + String.valueOf(Build.VERSION.SDK_INT));
        Log.i("TagA", "品牌:" + Build.BRAND);
        Log.i("TagA", "产品型号:" + Build.PRODUCT);


        HashMap<String,String>  params = new HashMap<>();
        params.put("device", Build.DEVICE);
        params.put("deviceKey",getDeviceKey());
        params.put("sdkVersion", String.valueOf(Build.VERSION.SDK_INT));
        params.put("brand", Build.BRAND);
        params.put("product", Build.PRODUCT);

        CreatorRetorfitApi.getiRetrofitApiSerice().getUserInfo(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Gson gson = new Gson();
                            UserBean bean = gson.fromJson(string, UserBean.class);
                            Log.d("Mh", bean.getData().getAccessToken());
                            AccountManager.getInstance().setCurrentUser(bean);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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
