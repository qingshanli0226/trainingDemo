package com.example.player.a1610aplayerdemo.presenter.find_category_presenter;

import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.EducationBean;
import com.example.player.a1610aplayerdemo.bean.LiveBean;
import com.example.player.a1610aplayerdemo.service.BaseService;
import com.example.player.a1610aplayerdemo.util.CreatorUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CategoryLiveClassPresenter implements IBasePresenter<LiveBean>{

    private IBaseView<LiveBean> iBaseView;


    @Override
    public void attachView(IBaseView<LiveBean> baseView) {
        this.iBaseView = baseView;
    }


    @Override
    public void getData() {
        BaseService baseService = CreatorUtils.getRetrofit();
        Observable<LiveBean> homeData = baseService.getLiveData("0","1","20");
        homeData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LiveBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LiveBean liveBean) {

                        iBaseView.onLoadData(liveBean);

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
