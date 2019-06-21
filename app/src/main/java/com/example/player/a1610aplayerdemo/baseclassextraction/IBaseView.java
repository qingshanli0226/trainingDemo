package com.example.player.a1610aplayerdemo.baseclassextraction;

import java.util.List;

public interface IBaseView<T> {
    void onLoadDataList(List<T> date);
    void onLoadDateBean(T date);
    void onLoadEeeor(int code,String message);

}
