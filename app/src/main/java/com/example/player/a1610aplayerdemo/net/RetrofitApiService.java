package com.example.player.a1610aplayerdemo.net;



import com.example.player.a1610aplayerdemo.fragment.member.Bean_Member;
import com.example.player.a1610aplayerdemo.fragment.selectclass.bean.GetHomeBean;
import com.example.player.a1610aplayerdemo.token.UserBean;
import io.reactivex.Observable;
import retrofit2.http.*;

import java.util.Map;

public interface RetrofitApiService {

  @POST("account/createNew")
  @FormUrlEncoded
  Observable<ResEntity<UserBean>> getUserData(@HeaderMap Map<String,String> paramMap);

  @GET
  Observable<Bean_Member> getMenmberData(@Url String url);

  @GET
  Observable<GetHomeBean> getSelectData(@Url String url);

}
