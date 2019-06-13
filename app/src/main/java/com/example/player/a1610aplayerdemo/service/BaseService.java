package com.example.player.a1610aplayerdemo.service;

import com.example.player.a1610aplayerdemo.bean.MemberBean;
import com.example.player.a1610aplayerdemo.bean.TokenBean;
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
}
