package com.example.player.a1610aplayerdemo.service;

import com.example.player.a1610aplayerdemo.bean.*;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.*;

import java.util.Map;

public interface BaseService {
//    http://api.immedc.com/restapi/loading/getHome HTTP/1.1
//    http://api.immedc.com/restapi/account/createNew HTTP/1.1

    @POST("account/createNew")
    Observable<TokenBean>  getTokenData(@QueryMap Map<String,String> map);

    @GET("loading/getHome")
    Observable<ResponseBody> getHomeData();
//    http://api.immedc.com/restapi/masterPackage/getMasterPackagelist?minid=0&size=20
    @GET("masterPackage/getMasterPackagelist")
    Observable<MemberBean> getMemberData(@Query("minid")String mind, @Query("size")String size);
//    http://api.immedc.com/restapi/category/getPerfesional?pid=1
    @GET("category/getPerfesional")
    Observable<MusicClassBean> getMusicClassData(@Query("pid")String pid);
//    http://api.immedc.com/restapi/jgLm/get HTTP/1.1
    @GET("jgLm/get")
    Observable<EducationBean> getEducationData();
//    http://api.immedc.com/restapi/live/getMasterlives?grade=0&page=1&size=20
    @GET("live/getMasterlives")
    Observable<LiveBean> getLiveData(@Query("grade")String grade, @Query("page")String page,@Query("size")String size);
}
