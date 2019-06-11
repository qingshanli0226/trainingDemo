package com.example.player.a1610aplayerdemo.net;

import io.reactivex.functions.Function;

public class NetFunction<R extends ResEntity<T>,T> implements Function<R,T> {
    @Override
    public T apply(R input) throws Exception {
        if(input.getCode().equals("success")){
            return input.getData();
        }
        return null;
    }
}
