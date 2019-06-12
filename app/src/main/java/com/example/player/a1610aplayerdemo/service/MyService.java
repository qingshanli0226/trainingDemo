package com.example.player.a1610aplayerdemo.service;

import com.example.player.a1610aplayerdemo.bean.HomeBean;
import com.example.player.a1610aplayerdemo.util.Contants;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface MyService {

   @GET(Contants.GET_HOME)
   Observable<HomeBean> getHomeInfo(@Header("TOKEN")String token);



}
