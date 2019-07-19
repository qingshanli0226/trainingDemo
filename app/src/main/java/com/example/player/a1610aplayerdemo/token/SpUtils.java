package com.example.player.a1610aplayerdemo.token;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.player.a1610aplayerdemo.MyApplication;
import com.example.player.a1610aplayerdemo.net.Contant;

public class SpUtils {
    private static SpUtils spUtils = new SpUtils();
    private SharedPreferences sharedPreferences = MyApplication.m_context.getSharedPreferences(Contant.TOKEN, Context.MODE_PRIVATE);

    private SpUtils(){

    }

    public static SpUtils getSpUtils(){
        return spUtils;
    }

    public void  saveToken(String token){
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(Contant.TOKEN,token);
        edit.commit();
    }

    public String getToken(){
        String token = sharedPreferences.getString(Contant.TOKEN, "");
        return token;
    }
}

