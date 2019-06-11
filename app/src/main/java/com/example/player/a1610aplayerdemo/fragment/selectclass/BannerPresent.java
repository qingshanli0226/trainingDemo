package com.example.player.a1610aplayerdemo.fragment.selectclass;

import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.net.Contance;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

class BannerPresent implements IBasePresenter<GetHomeBean.DataBean.HomeBannerBean> {

    IBaseView<GetHomeBean.DataBean.HomeBannerBean> iBaseView;

    @Override
    public void getData() {
        RetrofitCreator.getInstance().getRetrofitApiService()
                .getbanner(Contance.BASE_URL+Contance.GET_HOME)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetHomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetHomeBean getHomeBean) {
                       iBaseView.onloadData(getHomeBean.getData().getHomeBanner());
                    }

                    @Override
                    public void onError(Throwable e) {
                         iBaseView.onLoadError(e.hashCode(),e.getMessage());
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
