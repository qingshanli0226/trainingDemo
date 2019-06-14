package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.base.ResEntity;
import io.reactivex.functions.Function;

public class Functions<R extends ResEntity<T>,T> implements Function<R,T> {
    @Override
    public T apply(R r) throws Exception {
        if (r.getCode().equals("success")){
            return r.getData();
        }else {
            throw new RuntimeException("code = " + r.getCode() + "error msg = " + r.getMessage());
        }
    }
}