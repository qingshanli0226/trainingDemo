package com.example.player.a1610aplayerdemo.net;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest = request.newBuilder().addHeader("CH-TOKEN","26BC5FBA0B8ECAA284B4BFC4C2F96B78").build();
        return chain.proceed(newRequest);
    }
}
