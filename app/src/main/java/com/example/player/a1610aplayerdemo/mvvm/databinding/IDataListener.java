package com.example.player.a1610aplayerdemo.mvvm.databinding;

public interface IDataListener<T> {
    void onGetData(T data);
    void onGetDataFailed(int code,String message);
}
