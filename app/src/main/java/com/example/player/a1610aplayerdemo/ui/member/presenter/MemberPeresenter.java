package com.example.player.a1610aplayerdemo.ui.member.presenter;

import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.ui.member.bean.MemberBean;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MemberPeresenter implements IBasePresenter<MemberBean.DataBean> {
    IBaseView<MemberBean.DataBean> iBaseView;

    @Override
    public void getData() {
        RetrofitCreator.getMyServiceInterface().getDataTwo("4","0","0","0","2147483647")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MemberBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MemberBean memberBean) {
                        iBaseView.onLoadData(memberBean.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("ERROR",e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachView(IBaseView<MemberBean.DataBean> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}