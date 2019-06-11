package com.example.player.a1610aplayerdemo.test;

import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.net.CreatorRetorfitApi;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TestPresent implements IBasePresenter<NetBean.DataBean> {
    private IBaseView<NetBean.DataBean> iBaseView;
    @Override
    public void getData() {
        CreatorRetorfitApi.getiRetrofitApiSerice().getData("http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NetBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NetBean netBean) {
                        Log.d("MH",netBean.getData().get(0).getTitle());
                        iBaseView.onLoadData(netBean.getData());
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

    @Override
    public void attachView(IBaseView<NetBean.DataBean> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}
