package com.example.player.a1610aplayerdemo.net;



import com.example.player.a1610aplayerdemo.fragment.member.Bean_Member;
import com.example.player.a1610aplayerdemo.fragment.selectclass.bean.GetHomeBean;
import com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.bean.ZlintroduceBean;
import com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.bean.ZlvideoBean;
import com.example.player.a1610aplayerdemo.activity.login.bean.CheckBean;
import com.example.player.a1610aplayerdemo.activity.login.bean.SignInBean;
import com.example.player.a1610aplayerdemo.token.UserBean;
import io.reactivex.Observable;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface RetrofitApiService {

  @POST("account/createNew")
  @FormUrlEncoded
  Observable<ResEntity<UserBean.DataBean>> getUserData(@HeaderMap Map<String,String> paramMap,@FieldMap Map<String,String> paramMap2);

  @GET("masterPackage/getMasterPackagelist")
  Observable<Bean_Member> getMenmberData(@HeaderMap Map<String,String> heandMap,@Query("minid")String mindid,@Query("size")String size);

  @GET(Contance.GET_HOME)
  Observable<ResEntity<GetHomeBean.DataBean>> getSelectData(@HeaderMap Map<String,String> headMap);

  @GET("zhuanLan/getdetail")
  Observable<ResEntity<ZlintroduceBean.DataBean>> getZlIntroDuce(@HeaderMap Map<String,String> headMap, @Query("id")String id);

  @GET("zhuanLan/getArticleList")  //zlId=20&page=1&size=20
  Observable<ResEntity<List<ZlvideoBean.DataBean>>> getVideoList(@HeaderMap Map<String,String> headMap, @QueryMap Map<String,String> queryMap);

  @POST("account/checkExists")
  @FormUrlEncoded
  Observable<CheckBean> getCheckUser (@HeaderMap Map<String,String> headMap,@FieldMap Map<String,String> paramMap);

  @POST("account/signIn")
  @FormUrlEncoded
  Observable<ResEntity<SignInBean.DataBean>> getSingIn (@HeaderMap Map<String,String> headMap, @FieldMap Map<String,String> paramMap);

}
