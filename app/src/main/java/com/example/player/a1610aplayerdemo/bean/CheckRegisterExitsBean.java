package com.example.player.a1610aplayerdemo.bean;

/**
 * Created by Lmz on 2019/06/15
 */
public class CheckRegisterExitsBean {

    /**
     * success : true
     * message :
     * code : 49999
     * data :
     */

    private boolean success;
    private String message;
    private String code;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
