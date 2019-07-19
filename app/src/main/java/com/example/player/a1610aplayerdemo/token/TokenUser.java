package com.example.player.a1610aplayerdemo.token;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.player.a1610aplayerdemo.MVPApplication;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;

public class TokenUser implements Interceptor {
    private SharedPreferences sp;

    @Override
    public Response intercept(Chain chain) throws IOException {

        sp = MVPApplication.instance.getSharedPreferences("tokenKey",Context.MODE_PRIVATE);
        String token = sp.getString("token","空值");

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("CH-TOKEN",token);
        hashMap.put("",")");

        Request request = chain.request();
        Request newRequest = request.newBuilder().addHeader("CH-TOKEN",token)
                .addHeader("User-Agent","Dalvik/1.6.0 (Linux; U; Android 4.4.2; MI 6  Build/NMF26X").build();

        return chain.proceed(newRequest);
    }
}
