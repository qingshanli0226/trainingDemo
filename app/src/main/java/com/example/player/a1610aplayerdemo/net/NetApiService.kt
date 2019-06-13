package com.example.player.a1610aplayerdemo.net

import com.example.player.a1610aplayerdemo.Contants
import com.example.player.a1610aplayerdemo.bean.TokenDateBean
import com.example.player.a1610aplayerdemo.bean.TuiJianDateBean
import com.example.player.a1610aplayerdemo.bean.VipDateBean
import com.example.player.a1610aplayerdemo.bean.XuanKeDateBean
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*
import java.util.HashMap


interface NetApiService {


    @POST(Contants.CREATE_NEW)
    @FormUrlEncoded
    fun getFirstInAndGetToken(@HeaderMap head : Map<String, String>,@FieldMap map:Map<String,String>): Observable<ResEntity<TokenDateBean>>

    @GET(Contants.GET_HOME)
    fun getXuanKeDate(@HeaderMap head : Map<String, String>): Observable<ResEntity<XuanKeDateBean>>

    @GET(Contants.GET_VIP)
    fun getVipDate(@HeaderMap head : Map<String, String>): Observable<ResEntity<List<VipDateBean>>>

    @GET
    fun getTuiJianDate(@HeaderMap head : Map<String, String>,@Url s:String): Observable<ResEntity<TuiJianDateBean>>

}