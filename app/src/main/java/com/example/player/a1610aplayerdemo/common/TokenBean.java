package com.example.yangyinonline.bean;

public class TokenBean {

    /**
     * success : true
     * message :
     * code : success
     * data : {"passportId":0,"nickName":"游客","avatar":"http://ali-files.yooshow
     * .com/app/yangyin/default.png","gender":0,"ranking":0,"score":0,
     * "accessToken":"734C23CFD8FB9FC0A3C08F07BF93D9D5","login":false}
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

    public static class DataBean {
        /**
         * passportId : 0
         * nickName : 游客
         * avatar : http://ali-files.yooshow.com/app/yangyin/default.png
         * gender : 0
         * ranking : 0
         * score : 0
         * accessToken : 734C23CFD8FB9FC0A3C08F07BF93D9D5
         * login : false
         */

        private int passportId;
        private String nickName;
        private String avatar;
        private int gender;
        private int ranking;
        private int score;
        private String accessToken;
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

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public boolean isLogin() {
            return login;
        }

        public void setLogin(boolean login) {
            this.login = login;
        }
    }
}
