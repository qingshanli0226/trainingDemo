package com.example.player.a1610aplayerdemo.bean;

public class courseInfoBean {

    /**
     * courseId : 0
     * cardId : 0
     * noPay : false
     * existCourse : false
     */

    private int courseId;
    private int cardId;
    private boolean noPay;
    private boolean existCourse;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public boolean isNoPay() {
        return noPay;
    }

    public void setNoPay(boolean noPay) {
        this.noPay = noPay;
    }

    public boolean isExistCourse() {
        return existCourse;
    }

    public void setExistCourse(boolean existCourse) {
        this.existCourse = existCourse;
    }
}
