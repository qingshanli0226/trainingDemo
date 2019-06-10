package com.example.player.a1610aplayerdemo.base;

public interface IBasePresenter<R> {
    void getData(); // 在列表展示数据，需要通过present在网络或者数据库中获取数据
    void attachView(IBaseView<R> iBaseView);// presenter 绑定view
    void detachView();// 在activity或者fragment 销毁时，调用该方法， 将 Iview 置空，避免内存泄露
}
