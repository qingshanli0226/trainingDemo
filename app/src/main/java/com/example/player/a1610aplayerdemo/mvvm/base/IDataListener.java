package com.example.player.a1610aplayerdemo.mvvm.base;

public interface IDataListener<T>{
    void onGetData();
    void onGetDataFailed(int code,String message);
}
