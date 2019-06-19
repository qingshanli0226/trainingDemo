package com.example.player.a1610aplayerdemo.Base_class_extraction;

import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreatorUse;
import com.google.gson.Gson;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

public abstract class BasePresenter<T> implements IBasePresenter<T>{

    protected IBaseView<T> iBaseView;

    @Override
    public void loadDataByGet() {
        RetrofitCreatorUse.getApiService().getData(getHeaders(),getAPIPath(),getParmams())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }
                    @Override
                    public void onNext(String s) {
                        if (isList()){
                            ResEntity<List<T>> resEntity = null;
                            resEntity = new Gson().fromJson(s,getDataType());
                            if (resEntity.getCode().equals("success")){

                                iBaseView.onLoadDataList(resEntity.getData());
                            }
                        }else {
                            ResEntity<T> resEntity = null;

                            resEntity = new Gson().fromJson(s,getDataType());

                            if (resEntity.getCode().equals("success")){
                                iBaseView.onLoadDateBean(resEntity.getData());
                            }
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        iBaseView.onLoadEeeor(1,e.toString());
                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachView(IBaseView<T> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }

    public HashMap<String,String> getParmams(){
        return new HashMap<>();
    }
    public HashMap<String,String> getHeaders(){
        return new HashMap<>();
    }
    public boolean isList() {
        return false;
    }


    public abstract String getAPIPath();
    public abstract Type getDataType();
}
