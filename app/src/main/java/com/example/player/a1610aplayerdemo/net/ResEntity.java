package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.fragment.selectclass.bean.GetHomeBean;

public class ResEntity<T> {

    private String code;

    private String msg;

    private T result;//泛型， 可以是任意类型的数据

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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
