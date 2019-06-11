package com.example.player.a1610aplayerdemo.base;

public interface IBaseView<T> {
    void onLoadData(T data);
    void onLoadError(int code,String message);
}
