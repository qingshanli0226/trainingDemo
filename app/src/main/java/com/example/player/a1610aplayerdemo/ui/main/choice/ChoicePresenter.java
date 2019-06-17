package com.example.player.a1610aplayerdemo.ui.main.choice;

import android.util.Log;
import com.example.player.a1610aplayerdemo.Constant;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.Bean;
import com.example.player.a1610aplayerdemo.bean.MainBean;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.utils.TokenSp;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class ChoicePresenter implements IBasePresenter<MainBean> {

    IBaseView<MainBean> iBaseView;

    @Override
    public void getData() {
        String token = TokenSp.getInstance().getToken();
        Log.e("123456", "getData: "+token);
        Map<String, String> map = new HashMap<>();
        map.put("Android-channel", "guoyun");
        map.put("Android-VersionCode", "43");
        map.put("DeviceKey", Constant.DeviceKey);
        map.put("Tingyun_Process", "true");
        map.put("CH-TOKEN", token);
        RetrofitCreator.getInstance().getIServiceApi().getMainData(map,Constant.BASE + "restapi/loading/getHome")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Bean<MainBean>, MainBean>() {
                    @Override
                    public MainBean apply(Bean<MainBean> mainBeanBean) throws Exception {
                        return mainBeanBean.getData();
                    }
                }).subscribe(new Observer<MainBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MainBean mainBean) {
                iBaseView.onLoadDataObject(mainBean);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("ChoicePresenter", e.toString());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void attachView(IBaseView<MainBean> iBaseView) {
        this.iBaseView = iBaseView;
    }




    @Override
    public void detachView() {
        iBaseView = null;
    }
}
