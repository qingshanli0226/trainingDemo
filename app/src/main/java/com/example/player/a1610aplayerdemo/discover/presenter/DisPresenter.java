package com.example.player.a1610aplayerdemo.discover.presenter;

import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.url.NetFunction;
import com.example.player.a1610aplayerdemo.url.ResEntity;
import com.example.player.a1610aplayerdemo.discover.bean.DiscoverBean;
import com.example.player.a1610aplayerdemo.net.NetWorkCreator;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DisPresenter implements IBasePresenter<DiscoverBean> {
    IBaseView<DiscoverBean> iBaseView;
    @Override
    public void getData() {
        NetWorkCreator.getNetWorkService().getHomeData()
                .subscribeOn(Schedulers.io())
                .map(new NetFunction<ResEntity<DiscoverBean>, DiscoverBean>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DiscoverBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DiscoverBean bean) {
                        iBaseView.onLoadData(bean);
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
    public void attachView(IBaseView<DiscoverBean> iBaseView) {
        this.iBaseView=iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView=null;
    }
}
