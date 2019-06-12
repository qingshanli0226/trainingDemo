package com.example.player.a1610aplayerdemo.net;

import io.reactivex.functions.Function;

public class NetFunction<R extends ResEntity<T>, T> implements Function<R, T> {
    @Override
    public T apply(R input) {
        if (input.getCode().equals("200")) {//获取数据成功
            return input.getResult();
        } else if (input.getCode().equals("1006")) {//代表token失效
            throw new TokenException("token is expire.");
        } else if (input.getResult() == null) {
            throw new RuntimeException("code = " + input.getCode() + " error msg = " + "获取数据为空");
        } else {
            throw new RuntimeException("code = " + input.getCode() + " error msg = " + input.getMsg());
        }
    }
}
