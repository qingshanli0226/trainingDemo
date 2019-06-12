package com.example.player.a1610aplayerdemo.net;


import java.io.IOException;

import com.example.player.a1610aplayerdemo.Contants;
import com.example.player.a1610aplayerdemo.util.SpUtil;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();//去拿到request请求对象
        Request newRequest = null;
        if (SpUtil.getToken() != null) {

            newRequest = request.newBuilder().addHeader(Contants.TOKEN, SpUtil.getToken()).build();

            return chain.proceed(newRequest); //将生成带token的newRequest做为请求参数进行网络请求
        } else {
            return chain.proceed(request); //如果没有token,使用老的不带token参数的request，去进行网络请求.
        }
    }
}
