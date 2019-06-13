package com.example.player.a1610aplayerdemo.base;

public interface IBasePresenter<T> {

    void getData();
    void attachView(IBaseView<T> baseView);
    void detachView();

}
