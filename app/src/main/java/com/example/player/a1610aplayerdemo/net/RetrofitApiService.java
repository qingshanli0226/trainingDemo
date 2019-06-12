package com.example.player.a1610aplayerdemo.net;



import com.example.player.a1610aplayerdemo.fragment.member.Bean_Member;
import com.example.player.a1610aplayerdemo.fragment.selectclass.bean.GetHomeBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitApiService {
  @GET
  Observable<Bean_Member> getMenmberData(@Url String url);

  @GET
  Observable<GetHomeBean> getSelectData(@Url String url);

}
