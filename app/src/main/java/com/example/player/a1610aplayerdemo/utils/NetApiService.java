package com.example.player.a1610aplayerdemo.utils;

import com.example.player.a1610aplayerdemo.bean.MemberBean;
import com.example.player.a1610aplayerdemo.bean.HomeBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Lmz on 2019/06/10
 *  网络接口api
 */
public interface NetApiService {
        //  第一次进入获取token   http://api.immedc.com/restapi/account/createNew HTTP/1.1

    @POST("account/createNew")
    Observable<ResponseBody> FirstInAndGetToken(@QueryMap Map<String,String> map);

    // 引导页   http://api.immedc.com/restapi/loading/getStartBanner
    @GET("loading/getStartBanner")
    Observable<ResponseBody> getSplashInfo();

    //          http://api.immedc.com/restapi/loading/getHome   home主页
    @GET("loading/getHome")
    Observable<HomeBean> getFindInfo();
    // 会员页面   http://api.immedc.com/restapi/masterPackage/getMasterPackagelist?minid=0&size=20
    @GET("masterPackage/getMasterPackagelist")
    Observable<MemberBean> getMemberViewInfo(@Query("minid")int minid,@Query("size")int size);


    //代码的优化，对api进行一个共同方法的优化，完成目标 一个api可适用于全部网络请求。
    @GET("{path}/{path2}")
    Observable<String> getData(@HeaderMap HashMap<String,String> heardmap, @Path(value = "path")String path,@Path(value = "path2")String path2,@QueryMap HashMap<String,String> map);

    @POST("{path}/{path2}")
    Observable<String> getDataByPost(@HeaderMap HashMap<String,String> heardmap,@Path("path")String path,@Path("path2")String path2,@QueryMap HashMap<String,String> map);

}
