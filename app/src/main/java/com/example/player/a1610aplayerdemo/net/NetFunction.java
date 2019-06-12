package com.example.player.a1610aplayerdemo.net;

import io.reactivex.functions.Function;

public class NetFunction<R extends ResEntity<T>, T> implements Function<R,T> {

    @Override
    public T apply(R r) {
        if (r.getCode().equals("success")) {
            return r.getdata();
        } else {
            throw new TokenException("没有成功");
        }
//        return null;
    }
}
