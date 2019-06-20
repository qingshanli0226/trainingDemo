package com.example.player.a1610aplayerdemo.mvvm.base;

public interface IMode<T> {
    void getData(IDataListener<T> listener);
}
