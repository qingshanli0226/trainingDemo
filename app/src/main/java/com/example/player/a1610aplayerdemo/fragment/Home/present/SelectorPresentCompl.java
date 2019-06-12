package com.example.player.a1610aplayerdemo.fragment.Home.present;

import android.annotation.SuppressLint;
import com.example.player.a1610aplayerdemo.fragment.Home.bean.SelectorBean;
import com.example.player.a1610aplayerdemo.net.MvpObserver;
import com.example.player.a1610aplayerdemo.net.NetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreate;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SelectorPresentCompl implements SelectPresenter.ISelectPresener {

    public SelectPresenter.ISelectorView iSelectPresener;

    public SelectorPresentCompl(SelectPresenter.ISelectorView iSelectPresener) {
        this.iSelectPresener = iSelectPresener;
    }
    @Override
    public void getSelectorData() {
        RetrofitCreate.getNetApiService().getSelectorData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new NetFunction<ResEntity<SelectorBean>,SelectorBean>())
                .subscribe(new MvpObserver<SelectorBean>(){
                    @Override
                    public void onNext(SelectorBean selectorBean) {
                        super.onNext(selectorBean);
                        iSelectPresener.onGetDataSuccess(selectorBean);
                    }
                });
    }

    @Override
    public void DetachView() {
            iSelectPresener=null;

    }

}
