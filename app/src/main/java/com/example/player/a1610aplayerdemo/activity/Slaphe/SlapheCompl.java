package com.example.player.a1610aplayerdemo.activity.Slaphe;

import android.os.Build;
import android.util.Log;
import com.example.player.a1610aplayerdemo.net.NetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreate;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SlapheCompl implements SlaphePresenter.ISlaphePresenter{
    private SlaphePresenter.ISlapheView iSlapheView;

    public SlapheCompl(SlaphePresenter.ISlapheView iSlapheView) {
        this.iSlapheView = iSlapheView;
    }

    @Override
    public void getData() {
        Map<String,String> map=new HashMap<>();
        map.put("device", Build.DEVICE);
        map.put("deviceKey",PhoneUtils.getDeviceKey());
        int sdkInt=Build.VERSION.SDK_INT;
        String sdk=""+sdkInt;
        map.put("sdkVersion",sdk);
        map.put("brand",Build.BOARD);
        map.put("product",Build.PRODUCT);
        RetrofitCreate.getNetApiService().FirstInAndGetToken(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(ResponseBody value) {
                        try {
                            String string = value.string();
                            iSlapheView.getSuccessData(string);
//                            SharePresenterUtils.saveToke();
                            Log.d("ZYS", "onNext:Responbody "+string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
//                        iSlapheView.getFailData(101,e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void DeView() {
        iSlapheView=null;
    }
}
