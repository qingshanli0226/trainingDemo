package com.example.player.a1610aplayerdemo.presenter.find_category_presenter;

import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.EducationBean;
import com.example.player.a1610aplayerdemo.bean.MusicClassBean;
import com.example.player.a1610aplayerdemo.service.BaseService;
import com.example.player.a1610aplayerdemo.util.CreatorUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CategoryEducationPresenter implements IBasePresenter<EducationBean> {

    private IBaseView<EducationBean> iBaseView;


    @Override
    public void attachView(IBaseView<EducationBean> baseView) {
        this.iBaseView = baseView;
    }


    @Override
    public void getData() {
        BaseService baseService = CreatorUtils.getRetrofit();
        Observable<EducationBean> homeData = baseService.getEducationData();
        homeData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EducationBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(EducationBean educationBean) {

                        iBaseView.onLoadData(educationBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("我",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }



    @Override
    public void detachView() {
        iBaseView = null;
    }

}
