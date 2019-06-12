package com.example.player.a1610aplayerdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.example.player.a1610aplayerdemo.Constant;

public class TokenSp {
    private TokenSp() {
    }

    private static TokenSp tokenSp = new TokenSp();

    public static TokenSp getInstance() {
        return tokenSp;
    }

    private SharedPreferences sp;
    private SharedPreferences.Editor edit;

    public void init(Context context) {
        sp = context.getSharedPreferences(Constant.TOKEN, Context.MODE_PRIVATE);
    }

    public void saveToken(String token) {
        edit = sp.edit();
        edit.putString(Constant.TOKEN, token);
        edit.apply();
        getToken();
    }

    public String getToken() {

        String string = sp.getString(Constant.TOKEN, "");
        Log.e("456", "getToken: " + string);
        return string;
    }
}
