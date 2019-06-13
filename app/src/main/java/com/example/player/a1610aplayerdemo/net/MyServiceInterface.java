package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.ui.home.bean.HomeBean;
import com.example.player.a1610aplayerdemo.ui.member.bean.MemberBean;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Query;

import java.util.Map;

public interface MyServiceInterface {

    @GET("loading/getHome")
    Observable<HomeBean> getData();

    //http://api.immedc.com/restapi/masterPackage/getMasterPackage?packageId=4&type=0&level=0&lastId=0&size=2147483647
    @GET("masterPackage/getMasterPackage")
    Observable<MemberBean> getDataTwo(@Query("packageId")String packageId, @Query("type")String type, @Query("level")String level, @Query("lastId")String lastId, @Query("size")String size);

    @GET("/")
    Call<ResponseBody> foo(@Header("CH-TOKEN")String lang);

    @GET("/search")
    Call<ResponseBody> list(@HeaderMap Map<String,String> headers);

}