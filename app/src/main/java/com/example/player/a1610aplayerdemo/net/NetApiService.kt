package com.example.player.a1610aplayerdemo.net

import com.example.player.a1610aplayerdemo.Contants
import com.example.player.a1610aplayerdemo.bean.*
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*
import java.util.HashMap
import retrofit2.http.QueryMap
import retrofit2.http.HeaderMap




interface NetApiService {


    @GET("{path}")
    fun getData(@HeaderMap headers: HashMap<String, String>, @Path("path") path: String, @QueryMap params: HashMap<String, String>): Observable<String>

    @POST(Contants.CREATE_NEW)
    @FormUrlEncoded
    fun getFirstInAndGetToken(@HeaderMap head : Map<String, String>,@FieldMap map:Map<String,String>): Observable<ResEntity<TokenDateBean>>

    @GET(Contants.GET_HOME)
    fun getXuanKeDate(@HeaderMap head : Map<String, String>): Observable<ResEntity<XuanKeDateBean>>

    @GET(Contants.GET_VIP)
    fun getVipDate(@HeaderMap head : Map<String, String>): Observable<ResEntity<List<VipDateBean>>>

    @GET("course/getVideo2")
    fun getTuiJianDate(@HeaderMap head : Map<String, String>,@QueryMap map:Map<String,String>): Observable<ResEntity<TuiJianDateBean>>


    @GET("live/getLive")
    fun getMasterDate(@HeaderMap head : Map<String, String>,@QueryMap map:Map<String,String>): Observable<ResEntity<MasterDateBean>>



    @GET("category/getPerfesional")
    fun getMusicClassDate(@HeaderMap head : Map<String, String>,@QueryMap map:Map<String,String>): Observable<ResEntity<List<MusicClassBean>>>


    @POST("account/signIn")
    @FormUrlEncoded
    fun getLogDate(@HeaderMap head : Map<String, String>,@FieldMap map:Map<String,String>): Observable<ResEntity<LogDateBean>>


}