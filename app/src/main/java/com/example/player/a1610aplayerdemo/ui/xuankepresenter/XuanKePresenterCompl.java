package com.example.player.a1610aplayerdemo.ui.xuankepresenter;

import com.example.player.a1610aplayerdemo.bean.XuanKeDateBean;
import com.example.player.a1610aplayerdemo.net.MVPObserver;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.net.RetrofitCreatorS;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class XuanKePresenterCompl implements XuanKeInterface.IxuankePresenter{

    private XuanKeInterface.XuanKeView xuanKeView;

    public XuanKePresenterCompl(XuanKeInterface.XuanKeView xuanKeView) {
        this.xuanKeView = xuanKeView;
    }


    @Override
    public void getXkData() {

        RetrofitCreator.getApiService().getXuanKeDate("http://api.immedc.com/restapi/loading/getHome")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        xuanKeView.showLoading();
                    }
                })

                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        xuanKeView.hideLoading();
                    }
                })
                .subscribe(new MVPObserver<XuanKeDateBean>(){

                    @Override
                    public void onNext(XuanKeDateBean xuanKeDateBean) {

                        xuanKeView.onGetDataSuccess(xuanKeDateBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        e.printStackTrace();
                    }
                });

    }

    @Override
    public void detachView() {
        xuanKeView = null;
    }
}
