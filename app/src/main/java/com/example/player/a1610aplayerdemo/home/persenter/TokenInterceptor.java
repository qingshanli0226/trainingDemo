package com.example.player.a1610aplayerdemo.home.persenter;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest = request.newBuilder().addHeader("CH-TOKEN","4046381F8C1C2C1D0A4AB66B15205D7B").build();
        return chain.proceed(newRequest);
    }
}
