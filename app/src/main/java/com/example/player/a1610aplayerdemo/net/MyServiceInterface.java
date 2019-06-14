package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.base.ResEntity;
import com.example.player.a1610aplayerdemo.ui.bean.Bean;
import com.example.player.a1610aplayerdemo.ui.home.bean.HomeBean;
import com.example.player.a1610aplayerdemo.ui.member.bean.MemberBean;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.*;

import java.util.Map;

public interface MyServiceInterface {

    @GET("loading/getHome")
    Observable<HomeBean> getData();

    @GET("loading/getHome")
    Observable<ResEntity<HomeBean.DataBean>> getHomeBean(@HeaderMap Map<String,String> map);

    //todo http://api.immedc.com/restapi/masterPackage/getMasterPackagelist?minid=0&size=20
    @GET("masterPackage/getMasterPackagelist")
    Observable<MemberBean> getDataTwo(@HeaderMap Map<String,String> map,@Query("minid")String minid,@Query("size")String size);

    @GET("/")
    Observable<ResEntity> foo(@Header("CH-TOKEN")String lang);

    @POST("account/createNew")
    Observable<ResEntity<Bean.DataBean>> getUser(@QueryMap Map<String,String> headers);

}