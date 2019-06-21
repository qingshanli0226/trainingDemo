package com.example.player.a1610aplayerdemo.mvvm.databinding;

import com.example.player.a1610aplayerdemo.net.RetrofitCreate;
import com.google.gson.Gson;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.lang.reflect.Type;
import java.util.HashMap;

public  abstract class BaseMode <T> {
//    @Override/
//    public void getData(final IDataListener<T> iDataListener) {
//        RetrofitCreate.getNetApiService().getData(getHeaders(), getAPIPath(), getParmams())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(String value) {
//                            T data;
//                            data=new Gson().fromJson(value,getTypeCode());
//                            iDataListener.onGetData(data);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                            iDataListener.onGetDataFailed(1,e.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//
//    }
//
//    获取返回的数据类型 该类型必须和泛型T一致
//    public abstract Type getTypeCode();
//
//    获取参数函数如果没有参数子类没有必要实现
//    public HashMap<String, String> getParmams(){
//
//        return new HashMap<>();
//    }
//
//    判断是否为列表，重写返回true
//    public boolean isList(){
//        return false;
//    }
//    获取函数资源地址
//    public abstract String getAPIPath();
//
//    获取头部参数函数，如果没有参数子类没有必要实现
//    public HashMap<String, String> getHeaders(){
//        return new HashMap<>();
//    }
}
