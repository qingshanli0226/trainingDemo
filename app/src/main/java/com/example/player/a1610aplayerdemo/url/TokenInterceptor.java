package com.example.player.a1610aplayerdemo.url;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        SharedPreferences sharedPreferences=MyApplication.preferences;
        String s=sharedPreferences.getString("token","");
        Request request=chain.request().newBuilder().addHeader("CH-TOKEN",s).build();
        return chain.proceed(request);
    }
}
