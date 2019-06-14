package com.example.player.a1610aplayerdemo.utils;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lmz on 2019/06/13
 *  全能bean类
 */
public class EntityUtils<T> {
    @SerializedName("success")
    private String success;
    @SerializedName("message")
    private String message;
    @SerializedName("code")
    private String code;
    private T data;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
