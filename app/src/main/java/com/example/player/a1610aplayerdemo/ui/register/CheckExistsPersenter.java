package com.example.player.a1610aplayerdemo.ui.register;

import com.example.player.a1610aplayerdemo.base.BasePersenter;
import com.example.player.a1610aplayerdemo.base.BaseView;
import com.example.player.a1610aplayerdemo.service.MyService;
import com.example.player.a1610aplayerdemo.service.util.MyRetorfit;
import com.example.player.a1610aplayerdemo.ui.register.checkexists.CheckBean;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;

public class CheckExistsPersenter implements BasePersenter<CheckBean> {
    BaseView<CheckBean> baseView;

    public void getCheckisRegister(HashMap<String, String> head, HashMap<String, String> map){
        MyService service = new MyRetorfit().getService();
        service.getCheckExists(head,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CheckBean>(){
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CheckBean checkBean) {
                        baseView.onLoadData(checkBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        baseView.onLoadError(1,e.toString());
                    }

                    @Override
                    public void onComplete() {
                    }
                });


    }
    @Override
    public void getData() {



    }

    @Override
    public void attachview(BaseView<CheckBean> baseView) {
    }

    @Override
    public void destoryView() {

    }
}

