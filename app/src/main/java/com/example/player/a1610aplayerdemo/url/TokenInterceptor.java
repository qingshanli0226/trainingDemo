package com.example.player.a1610aplayerdemo.url;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request=chain.request().newBuilder().addHeader("CH-TOKEN","14FA8CD57964C53E703E688F34B78ED9").build();
        return chain.proceed(request);
    }
}
