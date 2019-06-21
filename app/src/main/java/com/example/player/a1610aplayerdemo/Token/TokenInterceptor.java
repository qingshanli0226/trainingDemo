package com.example.player.a1610aplayerdemo.Token;

import android.util.Log;
import com.example.player.a1610aplayerdemo.Contants;
import com.example.player.a1610aplayerdemo.utils.SharePresenterUtils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        String token=SharePresenterUtils.getToken();
        Request newRequest=null;
        Request request= chain.request();
        Log.d("token", "intercept: "+token);
        if (token != null) {
            newRequest=request.newBuilder().addHeader(Contants.TOKEN, token).build();
            return chain.proceed(newRequest);
        }else {
            return chain.proceed(request);
        }

    }
}
