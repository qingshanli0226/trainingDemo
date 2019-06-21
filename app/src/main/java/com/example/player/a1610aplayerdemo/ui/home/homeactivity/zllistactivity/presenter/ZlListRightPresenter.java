package com.example.player.a1610aplayerdemo.ui.home.homeactivity.zllistactivity.presenter;

import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.base.ResEntity;
import com.example.player.a1610aplayerdemo.net.Contants;
import com.example.player.a1610aplayerdemo.net.Functions;
import com.example.player.a1610aplayerdemo.net.ObServer;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.net.SP;
import com.example.player.a1610aplayerdemo.ui.home.homeactivity.zllistactivity.bean.ZlListRightBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZlListRightPresenter implements IBasePresenter<List<ZlListRightBean.DataBean>> {
    private IBaseView iBaseView;
    private String zlId;

    public ZlListRightPresenter(String zlId) {
        this.zlId = zlId;
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
        RetrofitCreator.getMyServiceInterface().getZlListRightBean(map,zlId,"1","20")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Functions<ResEntity<List<ZlListRightBean.DataBean>>,List<ZlListRightBean.DataBean>>())
                .subscribe(new ObServer<List<ZlListRightBean.DataBean>>(){

                    @Override
                    public void onNext(List<ZlListRightBean.DataBean> dataBean) {
                        super.onNext(dataBean);

                        Log.i("www","123:" + dataBean.size() + "");
                        iBaseView.onLoadData(dataBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        Log.i("righterror",e.toString());
                    }
                });
    }

    @Override
    public void attachView(IBaseView<List<ZlListRightBean.DataBean>> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}