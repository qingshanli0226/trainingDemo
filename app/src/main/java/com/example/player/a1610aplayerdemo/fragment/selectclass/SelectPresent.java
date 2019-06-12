package com.example.player.a1610aplayerdemo.fragment.selectclass;

import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.fragment.selectclass.bean.GetHomeBean;
import com.example.player.a1610aplayerdemo.net.Contance;
import com.example.player.a1610aplayerdemo.net.NetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

class SelectPresent implements IBasePresenter<GetHomeBean.DataBean> {

    IBaseView<GetHomeBean.DataBean> iBaseView;

    @Override
    public void getData() {
        RetrofitCreator.getInstance().getRetrofitApiService()
                .getSelectData(Contance.BASE_URL+Contance.GET_HOME)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetHomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetHomeBean dataBean) {
                        Log.i("aaa", "onNext: "+dataBean.getData().getHomeBanner().size());
                        iBaseView.onLoadObject(dataBean.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("aaa", "onError: "+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachView(IBaseView iBaseView) {
           this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}
