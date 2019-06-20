package com.example.player.a1610aplayerdemo.mvvm.base;

import com.example.player.a1610aplayerdemo.mvvm.IMode;
import com.example.player.a1610aplayerdemo.service.MyService;
import com.example.player.a1610aplayerdemo.util.MyRetorfit;

public abstract class BaseMode<T> implements IMode<T> {

    @Override
    public void getData(IDataListener<T> listener) {
        MyService service = new MyRetorfit().getService();


    }
}
