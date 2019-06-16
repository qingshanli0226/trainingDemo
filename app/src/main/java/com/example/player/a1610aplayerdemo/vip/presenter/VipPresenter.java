package com.example.player.a1610aplayerdemo.vip.presenter;

import android.view.View;
import com.example.player.a1610aplayerdemo.Content;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.base.ResEntity;
import com.example.player.a1610aplayerdemo.net.CreatorRetorfitApi;
import com.example.player.a1610aplayerdemo.net.MyObServer;
import com.example.player.a1610aplayerdemo.net.NetFunction;
import com.example.player.a1610aplayerdemo.vip.Bean.VipBean;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

public class VipPresenter implements IBasePresenter<VipBean.DataBean> {
    private IBaseView<VipBean.DataBean> iBaseView;
    @Override
    public void getData() {
        CreatorRetorfitApi.getiRetrofitApiSerice().getVipBean()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new MyObServer<VipBean>() {
                    @Override
                    public void onNext(VipBean vipBean) {
                        iBaseView.onLoadData(vipBean.getData());
                    }
                });
    }

    @Override
    public void attachView(IBaseView<VipBean.DataBean> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}
