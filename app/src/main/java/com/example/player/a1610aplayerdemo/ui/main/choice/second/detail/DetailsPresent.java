package com.example.player.a1610aplayerdemo.ui.main.choice.second.detail;

import android.util.Log;
import com.example.player.a1610aplayerdemo.Constant;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.Bean;
import com.example.player.a1610aplayerdemo.bean.DetailBean;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.utils.TokenSp;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class DetailsPresent implements IBasePresenter<DetailBean> {
    private IBaseView<DetailBean> iBaseView;
    private String url;

    public DetailsPresent(String url) {
        this.url = url;
    }

    @Override
    public void getData() {
        String token = TokenSp.getInstance().getToken();
        Log.e("123456", "getData: " + token);
        Map<String, String> map = new HashMap<>();
        map.put("Android-channel", "guoyun");
        map.put("Android-VersionCode", "43");
        map.put("DeviceKey", Constant.DeviceKey);
        map.put("Tingyun_Process", "true");
        map.put("CH-TOKEN", token);
        RetrofitCreator.getInstance().getIServiceApi().getDetailsData(map, Constant.BASE + url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean<DetailBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean<DetailBean> detailBeanBean) {
                        DetailBean data = detailBeanBean.getData();
                        iBaseView.onLoadDataObject(data);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachView(IBaseView<DetailBean> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}
