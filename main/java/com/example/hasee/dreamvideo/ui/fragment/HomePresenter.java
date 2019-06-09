package com.example.hasee.dreamvideo.ui.fragment;

import com.example.hasee.dreamvideo.Presenter.ContextPresentor;
import com.example.hasee.dreamvideo.bean.HomeBean;
import com.example.hasee.dreamvideo.utils.MvpObserver;
import com.example.hasee.dreamvideo.utils.RetrofitCreate;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lmz on 2019/06/09
 *  主页面的 presenter
 */
public class HomePresenter implements ContextPresentor.IHomePresenter {
    private ContextPresentor.IHomeView iHomeView;

    public HomePresenter(ContextPresentor.IHomeView iHomeView) {
        this.iHomeView = iHomeView;
    }

    @Override
    public void getHomeinfo(String pagesize, String page) {
            RetrofitCreate.getUriService().getHomeDateInfo(pagesize,page)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe(new MvpObserver<HomeBean>(){
                                @Override
                                public void onNext(HomeBean bean) {
                                    super.onNext(bean);
                                    iHomeView.getHomeInfoSuccess(bean);
                                }

                                @Override
                                public void onError(Throwable e) {
                                    super.onError(e);
                                    iHomeView.getHomeInfoFailure(e.toString());
                                }
                            });
    }
}
