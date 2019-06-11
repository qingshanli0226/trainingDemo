package com.example.player.a1610aplayerdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.player.a1610aplayerdemo.Content;
import com.example.player.a1610aplayerdemo.MyApp;

public class SPUtlis {
    private static SharedPreferences sp;
    static {
        sp = MyApp.instance.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
    }

    public static void saveToken(String token){
        SharedPreferences.Editor edit = sp.edit();
        edit.putString(Content.USER_TOKEN,token);
        edit.commit();
    }

    public static String getToken(){
        return sp.getString(Content.USER_TOKEN, "");
    }
}
