package com.example.player.a1610aplayerdemo.home.service;

import com.example.player.a1610aplayerdemo.home.HomeBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyService  {
    @GET("/restapi/loading/getHome")
    Observable<HomeBean> getHomeBean();




}
