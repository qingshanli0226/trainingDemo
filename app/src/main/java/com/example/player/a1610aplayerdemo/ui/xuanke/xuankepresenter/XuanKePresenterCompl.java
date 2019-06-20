package com.example.player.a1610aplayerdemo.ui.xuanke.xuankepresenter;

import com.example.player.a1610aplayerdemo.bean.XuanKeDateBean;
import com.example.player.a1610aplayerdemo.net.*;
import com.example.player.a1610aplayerdemo.util.DeviceKye;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class XuanKePresenterCompl implements XuanKeInterface.IxuankePresenter{

    private XuanKeInterface.XuanKeView xuanKeView;

    public XuanKePresenterCompl(XuanKeInterface.XuanKeView xuanKeView) {
        this.xuanKeView = xuanKeView;
    }


    @Override
    public void getXkData() {
        Map headmap = new HashMap<>();
        headmap.put("deviceKey", DeviceKye.getDeviceKye());


        RetrofitCreator.getApiService().getXuanKeDate(headmap)
                .subscribeOn(Schedulers.io())
                .map(new MyNetFunction<ResEntity<XuanKeDateBean> , XuanKeDateBean>())
                .observeOn(AndroidSchedulers.mainThread())

                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        xuanKeView.showLoading();
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        xuanKeView.hideLoading();
                    }
                })
                .subscribe(new MVPObserver<XuanKeDateBean>(){
                    @Override
                    public void onNext(XuanKeDateBean xuanKeDateBean) {
                        xuanKeView.onGetDataSuccess(xuanKeDateBean);
                    }
                });

    }

    @Override
    public void detachView() {
        xuanKeView = null;
    }
}
