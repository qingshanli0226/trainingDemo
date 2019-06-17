package com.example.player.a1610aplayerdemo.loginactivity.bean;

public class CheckBean {
    /**
     * success : true
     * message :
     * code : success
     * data : true
     */

    private boolean success;
    private String message;
    private String code;
    private boolean data;

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

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }
}
