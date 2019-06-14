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
    public void loadDataByGet() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Test-header1", "1610A1");
        headers.put("Test-header2", "1610A2");
        HashMap<String, String> params = new HashMap<>();
        params.put("stage_id", "1");
        params.put("limit", "20");
        params.put("page", "1");
        RetrofitCreator.getApiService().getData(headers,"dish_list.php", params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("LQS", s);
                        //iBaseView.onLoadDataList(netDataBean.getData());
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
