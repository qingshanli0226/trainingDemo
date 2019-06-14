package com.example.player.a1610aplayerdemo.login;

import com.example.player.a1610aplayerdemo.base.BasePersenter;
import com.example.player.a1610aplayerdemo.base.BaseView;
import com.example.player.a1610aplayerdemo.bean.LoginBean;
import com.example.player.a1610aplayerdemo.service.MyService;
import com.example.player.a1610aplayerdemo.util.MyRetorfit;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter implements BasePersenter {

    private BaseView baseView;

    public LoginPresenter(BaseView baseView) {
        this.baseView = baseView;
    }

    @Override
    public void getData() {

    }
    public void getLogin(String token,String packageId,String lastId,String size){
        MyService service = new MyRetorfit().getService();
        service.getLoginInfo(token,packageId,lastId,size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        baseView.onLoadData(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        baseView.onLoadError(10910,e.toString());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }



    @Override
    public void destoryView() {

    }
}
