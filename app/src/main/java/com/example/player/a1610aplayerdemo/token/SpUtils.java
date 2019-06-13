package com.example.player.a1610aplayerdemo.token;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.player.a1610aplayerdemo.MyApplication;
import com.example.player.a1610aplayerdemo.net.Contance;

public class SpUtils {
    private static SpUtils spUtils = new SpUtils();
    private SharedPreferences sharedPreferences = MyApplication.m_context.getSharedPreferences(Contance.TOKEN, Context.MODE_PRIVATE);

    private SpUtils(){

    }

    public static SpUtils getSpUtils(){
        return spUtils;
    }

    public void  saveToken(String token){
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(Contance.TOKEN,token);
        edit.commit();
    }

    public String getToken(){
        String token = sharedPreferences.getString(Contance.TOKEN, "");
        return token;
    }
}

