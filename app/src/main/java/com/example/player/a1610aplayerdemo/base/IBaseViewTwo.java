package com.example.player.a1610aplayerdemo.base;

public interface IBaseViewTwo<T> {
    void onLoadDataT(T data);
    void onLoadErrorT(int code, String message);
}
