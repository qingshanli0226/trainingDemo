package com.example.player.a1610aplayerdemo.net;

public class ResEntity<T> {
    private String code;
    private String message;
    private String success;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    public T getdata() {
        return data;
    }

    public void setdata(T data) {
        this.data = data;
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
}
