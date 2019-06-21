package com.example.player.a1610aplayerdemo.ui.home.presenter;

import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.base.ResEntity;
import com.example.player.a1610aplayerdemo.net.*;
import com.example.player.a1610aplayerdemo.ui.home.bean.HomeBean;
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
                        iBaseView.onLoadData(list);
                        iBaseView.onLoadObject(homeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });
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