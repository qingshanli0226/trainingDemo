package com.example.player.a1610aplayerdemo.net;

public class ResEntity<T> {

    private String code;

    private String msg;

    private T data;//泛型， 可以是任意类型的数据

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
