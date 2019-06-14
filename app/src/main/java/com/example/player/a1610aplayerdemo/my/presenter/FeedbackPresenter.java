package com.example.player.a1610aplayerdemo.my.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.example.player.a1610aplayerdemo.MVPApplication;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.mistake.ErrorUtil;
import com.example.player.a1610aplayerdemo.mistake.NetFunction;
import com.example.player.a1610aplayerdemo.mistake.ResEntity;
import com.example.player.a1610aplayerdemo.my.bean.Feedback;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class FeedbackPresenter implements IBasePresenter<Feedback> {
    IBaseView<Feedback> iBaseView;
    SharedPreferences sp;

    @Override
    public void getData() {
        sp = MVPApplication.instance.getSharedPreferences("feedback",Context.MODE_PRIVATE);
        String s1 = sp.getString("opinion","空值");
        String s2 = sp.getString("relation","空值");

        Map map = new HashMap();
        map.put("contents", s1);
        map.put("contact", s2);

        RetrofitCreator.getNetApiService().getFeedback(map)
                .subscribeOn(Schedulers.io())
                .map(new NetFunction<ResEntity<Feedback>,Feedback>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Feedback>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Feedback feedback) {
                        iBaseView.onLoadData(feedback);
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
    public void attachView(IBaseView<Feedback> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}
