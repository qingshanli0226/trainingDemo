package com.example.player.a1610aplayerdemo.ui.tuijianpresenter;

import com.example.player.a1610aplayerdemo.Contants;
import com.example.player.a1610aplayerdemo.bean.TuiJianDateBean;
import com.example.player.a1610aplayerdemo.bean.XuanKeDateBean;
import com.example.player.a1610aplayerdemo.net.MVPObserver;
import com.example.player.a1610aplayerdemo.net.MyNetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.ui.xuankepresenter.XuanKeInterface;
import com.example.player.a1610aplayerdemo.util.DeviceKye;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class TuiJianPresenterCompl implements TuiJianInterface.ITuiJianPresenter{

    TuiJianInterface.TuiJianView xuanKeView;

    public TuiJianPresenterCompl(TuiJianInterface.TuiJianView xuanKeView) {
        this.xuanKeView = xuanKeView;
    }

    @Override
    public void getTjData(String s) {

        String wz = Contants.BASE_URL+ "course/getVideo2?courseId"+s+"&packageId=0";

        Map headmap = new HashMap<>();
        headmap.put("deviceKey", DeviceKye.getDeviceKye());


        RetrofitCreator.getApiService().getTuiJianDate(headmap,wz)
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
                .subscribe(new MVPObserver<TuiJianDateBean>(){
                    @Override
                    public void onNext(TuiJianDateBean xuanKeDateBean) {

                        xuanKeView.onGetDataSuccess(xuanKeDateBean);

                    }
                });

    }

    @Override
    public void detachView() {
        xuanKeView = null;
    }


}
