package com.example.player.a1610aplayerdemo.net;

import io.reactivex.functions.Function;

public class MyNetFunction <R extends ResEntity<T>, T>  implements Function<R,T> {

    @Override
    public T apply(R r) {
        if (r.getCode().equals("200")) {
            return r.getResult();
        } else if (r == null) {
            throw new RuntimeException("code = " + r.getCode() + " error msg = " + "获取数据为空");
        } else {
            throw new RuntimeException("code = " + r.getCode() + " error msg = " + r.getMsg());
        }
    }
}