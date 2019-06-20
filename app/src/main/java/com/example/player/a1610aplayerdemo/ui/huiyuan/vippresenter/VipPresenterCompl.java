package com.example.player.a1610aplayerdemo.ui.huiyuan.vippresenter;

import com.example.player.a1610aplayerdemo.bean.VipDateBean;
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
import java.util.List;
import java.util.Map;

public class VipPresenterCompl implements VipInterface.IvipPresenter{

    private VipInterface.VipView vipView;

    public VipPresenterCompl(VipInterface.VipView vipView) {
        this.vipView = vipView;
    }

    @Override
    public void getVipData() {

        Map headmap = new HashMap<>();
        headmap.put("deviceKey", DeviceKye.getDeviceKye());

        RetrofitCreator.getApiService().getVipDate(headmap)
                .subscribeOn(Schedulers.io())
                .map(new MyNetFunction<ResEntity<List<VipDateBean>>,List<VipDateBean>>())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        vipView.showLoading();
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        vipView.hideLoading();
                    }
                })
                .subscribe(new MVPObserver<List<VipDateBean>>(){
                    @Override
                    public void onNext(List<VipDateBean> vipDateBean) {
                        super.onNext(vipDateBean);

                        vipView.onGetDataSuccess(vipDateBean);
                    }
                });
    }
    @Override
    public void detachView() {
        vipView = null;
    }
}
