package com.example.player.a1610aplayerdemo.base;

import android.util.Log;

import com.example.player.a1610aplayerdemo.utils.EntityUtils;
import com.example.player.a1610aplayerdemo.utils.ErrorUtils;
import com.example.player.a1610aplayerdemo.utils.MVPObervice;
import com.example.player.a1610aplayerdemo.utils.RetrofitCreate;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lmz on 2019/06/14
 *   优化代码把所有 presenter 共同的方法 提取出来
 */
public abstract class BasePresenter<T> implements IBasePresenter<T> {
    //声明一个ibaseview 的成员变量，因为在抽象类当中，所以需要实现一定的业务逻辑
    protected IBaseView<T> iBaseView;
    @Override
    public void getData() {
        Log.i("basep",getApiPath()+"====="+getParmars());
            RetrofitCreate.getNetApiService().getData(getHearder(),getApiPath(),getApiPath2(),getParmars())
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new MVPObervice<String>(){
                                    @Override
                                    public void onNext(String s) {
                                        super.onNext(s);
                                        if (isList()){
                                            //如果是列表数据
                                            EntityUtils<List<T>> result =null;
                                            //通过子类传入的是数据类型,去给定值
                                            result =new Gson().fromJson(s,getType());
                                            iBaseView.LoadListDataSuccess(result.getData());
                                        }else {
                                            EntityUtils<T> result =null;
                                            result =new Gson().fromJson(s,getType());
                                            String simpleName = result.getData().getClass().getSimpleName();
                                            Log.i("json",simpleName);
                                            iBaseView.loadDataSuccess(result.getData());
                                        }
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        super.onError(e);
                                        iBaseView.loadDataFailure(101,e.toString());
                                        ErrorUtils.ErrorMess(e);
                                    }
                                });
    }

    /**
     *   返回参数，如果网络请求不需要参数，可以不写
     * @return
     */
    public HashMap<String,String> getParmars(){
        return new HashMap<>();
    }

    /**
     *  返回头部。根据需求判断是否需要实现
     * @return
     */
    public HashMap<String,String> getHearder(){
        return new HashMap<>();
    }

    //判断返回的类型是否是 集合  默认为false
    public boolean isList(){
        return false;
    }

    /**
     *  获取api地址， 抽象方法必写
     * @return
     */
    public abstract String getApiPath();
    public abstract String getApiPath2();

    /**
     *   返回数据的类型，必写
     * @return
     */
    public abstract Type getType();

    @Override
    public void attachView(IBaseView<T> view) {

            iBaseView = view;
    }

    @Override
    public void detachView() {
            if (iBaseView !=null){
                iBaseView = null;
            }
    }
}
