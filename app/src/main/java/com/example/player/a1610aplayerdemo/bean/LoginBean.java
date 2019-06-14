package com.example.player.a1610aplayerdemo.bean;

public class LoginBean {
    /**
     * success : false
     * message : 请登录
     * code : LoginRequired
     */

    private boolean success;
    private String message;
    private String code;

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
}
