package com.example.player.a1610aplayerdemo.base;

public interface IBasePresenter<R> {

    void getData();
    void attachView(IBaseView<R> iBaseView);
    void detachView();

}