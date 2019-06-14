package com.example.player.a1610aplayerdemo.utils;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class NetUtils {
    private static NetUtils instance;
    private INetCallback iNetCallback;

    public static NetUtils getInstance() {
        if (instance == null){
            initNetUtils();
            return instance = new NetUtils();
        }
        return instance;
    }

    private static void initNetUtils() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L,TimeUnit.MILLISECONDS).build();
        OkHttpUtils.initClient(okHttpClient);
    }

    public NetUtils doGet(String url, Map map){
        OkHttpUtils.get().url(url).params(map).build().execute(new StringCallback() {
            @Override
            public void onBefore(Request request, int id) {
                super.onBefore(request, id);
            }

            @Override
            public void onError(Call call, Exception e, int id) {
                iNetCallback.onError(e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                iNetCallback.response(response);
            }

            @Override
            public void onAfter(int id) {
                super.onAfter(id);
            }
        });
        return instance;
    }

    public NetUtils doPost(String url,Map map){
        OkHttpUtils.post().url(url).params(map).build().execute(new StringCallback() {
            @Override
            public void onBefore(Request request, int id) {
                super.onBefore(request, id);
            }

            @Override
            public void onError(Call call, Exception e, int id) {
                iNetCallback.onError(e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                iNetCallback.response(response);
            }

            @Override
            public void onAfter(int id) {
                super.onAfter(id);
            }
        });
        return instance;
    }

    public interface INetCallback{
        void onError(String error);
        void response(String response);
    }

    public NetUtils OnINetCallback(INetCallback iNetCallback){
        this.iNetCallback = iNetCallback;
        return instance;
    }

}