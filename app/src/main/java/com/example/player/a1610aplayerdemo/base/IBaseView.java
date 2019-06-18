package com.example.player.a1610aplayerdemo.base;


public interface IBaseView<T> {
    void onLoadDataBean(T data); //返回一个对象
    void onLoadError(int code , String message);

}
