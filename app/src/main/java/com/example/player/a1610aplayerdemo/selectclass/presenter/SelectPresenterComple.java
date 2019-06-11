package com.example.player.a1610aplayerdemo.selectclass.presenter;

import android.util.Log;
import com.example.player.a1610aplayerdemo.net.CreatorRetorfitApi;
import com.example.player.a1610aplayerdemo.selectclass.SelectBean;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SelectPresenterComple implements SelectClassContract.ISelelctDataPresenter {
    @Override
    public void getSelectBean() {
        CreatorRetorfitApi.getiRetrofitApiSerice().getSelectBean()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<SelectBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SelectBean selectBean) {
                        Log.d("MH",selectBean.getCode());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("MH",e.getMessage()+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
