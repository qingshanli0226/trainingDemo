package com.example.player.a1610aplayerdemo.mistake;

import io.reactivex.functions.Function;

public class NetFunction<R extends ResEntity<T>,T> implements Function<R,T> {

    @Override
    public T apply(R input) {
        if(input.getCode().equals("success")){
            return input.getData();
        }else if (input.getData() == null) {
            throw new RuntimeException("code = " + input.getCode() + " error msg = " + "获取数据为空");
        }else {
            throw new RuntimeException("code = " + input.getCode() + " error msg =" + input.getMessage());
        }
    }
}
