package com.example.player.a1610aplayerdemo.home.persenter;

import android.util.Log;
import com.example.player.a1610aplayerdemo.bean.HomeBean;
import com.example.player.a1610aplayerdemo.home.view.HomeView;
import com.example.player.a1610aplayerdemo.service.MyService;
import com.example.player.a1610aplayerdemo.service.util.MyRetorfit;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePersenter implements HomeData {

    HomeView homeView;

    public HomePersenter(HomeView homeView) {
        this.homeView = homeView;
    }

    @Override
    public void getData(String token) {

        MyService service = new MyRetorfit().getService();
        Observable<HomeBean> homeInfo = service.getHomeInfo("4046381F8C1C2C1D0A4AB66B15205D7B");
        homeInfo.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                          homeView.onLoadData(homeBean);
                        Log.d("aaaaaaqq",""+homeBean.getCode());
                    }

                    @Override
                    public void onError(Throwable e) {
                        homeView.onErrorData(e.toString());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
