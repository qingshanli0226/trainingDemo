package com.example.player.a1610aplayerdemo.presenter;

import android.util.Log;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.MemberBean;
import com.example.player.a1610aplayerdemo.service.BaseService;
import com.example.player.a1610aplayerdemo.util.CreatorUtils;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

import java.io.IOException;

public class MemberPresenter implements IBasePresenter<MemberBean> {

    private IBaseView<MemberBean> iBaseView;


    @Override
    public void attachView(IBaseView<MemberBean> baseView) {
            this.iBaseView = baseView;
    }


    @Override
    public void getData() {
        BaseService baseService = CreatorUtils.getRetrofit();
        Observable<MemberBean> memberData = baseService.getMemberData("0", "20");
        memberData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MemberBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MemberBean memberBean) {
                            iBaseView.onLoadData(memberBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("我",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }



    @Override
    public void detachView() {
            iBaseView =null;
    }
}
