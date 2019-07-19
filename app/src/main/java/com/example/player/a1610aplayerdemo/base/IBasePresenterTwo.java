package com.example.player.a1610aplayerdemo.base;

public interface IBasePresenterTwo<R> {
    void getData();  //获取请求的网络数据
    void attachView(IBaseViewTwo<R> iBaseView); //绑定view
    void detachView();//制空IView
}
