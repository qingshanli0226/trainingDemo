package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.home.mode.NetDataBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;


public interface NetApiService {

    @GET
    Observable<NetDataBean> getData(@Url String url);
}
