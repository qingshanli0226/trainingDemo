package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.home.mode.NetDataBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Url;

import java.util.HashMap;


public interface NetApiService {

    @GET
    Observable<NetDataBean> getData(@HeaderMap HashMap<String, String> headers, @Url String url);
}
