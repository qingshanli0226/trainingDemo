package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.member.bean.MemberBean;
import com.example.player.a1610aplayerdemo.token.TokenBean;
import com.example.player.a1610aplayerdemo.url.ResEntity;
import com.example.player.a1610aplayerdemo.discover.bean.DiscoverBean;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

import java.util.HashMap;
import java.util.List;


public interface NetWorkService {
    @GET("/restapi/loading/getHome")
    Observable<ResEntity<DiscoverBean>> getHomeData();
    @POST("/restapi/account/createNew ")
    Observable<ResEntity<TokenBean>> getTokenData(@QueryMap HashMap<String,String> param);
    @GET("/restapi/masterPackage/getMasterPackagelist?minid=0&size=20")
    Observable<ResEntity<List<MemberBean>>> getMemberData();
}
