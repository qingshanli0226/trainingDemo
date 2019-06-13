package com.example.player.a1610aplayerdemo.curriculum.presenter;

import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.curriculum.bean.Bean;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.mistake.ErrorUtil;
import com.example.player.a1610aplayerdemo.mistake.NetFunction;
import com.example.player.a1610aplayerdemo.mistake.ResEntity;
import com.example.player.a1610aplayerdemo.url.SiteUrl;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CurriculumPresenter implements IBasePresenter<Bean> {
    IBaseView<Bean> iBaseView;

    @Override
    public void getData() {
        RetrofitCreator.getNetApiService().getBeanData(SiteUrl.CURRICULUM)
                .subscribeOn(Schedulers.io())
                .map(new NetFunction<ResEntity<Bean>,Bean>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        iBaseView.onLoadData(bean);
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
    public void attachView(IBaseView<Bean> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}
