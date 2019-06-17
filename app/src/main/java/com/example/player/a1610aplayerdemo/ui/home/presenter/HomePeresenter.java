package com.example.player.a1610aplayerdemo.ui.home.presenter;

import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.base.ResEntity;
import com.example.player.a1610aplayerdemo.commit.Contants;
import com.example.player.a1610aplayerdemo.net.Functions;
import com.example.player.a1610aplayerdemo.net.ObServer;
import com.example.player.a1610aplayerdemo.net.SP;
import com.example.player.a1610aplayerdemo.ui.home.bean.HomeBean;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePeresenter implements IBasePresenter<HomeBean.DataBean> {
    IBaseView<HomeBean.DataBean> iBaseView;

    @Override
    public void getData() {

        Map<String,String> map = new HashMap();
        String token = SP.getToken();
        if (!token.equals("")){
            map.put("CH-TOKEN", token);
            Log.i("aaa", "getData: "+token);
        }else {
            map.put("CH-TOKEN", Contants.TOKEN_FINAL);
        }

        RetrofitCreator.getMyServiceInterface().getHomeBean(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Functions<ResEntity<HomeBean.DataBean>, HomeBean.DataBean>() {
                })
                .subscribe(new ObServer<HomeBean.DataBean>(){
                    @Override
                    public void onNext(HomeBean.DataBean homeBean) {
                        super.onNext(homeBean);
                        List<HomeBean.DataBean> list = new ArrayList<>();
                        list.add(homeBean);
                        Log.i("asd", ""+list.get(0).getVipRecommend().size());
                        iBaseView.onLoadData(list);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        Log.i("dddd", "onError: "+e.toString());
                    }
                });

//        RetrofitCreator.getMyServiceInterface().getData()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<HomeBean>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(HomeBean homeBean) {
//                        iBaseView.onLoadData(homeBean.getData());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

    }


    @Override
    public void attachView(IBaseView<HomeBean.DataBean> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}