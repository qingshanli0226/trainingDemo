package com.example.player.a1610aplayerdemo.net;



import com.example.player.a1610aplayerdemo.fragment.member.Bean_Member;
import com.example.player.a1610aplayerdemo.fragment.selectclass.bean.GetHomeBean;
import com.example.player.a1610aplayerdemo.fragment.selectclass.zl.zlvideoactivity.bean.ZlintroduceBean;
import com.example.player.a1610aplayerdemo.token.UserBean;
import io.reactivex.Observable;
import retrofit2.http.*;

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

}
