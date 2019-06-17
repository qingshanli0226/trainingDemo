package com.example.player.a1610aplayerdemo.ui.member.presenter;

import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.base.ResEntity;
import com.example.player.a1610aplayerdemo.commit.Contants;
import com.example.player.a1610aplayerdemo.net.Functions;
import com.example.player.a1610aplayerdemo.net.ObServer;
import com.example.player.a1610aplayerdemo.net.SP;
import com.example.player.a1610aplayerdemo.ui.member.bean.MemberBean;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberPeresenter implements IBasePresenter<MemberBean.DataBean> {
    IBaseView<MemberBean.DataBean> iBaseView;

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

        RetrofitCreator.getMyServiceInterface().getDataTwo(map,"0","20")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ObServer<MemberBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MemberBean memberBean) {
                        List<MemberBean.DataBean> data = memberBean.getData();
                        Log.i("memberbean",memberBean.getData().size() + "");
                        iBaseView.onLoadData(data);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("error",e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachView(IBaseView<MemberBean.DataBean> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}