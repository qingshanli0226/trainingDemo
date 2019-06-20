package com.example.player.a1610aplayerdemo.ui.masterClazz.masterpresenter;

import com.example.player.a1610aplayerdemo.bean.MasterDateBean;
import com.example.player.a1610aplayerdemo.net.MVPObserver;
import com.example.player.a1610aplayerdemo.net.MyNetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.util.DeviceKye;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;
public class MasterPresenterCompl implements MasterInterface.IMasterPresenter{
    MasterInterface.MasterView tuiJianView;
    public MasterPresenterCompl(MasterInterface.MasterView tuiJianView) {
        this.tuiJianView = tuiJianView;
    }
    @Override
    public void  getMasterData(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("liveId", s);

        Map headmap = new HashMap<>();
        headmap.put("deviceKey", DeviceKye.getDeviceKye());

        RetrofitCreator.getApiService().getTuiJianDate(headmap,map)
                .subscribeOn(Schedulers.io())
                .map(new MyNetFunction<ResEntity<MasterDateBean>,MasterDateBean>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MVPObserver<MasterDateBean>(){
                    @Override
                    public void onNext(MasterDateBean vipDateBean) {
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
