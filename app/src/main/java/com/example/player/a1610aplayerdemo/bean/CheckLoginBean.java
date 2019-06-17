package com.example.player.a1610aplayerdemo.bean;

/**
 * Created by Lmz on 2019/06/15
 *  检查是否注册过
 */
public class CheckLoginBean {

    /**
     * success : true
     * message :
     * code : success
     * data : false
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
