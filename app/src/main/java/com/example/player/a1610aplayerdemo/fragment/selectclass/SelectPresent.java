package com.example.player.a1610aplayerdemo.fragment.selectclass;

import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.fragment.selectclass.bean.GetHomeBean;
import com.example.player.a1610aplayerdemo.net.Contant;
import com.example.player.a1610aplayerdemo.net.NetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.token.SpUtils;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

class SelectPresent implements IBasePresenter<GetHomeBean.DataBean> {

    IBaseView<GetHomeBean.DataBean> iBaseView;

    @Override
    public void getData() {

        Map<String,String> headMap = new HashMap<>();
        String token = SpUtils.getSpUtils().getToken();
        if (token==null){
           return;
        }
        headMap.put(Contant.CH_TOKEN,token);

        RetrofitCreator.getInstance().getRetrofitApiService()
                .getSelectData(headMap)
                .map(new NetFunction<ResEntity<GetHomeBean.DataBean>,GetHomeBean.DataBean>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetHomeBean.DataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetHomeBean.DataBean dataBean) {
                        Log.i("aaa", "onNext: "+dataBean.getHomeBanner().size());
                        iBaseView.onLoadObject(dataBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("aaa", "onError: "+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachView(IBaseView iBaseView) {
           this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}
