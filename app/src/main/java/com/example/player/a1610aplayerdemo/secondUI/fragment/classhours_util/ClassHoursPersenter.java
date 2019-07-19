package com.example.player.a1610aplayerdemo.secondUI.fragment.classhours_util;

import com.example.player.a1610aplayerdemo.base.BasePersenter;
import com.example.player.a1610aplayerdemo.base.BaseView;
import com.example.player.a1610aplayerdemo.secondUI.bean.BannerBean;
import com.example.player.a1610aplayerdemo.service.MyService;
import com.example.player.a1610aplayerdemo.service.util.MyRetorfit;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ClassHoursPersenter implements BasePersenter<BannerBean> {
    BaseView<BannerBean> baseView;



    public void gitBannerData(String courseId,String packageId){
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
                        if (bannerBean.getCode().equals("success")){
                            baseView.onLoadData(bannerBean);
                        } else {

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        baseView.onLoadError(121,e.toString());

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
    public void attachview(BaseView<BannerBean> baseView) {
        this.baseView = baseView;

    }

    @Override
    public void destoryView() {
        baseView = null;

    }
}
