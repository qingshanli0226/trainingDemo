package com.example.player.a1610aplayerdemo.net

import com.example.player.a1610aplayerdemo.bean.XuanKeDateBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url



interface NetApiService {
    @GET
    fun getHomeDate(@Url url: String): Observable<XuanKeDateBean>
}