package com.example.player.a1610aplayerdemo.base;

import com.example.player.a1610aplayerdemo.R;

public interface IBasePresenter<R> {
    void getData();
    void attachView(IBaseView<R> iBaseView);//绑定
    void detachView();//解除
}
