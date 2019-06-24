package com.example.player.a1610aplayerdemo.base;

public interface BasePersenter<R>{
    void getData();
    void attachview(BaseView<R> baseView);
    void destoryView();
}
