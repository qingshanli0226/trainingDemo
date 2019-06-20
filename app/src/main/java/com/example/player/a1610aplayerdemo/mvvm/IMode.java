package com.example.player.a1610aplayerdemo.mvvm;

import com.example.player.a1610aplayerdemo.mvvm.base.IDataListener;

public interface IMode<T> {
    void getData(IDataListener<T> listener);
}
