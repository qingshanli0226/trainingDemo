package com.example.player.a1610aplayerdemo.ui.home_activity.categoryactivity.presenter;

import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.base.ResEntity;
import com.example.player.a1610aplayerdemo.commit.Contants;
import com.example.player.a1610aplayerdemo.net.Functions;
import com.example.player.a1610aplayerdemo.net.ObServer;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.net.SP;
import com.example.player.a1610aplayerdemo.ui.home_activity.categoryactivity.bean.CategoryZeroBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryZeroPresenter implements IBasePresenter<CategoryZeroBean.DataBean> {
    IBaseView<CategoryZeroBean.DataBean> iBaseView;

    @Override
    public void getData() {
        Map<String,String> map = new HashMap<>();
        String token = SP.getToken();
        if (!token.equals("")){
            map.put("CH-TOKEN",token);
        }else {
            map.put("CH-TOKEN", Contants.TOKEN_FINAL);
        }

        RetrofitCreator.getMyServiceInterface().getCategroyBean(map,"1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Functions<ResEntity<List<CategoryZeroBean.DataBean>>,List<CategoryZeroBean.DataBean>>())
                .subscribe(new ObServer<List<CategoryZeroBean.DataBean>>(){

                    @Override
                    public void onNext(List<CategoryZeroBean.DataBean> dataBean) {
                        super.onNext(dataBean);
                        iBaseView.onLoadData(dataBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        Log.i("categoryzeroerror",e.toString());
                    }
                });
    }

    @Override
    public void attachView(IBaseView<CategoryZeroBean.DataBean> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}