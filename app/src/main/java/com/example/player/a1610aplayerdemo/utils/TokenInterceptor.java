package com.example.player.a1610aplayerdemo.utils;

import android.content.SharedPreferences;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Lmz on 2019/06/11
 *  token拦截器，在这里加入token
 */
public class TokenInterceptor implements Interceptor{


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest = null;
        String token = SharePresenterUtils.getToken();
        if (token != null) {
            newRequest = request.newBuilder().addHeader(Constans.TOKEN, token).build();
            return chain.proceed(newRequest);
        } else {
            return chain.proceed(request);
        }
    }
}
