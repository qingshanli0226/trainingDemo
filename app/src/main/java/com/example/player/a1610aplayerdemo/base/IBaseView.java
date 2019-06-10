package com.example.player.a1610aplayerdemo.base;

import java.util.List;

public interface IBaseView<T> {
    void onloadData(List<T> data);
    void onLoadError(int code,String message);
}
