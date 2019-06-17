package com.example.player.a1610aplayerdemo.bean;

import java.io.Serializable;

/**
 * Created by Lmz on 2019/06/17
 */
public class SetPasswordBean implements Serializable {

    /**
     * success : true
     * message :
     * code : success
     * data : {"passportId":231478,"nickName":"15936319299","avatar":"http://ali-files.yooshow.com/app/yangyin/default.png","gender":0,"ranking":0,"score":0,"courseInfo":{"courseId":0,"cardId":0,"noPay":false,"existCourse":false},"login":true}
     */

    private boolean success;
    private String message;
    private String code;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * passportId : 231478
         * nickName : 15936319299
         * avatar : http://ali-files.yooshow.com/app/yangyin/default.png
         * gender : 0
         * ranking : 0
         * score : 0
         * courseInfo : {"courseId":0,"cardId":0,"noPay":false,"existCourse":false}
         * login : true
         */

        private int passportId;
        private String nickName;
        private String avatar;
        private int gender;
        private int ranking;
        private int score;
        private CourseInfoBean courseInfo;
        private boolean login;

        public int getPassportId() {
            return passportId;
        }

        public void setPassportId(int passportId) {
            this.passportId = passportId;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getRanking() {
            return ranking;
        }

        public void setRanking(int ranking) {
            this.ranking = ranking;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public CourseInfoBean getCourseInfo() {
            return courseInfo;
        }

        public void setCourseInfo(CourseInfoBean courseInfo) {
            this.courseInfo = courseInfo;
        }

        public boolean isLogin() {
            return login;
        }

        public void setLogin(boolean login) {
            this.login = login;
        }

        public static class CourseInfoBean {
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
    }
}
