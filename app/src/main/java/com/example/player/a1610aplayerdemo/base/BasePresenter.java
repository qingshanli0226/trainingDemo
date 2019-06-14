package com.example.player.a1610aplayerdemo.base;

import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.google.gson.Gson;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

public abstract class BasePresenter<T> implements IBasePresenter<T> {
    protected IBaseView<T> iBaseView;//声明一个IBaseView成员，因为在该抽象类里，要实现一定的业务逻辑


    @Override
    public void loadDataByGet() {
        RetrofitCreator.getApiService().getData(getHeaders(), getAPIPath(), getParmams())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        if (isList()) { //如果是列表数据
                            ResEntity<List<T>> resEntity = null;
                            resEntity = new Gson().fromJson(s, getDataType());
                            if (resEntity.getCode().equals("success")) {//做错误判断
                            }
                            iBaseView.onLoadDataList(resEntity.getData());
                        } else { //如果不是列表数据，是单个bean类
                            ResEntity<T> resEntity = null;
                            resEntity = new Gson().fromJson(s, getDataType());
                            if (resEntity.getCode().equals("success")) {

                            }
                            iBaseView.onLoadDataBean(resEntity.getData());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        iBaseView.onLoadError(1,e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //获取参数函数，如果没有参数子类没必要实现
    public HashMap<String, String> getParmams() {
        return new HashMap<>();
    }
    //获取头部参数函数，如果没有参数没必要实现
    public HashMap<String, String> getHeaders() {
        return new HashMap<>();
    }

    //返回的数据如果是列表,重写该方法，返回true.
    public boolean isList() {
        return false;
    }
    //获取函数资源地址
    public abstract String getAPIPath();

    //获取返回的数据类型
    public abstract Type getDataType();

    @Override
    public void attachView(IBaseView<T> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}
