package com.example.player.a1610aplayerdemo.base;

public class ResEntity<T> {

    /**
     * success : true
     * message :
     * code : success
     * data : {"passportId":0,"nickName":"游客","avatar":"http://ali-files.yooshow.com/app/yangyin/default.png","gender":0,"ranking":0,"score":0,"courseInfo":{"courseId":0,"cardId":0,"noPay":false,"existCourse":false},"vip":false,"login":false}
     */

    private boolean success;
    private String message;
    private String code;
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
