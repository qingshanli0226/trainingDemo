package com.example.player.a1610aplayerdemo.base;

import java.util.List;

/**
 * Created by Lmz on 2019/06/10
 */
public interface IBaseView<T> {
    void loadDataSuccess(T bean);
    void LoadListDataSuccess(List<T> data);
    void loadDataFailure(int code,String ErrorMess);
}
