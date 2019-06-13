package com.example.player.a1610aplayerdemo.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.util.Log;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TokenInterceptor implements Interceptor{

    SharedPreferenceToken sharedPreferenceToken;
     @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        sharedPreferenceToken = new SharedPreferenceToken(MyApplication.application);
         Log.i("拦截器的token",sharedPreferenceToken.getToken());
        Request request = chain.request();
        Request newRequest = request.newBuilder().addHeader("CH-TOKEN",sharedPreferenceToken.getToken()).build();
        return chain.proceed(newRequest);
    }
}
