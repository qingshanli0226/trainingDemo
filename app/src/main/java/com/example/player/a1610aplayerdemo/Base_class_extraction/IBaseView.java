package com.example.player.a1610aplayerdemo.Base_class_extraction;

import java.util.List;

public interface IBaseView<T> {
    void onLoadDataList(List<T> date);
    void onLoadDateBean(T date);
    void onLoadEeeor(int code,String message);

}
