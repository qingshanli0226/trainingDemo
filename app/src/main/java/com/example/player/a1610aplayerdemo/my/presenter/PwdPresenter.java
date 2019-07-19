package com.example.player.a1610aplayerdemo.my.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.player.a1610aplayerdemo.MVPApplication;
import com.example.player.a1610aplayerdemo.base.IBasePresenterTwo;
import com.example.player.a1610aplayerdemo.base.IBaseViewTwo;
import com.example.player.a1610aplayerdemo.mistake.ErrorUtil;
import com.example.player.a1610aplayerdemo.mistake.NetFunction;
import com.example.player.a1610aplayerdemo.mistake.ResEntity;
import com.example.player.a1610aplayerdemo.my.bean.AuthCode;
import com.example.player.a1610aplayerdemo.my.bean.PwdBean;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.net.RetrofitCreatorUser;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class PwdPresenter implements IBasePresenterTwo<PwdBean> {
    private IBaseViewTwo<PwdBean> iBaseView;
    SharedPreferences sp;


    @Override
    public void getData() {
        sp = MVPApplication.instance.getSharedPreferences("phoneuser",Context.MODE_PRIVATE);
        String s1 = sp.getString("token","空值");
        String s2 = sp.getString("identifyingCode","空值");
        String s3 = sp.getString("loginName","空值");
        String s4 = sp.getString("password","空值");

        Map map = new HashMap();
        map.put("identifyingCode", s2);
        map.put("mobilePhone",s3);
        map.put("token", s1);
        map.put("password",s4);

        RetrofitCreatorUser.getNetApiService().getPwdData(map)
                .subscribeOn(Schedulers.io())
                .map(new NetFunction<ResEntity<PwdBean>,PwdBean>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PwdBean>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PwdBean pwdBean) {
                        iBaseView.onLoadDataT(pwdBean);
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
    public void attachView(IBaseViewTwo<PwdBean> iBaseView) {

        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}
