package com.example.player.a1610aplayerdemo.ui.tuijian.tuijianpresenter;

import com.example.player.a1610aplayerdemo.bean.TuiJianDateBean;
import com.example.player.a1610aplayerdemo.net.MVPObserver;
import com.example.player.a1610aplayerdemo.net.MyNetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.util.DeviceKye;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class TuiJianPresenterCompl implements TuiJianInterface.ITuiJianPresenter{

    TuiJianInterface.TuiJianView tuiJianView;

    public TuiJianPresenterCompl(TuiJianInterface.TuiJianView tuiJianView) {
        this.tuiJianView = tuiJianView;
    }

    @Override
    public void  getTuiJianData(String s) {

        Map<String, String> map = new HashMap<>();
        map.put("courseId", s);
        map.put("packageId", "0");

        Map headmap = new HashMap<>();
        headmap.put("deviceKey", DeviceKye.getDeviceKye());

        RetrofitCreator.getApiService().getTuiJianDate(headmap,map)
                .subscribeOn(Schedulers.io())
                .map(new MyNetFunction<ResEntity<TuiJianDateBean>,TuiJianDateBean>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MVPObserver<TuiJianDateBean>(){
                    @Override
                    public void onNext(TuiJianDateBean vipDateBean) {
                        super.onNext(vipDateBean);

                        tuiJianView.onGetDataSuccess(vipDateBean);
                    }
                });
    }
    @Override
    public void detachView() {
       tuiJianView = null;
    }
}
