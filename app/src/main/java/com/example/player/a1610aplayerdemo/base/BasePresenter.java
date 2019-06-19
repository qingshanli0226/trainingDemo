package com.example.player.a1610aplayerdemo.base;

import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreate;
import com.google.gson.Gson;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

public abstract class BasePresenter<T> implements IBasePresenter<T> {
    protected IBaseView<T> iBaseView;

    @Override
    public void loadDataByGet() {
        RetrofitCreate.getNetApiService().getData(getHeader(),getApiPath(),getParm())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String value) {
                        if (isList()){
                            ResEntity<List<T>> resEntity=new ResEntity<>();
                            resEntity=new Gson().fromJson(value,getDataType());
                            if (resEntity.getCode().equals("success")) {
                                iBaseView.onLoadDataList(resEntity.getdata());
                            }
                        }else {
                            ResEntity<T> resEntity=null;
                            resEntity=new Gson().fromJson(value,getDataType());
                            if (resEntity.getCode().equals("success")) {

                            }
                            iBaseView.onloadDataBean(resEntity.getdata());
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
    public boolean isList(){
        return false;
    }

    //获取参数函数，如果没有参数子类没有必要实现
    public   HashMap<String, String> getParm(){
        return new HashMap<>();
    }
    //获取函数资源地址
    public  abstract String getApiPath();
    //获取返回的数据类型
    public  abstract Type getDataType();

    //获取头部参数,如果没有参数没必要实现
    public  HashMap<String, String> getHeader(){
            return new HashMap<>();
    }

    @Override
    public void attchView(IBaseView<T> iBaseView) {
        this.iBaseView=iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView=null;
    }
}
