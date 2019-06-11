package com.example.player.a1610aplayerdemo.bean;

public class UserBean {

    /**
     * passportId : 0
     * nickName : 游客
     * avatar : http://ali-files.yooshow.com/app/yangyin/default.png
     * gender : 0
     * ranking : 0
     * score : 0
     * accessToken : 2D286EC4B2B32BBC10BC604E15837D42
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
