package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.home.mode.NetDataBean;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.*;

import java.util.HashMap;


public interface NetApiService {

    @GET("{path}")
     Observable<String> getData(@HeaderMap HashMap<String, String> headers, @Path("path") String path, @QueryMap HashMap<String, String> params);
}
