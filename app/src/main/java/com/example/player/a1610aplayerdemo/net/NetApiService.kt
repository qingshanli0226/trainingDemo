package com.example.player.a1610aplayerdemo.net

import com.example.player.a1610aplayerdemo.bean.TokenDateBean
import com.example.player.a1610aplayerdemo.bean.VipDateBean
import com.example.player.a1610aplayerdemo.bean.XuanKeDateBean
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.QueryMap
import retrofit2.http.Url
import retrofit2.http.HeaderMap
import java.util.HashMap


interface NetApiService {

    //http://api.immedc.com/restapi/loading/getHome

    @POST
    fun getFirstInAndGetToken(@QueryMap map: Map<String,String>): Observable<ResEntity<TokenDateBean>>


    @GET
    fun getXuanKeDate( @Url url: String): Observable<ResEntity<XuanKeDateBean>>



    @GET
    fun getVipDate(@Url url: String): Observable<VipDateBean>


}