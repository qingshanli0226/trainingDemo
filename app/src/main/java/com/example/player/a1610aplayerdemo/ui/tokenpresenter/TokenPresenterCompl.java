package com.example.player.a1610aplayerdemo.ui.tokenpresenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.example.player.a1610aplayerdemo.MyApp;
import com.example.player.a1610aplayerdemo.bean.TokenDateBean;
import com.example.player.a1610aplayerdemo.bean.VipDateBean;
import com.example.player.a1610aplayerdemo.net.MVPObserver;
import com.example.player.a1610aplayerdemo.net.MyNetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.ui.vippresenter.VipInterface;
import com.example.player.a1610aplayerdemo.util.Md5Utils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static android.support.v4.content.ContextCompat.getSystemService;

public class TokenPresenterCompl implements TokenInterface.ItokenPresenter {

  private TokenInterface.TokenView tokenView;

    public TokenPresenterCompl(TokenInterface.TokenView tokenView) {
        this.tokenView = tokenView;
    }

    @Override
    public void getTokenData() {
        Log.i("TagA", "设备:" + Build.DEVICE);
        Log.i("TagA", "设备的key:" + getDeviceKey());
        Log.i("TagA", "系统版本:" + String.valueOf(Build.VERSION.SDK_INT));
        Log.i("TagA", "品牌:" + Build.BRAND);
        Log.i("TagA", "产品型号:" + Build.PRODUCT);

        Map map = new HashMap();
        map.put("device", Build.DEVICE);
        map.put("deviceKey", getDeviceKey());
        map.put("sdkVersion", String.valueOf(Build.VERSION.SDK_INT));
        map.put("brand", Build.BRAND);
        map.put("product", Build.PRODUCT);

        Log.d("lmz","22");
        RetrofitCreator.getApiService().getFirstInAndGetToken(map)
                .subscribeOn(Schedulers.io())

                .map(new MyNetFunction<ResEntity<TokenDateBean>,TokenDateBean>())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        tokenView.showLoading();
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        tokenView.hideLoading();
                    }
                })
                .subscribe(new MVPObserver<TokenDateBean>(){
                    @Override
                    public void onNext(TokenDateBean vipDateBean) {
                        super.onNext(vipDateBean);

                        Log.d("xxx",vipDateBean.toString());
                        tokenView.onGetDataSuccess(vipDateBean);


                    }
                });
    }

    @SuppressLint("MissingPermission")
    private String getDeviceKey() {
        String deviceKey = null;
        TelephonyManager tm = (TelephonyManager) MyApp.instance.getSystemService(Context.TELEPHONY_SERVICE);
        deviceKey = tm.getSimSerialNumber();
        deviceKey = Md5Utils.MD5(deviceKey);
        return deviceKey;
    }

    @Override
    public void detachView() {
        tokenView = null;
    }
}
