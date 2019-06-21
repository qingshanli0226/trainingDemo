package com.example.player.a1610aplayerdemo.base;

import android.util.Log;
import com.example.player.a1610aplayerdemo.net.CreatorUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.lang.reflect.Type;
import java.util.HashMap;

public abstract class BasePresenter<T> implements IBasePresenter<T> {
    protected IBaseView<T> iBaseView;


    @Override
    public void getData() {
        BaseService baseService = CreatorUtils.getRetrofit();
        Observable<String> data = baseService.getData(getAPIPath1(), getAPIPath2(),getParmams());
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String string) {
                        iBaseView.onLoadDataBean((T) string);
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

    public HashMap<String, String> getParmams() {
        return new HashMap<>();
    }




    public abstract String getAPIPath1();
    public abstract String getAPIPath2();


    public abstract Type getDataType();

    @Override
    public void attachView(IBaseView<T> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}
