package com.example.player.a1610aplayerdemo.net

import com.example.player.a1610aplayerdemo.bean.VipDateBean
import com.example.player.a1610aplayerdemo.bean.XuanKeDateBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url



interface NetApiService {

    //http://api.immedc.com/restapi/loading/getHome
    @GET
    fun getXuanKeDate(@Url url: String): Observable<XuanKeDateBean>

    @GET
    fun getVipDate(@Url url: String): Observable<VipDateBean>
}