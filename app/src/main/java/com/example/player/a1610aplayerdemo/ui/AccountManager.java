package com.example.player.a1610aplayerdemo.ui;

import android.text.TextUtils;
import com.example.player.a1610aplayerdemo.net.SP;
import com.example.player.a1610aplayerdemo.ui.bean.Bean;

public class AccountManager {
    private static AccountManager instance = new AccountManager();

    private AccountManager() {
    }

    public static AccountManager getInstance() {
        return instance;
    }

    private Bean.DataBean bean;

    public Bean.DataBean getCurrentUser() {
        return bean;
    }

    public void setCurrentUser(Bean.DataBean bean) {
        this.bean = bean;
    }

    public void SaveToken(String token){
            SP.Tokens(token);
    }

    public String getToken(){
        if(bean == null){
            String token = SP.getToken();
            if(TextUtils.isEmpty(token)){
                return null;
            }else{
                return token;
            }
        }else{
            return bean.getAccessToken();
        }
    }
}
