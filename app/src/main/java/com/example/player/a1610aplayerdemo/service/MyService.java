package com.example.player.a1610aplayerdemo.service;

import com.example.player.a1610aplayerdemo.bean.HomeBean;
import com.example.player.a1610aplayerdemo.bean.LoginBean;
import com.example.player.a1610aplayerdemo.bean.VipBean;
import com.example.player.a1610aplayerdemo.util.Contants;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface MyService {

   //http://api.immedc.com/restapi/loading/getHome HTTP/1.1
   @GET(Contants.GET_HOME)
   Observable<HomeBean> getHomeInfo(@Header("TOKEN")String token);

   //http://api.immedc.com/restapi/?minid=0&size=20
   @GET(Contants.GET_VIP)
   Observable<VipBean> getVipInfo(@Query("minid")String minid,@Query("size")String size);

   //http://api.immedc.com/restapi/masterPackage/getMyMasterPackage?packageId=16&lastId=0&size=20
   @GET(Contants.GET_LOGIN)
   Observable<LoginBean> getLoginInfo(@Header("TOKEN")String token,@Query("packageId")String packageId,@Query("lastId")String lastId,@Query("size")String size);

//http://api.immedc.com/restapi/category/getPerfesional?pid=1



}
