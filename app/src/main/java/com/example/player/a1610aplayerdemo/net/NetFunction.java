package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.base.ResEntity;
import io.reactivex.functions.Function;

public class NetFunction<R extends ResEntity<T>,T> implements Function<R,T> {
    @Override
    public T apply(R input) throws Exception {
        if(input.getCode().equals("success")){
            return input.getData();
        }else {
            throw  new RuntimeException("code = " + input.getCode() + "error msg = " +input.getMessage());
        }

    }
}
