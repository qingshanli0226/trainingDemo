package com.example.player.a1610aplayerdemo.net;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest = request.newBuilder().addHeader("CH-TOKEN","F173B5AA23C2C9E4694A4B993B259004").build();
        return chain.proceed(newRequest);
    }
}