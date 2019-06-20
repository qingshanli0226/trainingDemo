package com.example.player.a1610aplayerdemo.ui.tokenpresenter;

import android.os.Build;
import android.util.Log;
import com.example.player.a1610aplayerdemo.bean.TokenDateBean;
import com.example.player.a1610aplayerdemo.net.MVPObserver;
import com.example.player.a1610aplayerdemo.net.MyNetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.util.DeviceKye;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class TokenPresenterCompl implements TokenInterface.ItokenPresenter {

  private TokenInterface.TokenView tokenView;

    public TokenPresenterCompl(TokenInterface.TokenView tokenView) {
        this.tokenView = tokenView;
    }

    @Override
    public void getTokenData() {
        Log.i("TagA", "设备:" + Build.DEVICE);
        Log.i("TagA", "设备的key:" + DeviceKye.getDeviceKye());
        Log.i("TagA", "系统版本:" + String.valueOf(Build.VERSION.SDK_INT));
        Log.i("TagA", "品牌:" + Build.BRAND);
        Log.i("TagA", "产品型号:" + Build.PRODUCT);

        Map map = new HashMap();
        map.put("device", Build.DEVICE);
        map.put("deviceKey", DeviceKye.getDeviceKye());
        map.put("sdkVersion", String.valueOf(Build.VERSION.SDK_INT));
        map.put("brand", Build.BRAND);
        map.put("product", Build.PRODUCT);

        Map headmap = new HashMap<>(map);

        headmap.put("deviceKey",DeviceKye.getDeviceKye());

        Log.d("lmz","22");
        RetrofitCreator.getApiService().getFirstInAndGetToken(headmap,map)
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



    @Override
    public void detachView() {
        tokenView = null;
    }
}
