package com.example.player.a1610aplayerdemo.fragment.member;

import android.content.SharedPreferences;
import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.net.Contance;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.token.SpUtils;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class MemberPresenter implements IBasePresenter<Bean_Member.DataBean> {

    IBaseView<Bean_Member.DataBean> iBaseView;

    @Override
    public void getData() {

        Map<String,String> headMap = new HashMap<>();
        String token = SpUtils.getSpUtils().getToken();
        if (token==null){
            token = "D7C1676C00907C27B80ECBAB4F90902E";
        }
        headMap.put(Contance.CH_TOKEN,token);

        RetrofitCreator.getInstance().getRetrofitApiService()
                .getMenmberData(headMap,"0","20")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean_Member>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean_Member bean_member) {
                      iBaseView.onloadData(bean_member.getData());
                        Log.i("shuju", "onNext: "+"     "+bean_member.getMessage()+ "  "+bean_member.getCode());
                    }

                    @Override
                    public void onError(Throwable e) {
                          iBaseView.onLoadError(e.hashCode(),e.getMessage());
                        Log.i("DATA", "onNext: "+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void attachView(IBaseView<Bean_Member.DataBean> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
          iBaseView = null;
    }
}
