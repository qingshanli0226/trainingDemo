package com.example.player.a1610aplayerdemo.base;

import java.util.List;

public interface BaseView<T> {
    void onLoadData(T datalist);
    void onLoadError(int code,String str);
}
