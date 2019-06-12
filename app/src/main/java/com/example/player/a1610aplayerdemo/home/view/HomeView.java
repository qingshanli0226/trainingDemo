package com.example.player.a1610aplayerdemo.home.view;

public interface HomeView<T> {
    void onLoadData(T data);
    void onErrorData(String errorString);


}
