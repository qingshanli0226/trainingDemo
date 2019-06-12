package com.example.player.a1610aplayerdemo.selectclass.presenter;

import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.base.ResEntity;
import com.example.player.a1610aplayerdemo.net.CreatorRetorfitApi;
import com.example.player.a1610aplayerdemo.net.MyObServer;
import com.example.player.a1610aplayerdemo.net.NetFunction;
import com.example.player.a1610aplayerdemo.selectclass.SelectBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SelectPresenter implements IBasePresenter<SelectBean> {
    private IBaseView<SelectBean> iBaseView;

    @Override
    public void getData() {
        CreatorRetorfitApi.getiRetrofitApiSerice().getSelectBean()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new NetFunction<ResEntity<SelectBean>,SelectBean>())
                .subscribe(new MyObServer<SelectBean>(){
                    @Override
                    public void onNext(SelectBean selectBean) {
                        Log.d("Mh",selectBean.getHomeBanner().get(0).getTitle());
                        iBaseView.onLoadObject(selectBean);
                    }
                });
    }

    @Override
    public void attachView(IBaseView<SelectBean> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}
