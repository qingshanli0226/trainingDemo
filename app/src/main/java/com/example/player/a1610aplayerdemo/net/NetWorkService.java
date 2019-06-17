package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.interface2.interface2bean.InterfaceBean;
import com.example.player.a1610aplayerdemo.interface2.interface2bean.InterfaceBean2;
import com.example.player.a1610aplayerdemo.member.bean.MemberBean;
import com.example.player.a1610aplayerdemo.my.bean.OpinionBean;
import com.example.player.a1610aplayerdemo.token.TokenBean;
import com.example.player.a1610aplayerdemo.url.ResEntity;
import com.example.player.a1610aplayerdemo.discover.bean.DiscoverBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public interface NetWorkService {
    @GET("/restapi/loading/getHome")
    Observable<ResEntity<DiscoverBean>> getHomeData();
    @POST("/restapi/account/createNew ")
    Observable<ResEntity<TokenBean>> getTokenData(@QueryMap HashMap<String,String> param);
    @GET("/restapi/masterPackage/getMasterPackagelist?minid=0&size=20")
    Observable<ResEntity<List<MemberBean>>> getMemberData();
    @POST("/restapi/app/setFeedback ")
    Observable<ResEntity<OpinionBean>> getOpinionData(@QueryMap HashMap<String,String> opint);
    @GET("/restapi/live/getLive")
    Observable<ResEntity<InterfaceBean>> getInterface(@QueryMap Map<String,String > map);
    @GET("/restapi/course/getVideo2")
    Observable<ResEntity<InterfaceBean2>> getInterface2(@QueryMap Map<String,String> map);

}
