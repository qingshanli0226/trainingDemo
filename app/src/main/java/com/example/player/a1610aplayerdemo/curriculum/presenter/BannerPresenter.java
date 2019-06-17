package com.example.player.a1610aplayerdemo.curriculum.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.player.a1610aplayerdemo.MVPApplication;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.curriculum.bean.BannerBean;
import com.example.player.a1610aplayerdemo.mistake.ErrorUtil;
import com.example.player.a1610aplayerdemo.mistake.NetFunction;
import com.example.player.a1610aplayerdemo.mistake.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class BannerPresenter implements IBasePresenter<BannerBean> {
    IBaseView<BannerBean> iBaseView;
    SharedPreferences sp;

    @Override
    public void getData() {
        sp = MVPApplication.instance.getSharedPreferences("spBanner",Context.MODE_PRIVATE);
        String s1 = sp.getString("courseId","空值");
        Map map = new HashMap();
        map.put("courseId",s1);
        map.put("packageId","0");

        RetrofitCreator.getNetApiService().getBannerData(map)
                .subscribeOn(Schedulers.io())
                .map(new NetFunction<ResEntity<BannerBean>,BannerBean>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        iBaseView.onLoadData(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        ErrorUtil.handleError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachView(IBaseView<BannerBean> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}
