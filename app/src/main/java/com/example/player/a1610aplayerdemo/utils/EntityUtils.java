package com.example.player.a1610aplayerdemo.utils;

/**
 * Created by Lmz on 2019/06/13
 *  全能bean类
 */
public class EntityUtils<T> {
    private boolean success;
    private String message;
    private String code;
    private T result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
