package com.example.player.a1610aplayerdemo.bean;

import java.util.List;

public class MusicBean {

    /**
     * success : true
     * message :
     * code : success
     * data : []
     */

    private boolean success;
    private String message;
    private String code;
    private List<MusicClass> data;

    public MusicBean() {

    }

    public MusicBean(boolean success, String message, String code, List<MusicClass> data) {
        this.success = success;
        this.message = message;
        this.code = code;
        this.data = data;
    }

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

    public List<MusicClass> getData() {
        return data;
    }

    public void setData(List<MusicClass> data) {
        this.data = data;
    }
}
