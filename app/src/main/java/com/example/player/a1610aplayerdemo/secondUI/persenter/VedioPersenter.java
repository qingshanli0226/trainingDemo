package com.example.player.a1610aplayerdemo.secondUI.persenter;

import com.example.player.a1610aplayerdemo.base.BasePersenter;
import com.example.player.a1610aplayerdemo.base.BaseView;
import com.example.player.a1610aplayerdemo.service.MyService;
import com.example.player.a1610aplayerdemo.secondUI.bean.BannerBean;
import com.example.player.a1610aplayerdemo.service.util.MyRetorfit;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class VedioPersenter implements BasePersenter {

    private BaseView baseView;

    public VedioPersenter(BaseView baseView) {
        this.baseView = baseView;
    }

    public void getVedioData(String courseId,String packageId){
        MyService service = new MyRetorfit().getService();
        service.getTwoMenu(courseId,packageId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        baseView.onLoadData(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                            baseView.onLoadError(119,e.toString());

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    @Override
    public void getData() {

    }

    @Override
    public void destoryView() {

    }
}
