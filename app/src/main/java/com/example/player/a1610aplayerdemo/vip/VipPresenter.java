package com.example.player.a1610aplayerdemo.vip;

import com.example.player.a1610aplayerdemo.base.BasePersenter;
import com.example.player.a1610aplayerdemo.base.BaseView;
import com.example.player.a1610aplayerdemo.bean.VipBean;
import com.example.player.a1610aplayerdemo.service.MyService;
import com.example.player.a1610aplayerdemo.util.MyRetorfit;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class VipPresenter implements BasePersenter {

    private BaseView baseView;

    public VipPresenter(BaseView vipView) {
        this.baseView = vipView;
    }

    @Override
    public void getData() {

    }

    public void getVipData(String minind,String size){
        MyRetorfit retorfit  = new MyRetorfit();
        retorfit.getService().getVipInfo(minind,size)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe(new Observer<VipBean>() {
                                @Override
                                public void onSubscribe(Disposable d) {

                                }

                                @Override
                                public void onNext(VipBean vipBean) {
                                    baseView.onLoadData(vipBean);
                                }

                                @Override
                                public void onError(Throwable e) {
                                    baseView.onLoadError(101,e.toString());
                                }

                                @Override
                                public void onComplete() {

                                }
                            });
    }



    @Override
    public void destoryView() {
            if (baseView !=null){
                baseView =null;
            }
    }
}
