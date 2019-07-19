package com.example.player.a1610aplayerdemo.ui.mvvmzaixianzhibo.mvvmbase;

public interface IDataListener<T> {
    void onGetData(T date);
    void onGetDataFailed(int code, String message);

}
