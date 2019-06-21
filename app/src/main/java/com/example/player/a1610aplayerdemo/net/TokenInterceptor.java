package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.ui.AccountManager;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
//        Request request = chain.request();
//        Request newRequest = request.newBuilder().addHeader("CH-TOKEN","F173B5AA23C2C9E4694A4B993B259004").build();

        Request request = null;
        Request newRequest = chain.request();
        if (AccountManager.getInstance().getToken() != null){
            request = newRequest.newBuilder()
                    .addHeader(Contants.TOKEN,AccountManager.getInstance().getToken())
                    .build();
            return chain.proceed(request);
        }else {
            return chain.proceed(newRequest);
        }
//        return chain.proceed(newRequest);
    }
}