package com.example.player.a1610aplayerdemo.home.presenter;

import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.home.mode.NetDataBean;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;

public class HomePresenter implements IBasePresenter<NetDataBean.DataBean> {
    IBaseView<NetDataBean.DataBean> iBaseView;

    @Override
    public void getData() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Test-header1", "1610A1");
        headers.put("Test-header2", "1610A2");
        RetrofitCreator.getApiService().getData(headers,"http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NetDataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NetDataBean netDataBean) {
                        iBaseView.onLoadDataList(netDataBean.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("LQS", e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachView(IBaseView<NetDataBean.DataBean> iBaseView) {
        this.iBaseView = iBaseView;

    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}
