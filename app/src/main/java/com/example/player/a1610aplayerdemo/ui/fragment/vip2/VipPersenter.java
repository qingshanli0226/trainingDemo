package com.example.player.a1610aplayerdemo.ui.fragment.vip2;

import com.example.player.a1610aplayerdemo.base.BasePersenter;
import com.example.player.a1610aplayerdemo.base.BaseView;
import com.example.player.a1610aplayerdemo.bean.VipBean;
import com.example.player.a1610aplayerdemo.service.MyService;
import com.example.player.a1610aplayerdemo.service.util.MyRetorfit;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class VipPersenter implements BasePersenter<VipBean> {

    BaseView<VipBean> baseView;

    @Override
    public void getData() {

    }

    public void getVipData(String minid, String size){
        MyService service = new MyRetorfit().getService();
        service.getVipInfo(minid,size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VipBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VipBean vipBean) {
                       if (vipBean.getCode().equals("success")){
                             baseView.onLoadData(vipBean);
                       }else {
                           vipBean.getMessage();
                       }
                    }

                    @Override
                    public void onError(Throwable e) {
                        baseView.onLoadError(12,e.toString());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachview(BaseView<VipBean> baseView) {
        this.baseView=baseView;
    }

    @Override
    public void destoryView() {
                baseView=null;
    }
}
