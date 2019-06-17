package com.example.player.a1610aplayerdemo.interface2.presenter;

import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.interface2.interface2bean.InterfaceBean;
import com.example.player.a1610aplayerdemo.net.NetWorkCreator;
import com.example.player.a1610aplayerdemo.url.NetFunction;
import com.example.player.a1610aplayerdemo.url.ResEntity;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class InterFacePresenter implements IBasePresenter<InterfaceBean> {
    private IBaseView<InterfaceBean> iBaseView;
    private String url;

    public InterFacePresenter(String url) {
        this.url = url;
    }

    @Override
    public void getData() {
        Log.i("abb",url);
        Map<String,String> map=new HashMap<>();
        map.put("liveId",url);
        NetWorkCreator.getNetWorkService().getInterface(map)
                .subscribeOn(Schedulers.io())
                .map(new NetFunction<ResEntity<InterfaceBean>,InterfaceBean>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InterfaceBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(InterfaceBean memberBeans) {
                        Log.i("abb",memberBeans.getRoomTitle());
                        iBaseView.onLoadData(memberBeans);
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
    public void attachView(IBaseView<InterfaceBean> iBaseView) {
        this.iBaseView=iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView=null;
    }
}
