package com.example.player.a1610aplayerdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.player.a1610aplayerdemo.Constant;
import com.example.player.a1610aplayerdemo.bean.User;

public class UserSp {
    private UserSp(){}
    private static UserSp userSp = new UserSp();
    public static UserSp getInstance(){
        return userSp;
    }

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    public void init(Context context){
        sp = context.getSharedPreferences(Constant.USER_SP, Context.MODE_PRIVATE);
    }

    public void setUserSp(String name,String pwd){
        editor = sp.edit();
        editor.putString(Constant.USER_NAME, name);
        editor.putString(Constant.USER_PWD, pwd);
        editor.apply();
    }
    public String getUserName(){
        String string = sp.getString(Constant.USER_NAME,"");
        return string == null ? null : string;
    }
    public String getUserPwd(){
        String string = sp.getString(Constant.USER_PWD, "");
        return string == null ? null : string;
    }

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
