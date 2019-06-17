package com.example.player.a1610aplayerdemo.ui.home_activity.zllistactivity.presenter;

import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.base.ResEntity;
import com.example.player.a1610aplayerdemo.commit.Contants;
import com.example.player.a1610aplayerdemo.net.Functions;
import com.example.player.a1610aplayerdemo.net.ObServer;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.net.SP;
import com.example.player.a1610aplayerdemo.ui.home_activity.zllistactivity.bean.ZlListBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeFourPeresenter implements IBasePresenter<ZlListBean.DataBean> {
    IBaseView<ZlListBean.DataBean> iBaseView;
    private String id;

    public HomeFourPeresenter(String id) {
        this.id = id;
    }

    @Override
    public void getData() {
        Map<String,String> map = new HashMap<>();
        String token = SP.getToken();
        if (!token.equals("")){
            map.put("CH-TOKEN",token);
        }else {
            map.put("CH-TOKEN", Contants.TOKEN_FINAL);
        }

        RetrofitCreator.getMyServiceInterface().getZlListBean(map,id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Functions<ResEntity<ZlListBean.DataBean>,ZlListBean.DataBean>())
                .subscribe(new ObServer<ZlListBean.DataBean>(){

                    @Override
                    public void onNext(ZlListBean.DataBean zlListBean) {
                        super.onNext(zlListBean);
                        List<ZlListBean.DataBean> listBeans = new ArrayList<>();
                        listBeans.add(zlListBean);
                        iBaseView.onLoadData(listBeans);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        Log.i("homefour","onError：" + e.toString());
                    }

                });
    }

    @Override
    public void attachView(IBaseView<ZlListBean.DataBean> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }

}