package com.example.player.a1610aplayerdemo.token;

import android.content.Context;
import android.os.Build;
import android.telecom.TelecomManager;
import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.discover.bean.DiscoverBean;
import com.example.player.a1610aplayerdemo.net.NetWorkCreator;
import com.example.player.a1610aplayerdemo.url.NetFunction;
import com.example.player.a1610aplayerdemo.url.ResEntity;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;

public class TokenPresenter implements IBasePresenter<TokenBean> {
    IBaseView<TokenBean> iBaseView;
    @Override
    public void getData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("device", Build.DEVICE);
        map.put("deviceKey",TokenUtils.getDeviceKey());
        int sdk=Build.VERSION.SDK_INT;
        map.put("sdkVersion",sdk+"");
        map.put("brand",Build.BOARD);
        map.put("product",Build.PRODUCT);
        NetWorkCreator.getNetWorkService().getTokenData(map)
                .subscribeOn(Schedulers.io())
                .map(new NetFunction<ResEntity<TokenBean>, TokenBean>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TokenBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TokenBean bean) {
                        Log.i("aaa",bean.getAccessToken());
                        iBaseView.onLoadData(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachView(IBaseView<TokenBean> iBaseView) {
        this.iBaseView=iBaseView;
    }
    @Override
    public void detachView() {
        iBaseView=null;
    }
}
