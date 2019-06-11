package com.example.player.a1610aplayerdemo.fragment.Home.present;

import com.example.player.a1610aplayerdemo.fragment.Home.bean.SelectorBean;
import com.example.player.a1610aplayerdemo.net.RetrofitCreate;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SelectorPresentCompl implements SelectPresenter.ISelectPresener {

    private SelectPresenter.ISelectorView iSelectPresener;

    public SelectorPresentCompl(SelectPresenter.ISelectorView iSelectPresener) {
        this.iSelectPresener = iSelectPresener;
    }

    @Override
    public void getSelectorData() {
        RetrofitCreate.getNetApiService().getSelectorData("loading/getHome ")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SelectorBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SelectorBean selectorBean) {
                        iSelectPresener.OnGetDataSuccess(selectorBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iSelectPresener.onGetDataFail(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void DetachView() {
            iSelectPresener=null;
    }
}
