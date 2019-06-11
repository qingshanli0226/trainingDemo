package com.example.player.a1610aplayerdemo.choice;

import com.example.player.a1610aplayerdemo.Constant;
import com.example.player.a1610aplayerdemo.MainActivity;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.Bean;
import com.example.player.a1610aplayerdemo.bean.MainBean;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ChoicePresenter implements IBasePresenter<MainBean> {

    IBaseView<MainBean> iBaseView;

    @Override
    public void getData() {
        RetrofitCreator.getInstance().getIServiceApi().getMainData(Constant.BASE + "restapi/loading/getHome")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Bean<MainBean>, MainBean>() {
                    @Override
                    public MainBean apply(Bean<MainBean> mainBeanBean) throws Exception {
                        return mainBeanBean.getData();
                    }
                }).subscribe(new Observer<MainBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(MainBean mainBean) {
                List<MainBean> list = new ArrayList<>();
                list.add(mainBean);
                iBaseView.onLoadData(list);
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
    public void attachView(IBaseView<MainBean> iBaseView) {
        this.iBaseView = iBaseView;
    }




    @Override
    public void detachView() {
        iBaseView = null;
    }
}
