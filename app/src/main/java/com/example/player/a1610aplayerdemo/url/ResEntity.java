package com.example.player.a1610aplayerdemo.url;

import android.util.Log;

public class ResEntity<T> {
    private String code;
    private String message;
    private String success;
    private T data;   // TODO: 2019/5/14 泛型 可以是任意类型

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
