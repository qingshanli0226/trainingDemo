package com.example.player.a1610aplayerdemo.net;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.player.a1610aplayerdemo.MVPApplication;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TokenInterceptor implements Interceptor {
    private SharedPreferences sp;

    @Override
    public Response intercept(Chain chain) throws IOException {

        sp = MVPApplication.instance.getSharedPreferences("tokenKey",Context.MODE_PRIVATE);
        String token = sp.getString("token","空值");

        Request request = chain.request();
        Request newRequest = request.newBuilder().addHeader("CH-TOKEN",token).build();
        return chain.proceed(newRequest);
    }
}
