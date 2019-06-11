package com.example.player.a1610aplayerdemo;

import android.text.TextUtils;
import com.example.player.a1610aplayerdemo.mian.bean.UserBean;
import com.example.player.a1610aplayerdemo.utils.SPUtlis;

public class AccountManager {
    private static AccountManager instance = new AccountManager();

    private AccountManager() {
    }

    public static AccountManager getInstance() {
        return instance;
    }

    private UserBean currentUser;

    public UserBean getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserBean currentUser) {
        this.currentUser = currentUser;
    }

    public void SaveToken(String token){
        SPUtlis.saveToken(token);
    }

    public String getToken(){
        if(currentUser == null){
            String token = SPUtlis.getToken();
            if(TextUtils.isEmpty(token)){
                return null;
            }else{
                return token;
            }
        }else{
            return currentUser.getData().getAccessToken();
        }
    }
}
