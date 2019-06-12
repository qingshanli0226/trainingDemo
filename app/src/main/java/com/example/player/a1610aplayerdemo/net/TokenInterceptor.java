package com.example.player.a1610aplayerdemo.net;


import java.io.IOException;

import android.util.Log;
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

        String token = SpUtil.getToken();
        Log.d("we",token);

        System.out.println(token);

        if (token != null) {

            newRequest = request.newBuilder().addHeader(Contants.TOKEN, token).build();

            return chain.proceed(newRequest);
        } else {
            return chain.proceed(request);
        }
    }
}
