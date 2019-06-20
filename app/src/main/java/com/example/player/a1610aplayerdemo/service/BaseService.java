package com.example.player.a1610aplayerdemo.service;

import com.example.player.a1610aplayerdemo.bean.*;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.*;

import java.util.HashMap;
import java.util.Map;

public interface BaseService {
//    http://api.immedc.com/restapi/loading/getHome HTTP/1.1
//    http://api.immedc.com/restapi/account/createNew HTTP/1.1
//    http://api.immedc.com/restapi/masterPackage/getMasterPackagelist?minid=0&size=20
//    http://api.immedc.com/restapi/category/getPerfesional?pid=1
//    http://api.immedc.com/restapi/live/getMasterlives?grade=0&page=1&size=20
//    http://api.immedc.com/restapi/szrz/getCategory
//    http://api.immedc.com/restapi/course/getVideo2?courseId=31&packageId=0
    @GET("{path1}/{path2}")
    Observable<String> getData(@Path("path1") String path1,@Path("path2") String path2, @QueryMap HashMap<String, String> params);


    @POST("account/createNew")
    Observable<TokenBean>  getTokenData(@QueryMap Map<String,String> map);


}
