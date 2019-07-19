package com.example.player.a1610aplayerdemo.net

import com.example.player.a1610aplayerdemo.Contants
import com.example.player.a1610aplayerdemo.base.RegCheckBean
import com.example.player.a1610aplayerdemo.bean.*
import io.reactivex.Observable
import retrofit2.http.*
import java.util.HashMap
import retrofit2.http.QueryMap
import retrofit2.http.HeaderMap




interface NetApiService {


    @GET("{path1}/{path2}")
    fun getData(@HeaderMap headers: HashMap<String, String>, @Path("path1") path1: String, @Path("path2") path2: String,@QueryMap params: HashMap<String, String>): Observable<String>


    @POST("{path1}/{path2}")
    @FormUrlEncoded
    fun getLogin(@HeaderMap headers: HashMap<String, String>, @Path("path1") path1: String, @Path("path2") path2: String,@FieldMap map:Map<String,String>): Observable<String>



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


    @GET("zhuanLan/getdetail")
    fun getZhuanLanDate(@HeaderMap head : Map<String, String>,@QueryMap map:Map<String,String>): Observable<ResEntity<ZhuanLanDateBean>>



    @POST("account/signIn")
    @FormUrlEncoded
    fun getLogDate(@HeaderMap head : Map<String, String>,@FieldMap map:Map<String,String>): Observable<ResEntity<LogDateBean>>

    @POST("account/signOut")
    @FormUrlEncoded
    fun getLogOut(@HeaderMap head : Map<String, String>,@FieldMap map:Map<String,String>): Observable<ResEntity<LoginOutBean>>

    @POST("getAppVersion")
    @FormUrlEncoded
    fun getVersionUpdate(@HeaderMap head : Map<String, String>,@FieldMap map:Map<String,String>): Observable<ResEntity<UpdateVersionBean>>

    @POST("getAppVersion")
    @FormUrlEncoded
    fun getVersionUpdate1(@HeaderMap head : Map<String, String>,@FieldMap map:Map<String,String>): Observable<UpdateVersionBean>


    //检测是否已注册
    @POST("account/checkExists")
    @FormUrlEncoded
    fun getRegCheck(@HeaderMap head : Map<String, String>,@FieldMap map:Map<String,String>): Observable<RegCheckBean>
    //获取验证码
    @POST("account/getValidCode")
    @FormUrlEncoded
    fun getRegCodeDate(@HeaderMap head : Map<String, String>,@FieldMap map:Map<String,String>): Observable<RegCodeBean>

    //注册---点击下一步
    @POST("account/checkValidCode")
    @FormUrlEncoded
    fun getNextDate(@HeaderMap head : Map<String, String>,@FieldMap map:Map<String,String>): Observable<NextTypeBean>

    //注册并登录
    @POST("account/signUp")
    @FormUrlEncoded
    fun getRegDataPwd(@HeaderMap head : Map<String, String>,@FieldMap map:Map<String,String>): Observable<ResEntity<AddPwdDataBean>>


}