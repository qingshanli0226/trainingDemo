package com.example.player.a1610aplayerdemo.interface2.presenter;

import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.interface2.interface2bean.InterfaceBean;
import com.example.player.a1610aplayerdemo.interface2.interface2bean.InterfaceBean2;
import com.example.player.a1610aplayerdemo.net.NetWorkCreator;
import com.example.player.a1610aplayerdemo.url.NetFunction;
import com.example.player.a1610aplayerdemo.url.ResEntity;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class Interface2Presenter implements IBasePresenter<InterfaceBean2> {
    private IBaseView<InterfaceBean2> iBaseView;
    private String url;

    public Interface2Presenter(String url) {
        this.url = url;
    }

    @Override
    public void getData() {
        Map<String,String> map=new HashMap<>();
        map.put("courseId",url);
        map.put("paceageId",0+"");
        NetWorkCreator.getNetWorkService().getInterface2(map)
                .subscribeOn(Schedulers.io())
                .map(new NetFunction<ResEntity<InterfaceBean2>,InterfaceBean2>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<InterfaceBean2>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(InterfaceBean2 memberBeans) {
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
    public void attachView(IBaseView iBaseView) {
        this.iBaseView=iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView=null;
    }
}
