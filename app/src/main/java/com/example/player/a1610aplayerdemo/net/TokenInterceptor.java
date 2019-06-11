package com.example.player.a1610aplayerdemo.net;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request().newBuilder().addHeader("CH-TOKEN","4FDD760BDD0B0FCEC7DA7A96573B8954").build();


        return chain.proceed(request); //将生成带token的newRequest做为请求参数进行网络请求

    }
}
