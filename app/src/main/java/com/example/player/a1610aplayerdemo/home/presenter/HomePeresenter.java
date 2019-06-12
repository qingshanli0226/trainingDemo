package com.example.player.a1610aplayerdemo.home.presenter;

import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.home.bean.HomeBean;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePeresenter implements IBasePresenter<HomeBean.DataBean> {
    IBaseView<HomeBean.DataBean> iBaseView;

    @Override
    public void getData() {
        RetrofitCreator.getMyServiceInterface().getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        iBaseView.onLoadData(homeBean.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("LQS",e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    public void attachView(IBaseView<HomeBean.DataBean> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}