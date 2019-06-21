package com.example.player.a1610aplayerdemo.ui;

import android.text.TextUtils;
import com.example.player.a1610aplayerdemo.net.SP;
import com.example.player.a1610aplayerdemo.ui.bean.TokenBean;

public class AccountManager {
    private static AccountManager instance = new AccountManager();

    private AccountManager() {
    }

    public static AccountManager getInstance() {
        return instance;
    }

    private TokenBean.DataBean bean;

    public TokenBean.DataBean getCurrentUser() {
        return bean;
    }

    public void setCurrentUser(TokenBean.DataBean bean) {
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
