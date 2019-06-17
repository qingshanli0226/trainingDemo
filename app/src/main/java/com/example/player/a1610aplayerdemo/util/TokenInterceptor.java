package com.example.player.a1610aplayerdemo.util;

import android.content.Context;
import android.content.SharedPreferences;
import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

public class TokenInterceptor implements Interceptor {
    private Context context;
    @Override
    public Response intercept(Chain chain) throws IOException {
        SharedPreferences token = context.getSharedPreferences("token", Context.MODE_PRIVATE);

        return null;
    }
}
