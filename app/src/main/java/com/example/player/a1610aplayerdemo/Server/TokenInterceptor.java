package com.example.player.a1610aplayerdemo.Server;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TokenInterceptor implements Interceptor {

    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        Request newRequest = request.newBuilder().addHeader("CH-TOKEN","BE46DFAA67FE0C41D3A03D5B1E087706").build();
        return chain.proceed(newRequest);
    }
}
