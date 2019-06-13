package com.example.player.a1610aplayerdemo.study.presenter;

import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.mistake.ErrorUtil;
import com.example.player.a1610aplayerdemo.mistake.NetFunction;
import com.example.player.a1610aplayerdemo.mistake.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.study.bean.VipBean;
import com.example.player.a1610aplayerdemo.url.SiteUrl;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

public class VipPresenter implements IBasePresenter<List<VipBean>> {
    IBaseView<List<VipBean>> iBaseView;

    @Override
    public void getData() {
        RetrofitCreator.getNetApiService().getVipBeanData(SiteUrl.VIP)
                .subscribeOn(Schedulers.io())
                .map(new NetFunction<ResEntity<List<VipBean>>,List<VipBean>>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<VipBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<VipBean> vipBeans) {
                        iBaseView.onLoadData(vipBeans);
                    }

                    @Override
                    public void onError(Throwable e) {
                        ErrorUtil.handleError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachView(IBaseView<List<VipBean>> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}
