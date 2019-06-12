package com.example.player.a1610aplayerdemo.net

import com.example.player.a1610aplayerdemo.bean.TokenDateBean
import com.example.player.a1610aplayerdemo.bean.VipDateBean
import com.example.player.a1610aplayerdemo.bean.XuanKeDateBean
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*
import java.util.HashMap


interface NetApiService {

    //http://api.immedc.com/restapi/loading/getHome


    @POST("account/createNew")
    @FormUrlEncoded
    fun getFirstInAndGetToken(@FieldMap map:Map<String,String>): Observable<ResEntity<TokenDateBean>>
//  POST http://api.immedc.com/restapi/account/createNew HTTP/1.1

    @GET
    fun getXuanKeDate( @Url url: String): Observable<ResEntity<XuanKeDateBean>>



    @GET
    fun getVipDate(@Url url: String): Observable<VipDateBean>


}