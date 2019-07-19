package com.example.player.a1610aplayerdemo.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceToken {

    Context context;

    public SharedPreferenceToken(Context context) {
        this.context = context;
    }

    public void SaveToken(String token){
        SharedPreferences sharedPreferences = context.getSharedPreferences("TokenSp",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("ddddd",token);

        edit.commit();
    }

    public void ClearToken(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("TokenSp",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.commit();
    }

    public String getToken(){
        SharedPreferences sharedPreferences = context.getSharedPreferences("TokenSp",Context.MODE_PRIVATE);
        String token = sharedPreferences.getString("token","");
        return token;
    }
}
