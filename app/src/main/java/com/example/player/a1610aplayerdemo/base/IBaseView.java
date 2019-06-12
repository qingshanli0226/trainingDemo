package com.example.player.a1610aplayerdemo.base;


import java.util.List;

/**
 * 因为该接口，无法确定返回数据类型，所以使用泛型来定义接口
 * @param <T>
 */
public interface IBaseView<T> {
    void onLoadDataList(List<T> data);//返回一个列表
    void onLoadDataBean(T data); //返回一个对象
    void onLoadError(int code, String message);
}
