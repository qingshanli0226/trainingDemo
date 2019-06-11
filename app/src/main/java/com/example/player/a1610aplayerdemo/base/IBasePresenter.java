package com.example.player.a1610aplayerdemo.base;

public interface IBasePresenter<R> {
   void getData();//获取网络请求数据
   void attachView(IBaseView<R> iBaseView);//绑定View
   void detachView();//置空IView
}
