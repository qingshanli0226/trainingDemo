package com.example.player.a1610aplayerdemo.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

//定义一个拦截器，该拦截器在请求头部添加token。
public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();//去拿到request请求对象
        Request newRequest = null;
        if (Contance.TOKEN != null) {
            //在请求头部添加一个keyvalue形式的参数，将token值添加进去.
            newRequest = request.newBuilder().addHeader("CH-TOKEN:" ,Contance.TOKEN ).build();
            return chain.proceed(newRequest); //将生成带token的newRequest做为请求参数进行网络请求
        } else {
            return chain.proceed(request); //如果没有token,使用老的不带token参数的request，去进行网络请求.
        }
    }
}