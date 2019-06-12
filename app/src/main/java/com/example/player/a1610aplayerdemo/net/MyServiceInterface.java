package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.home.bean.HomeBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyServiceInterface {

    @GET("loading/getHome")
    Observable<HomeBean> getData();

}