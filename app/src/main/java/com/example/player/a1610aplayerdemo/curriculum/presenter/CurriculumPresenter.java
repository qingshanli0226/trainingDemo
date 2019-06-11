package com.example.player.a1610aplayerdemo.curriculum.presenter;

import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.curriculum.bean.Bean;
import com.example.player.a1610aplayerdemo.curriculum.net.RetrofitCreatorCurriculum;
import com.example.player.a1610aplayerdemo.url.Website;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CurriculumPresenter implements IBasePresenter<Bean> {
    IBaseView<Bean> iBaseView;

    @Override
    public void getData() {
        RetrofitCreatorCurriculum.getNetApiService().getBeanData(Website.CURRICULUM)
                .subscribeOn(Schedulers.io())
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
                        iBaseView.onLoadError(1,e.getMessage());
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
