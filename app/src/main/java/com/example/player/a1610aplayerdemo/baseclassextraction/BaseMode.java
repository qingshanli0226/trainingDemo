package com.example.player.a1610aplayerdemo.baseclassextraction;

import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.google.gson.Gson;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.lang.reflect.Type;
import java.util.HashMap;

public abstract class BaseMode<T> implements IMode<T>{
    @Override
    public void getDate(final IDataListener<T> listener) {

        RetrofitCreator.getApiService().getData(getHeaders(),getAPIPath1(),getAPIPath2(),getParmams())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        T date;
                        date  = new Gson().fromJson(s,getDataType());
                        listener.onGetData(date);
                    }
                    @Override
                    public void onError(Throwable e) {
                        listener.onGetDataFailed(1,e.toString());
                    }
                    @Override
                    public void onComplete() {

                    }
                });


    }

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
    public abstract String getAPIPath1();
    public abstract String getAPIPath2();

    //获取返回的数据类型 该类型必须和泛型 T 一致
    public abstract Type getDataType();
}
