package com.example.player.a1610aplayerdemo.base;

public interface IBasePresenter<R> {
    void getData();  //获取请求的网络数据
    void attachView(IBaseView<R> iBaseView); //绑定view
    void detachView();//制空IView
}
