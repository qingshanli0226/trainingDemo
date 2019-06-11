package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.AccountManager;
import com.example.player.a1610aplayerdemo.Content;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public  class TokenIntercepter implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request newRequest = null;
        Request request = chain.request();
        if(AccountManager.getInstance().getToken() != null){
            newRequest = request.newBuilder()
                    .addHeader(Content.USER_TOKEN,AccountManager.getInstance().getToken())
                    .build();
            return chain.proceed(newRequest);
        }else{
            return chain.proceed(request);
        }

    }
}
