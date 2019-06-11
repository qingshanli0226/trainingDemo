package com.example.player.a1610aplayerdemo.ui.activity;

import android.os.Build;
import android.util.Log;

import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.FirstInBean;
import com.example.player.a1610aplayerdemo.utils.MVPObervice;
import com.example.player.a1610aplayerdemo.utils.PhoneUtils;
import com.example.player.a1610aplayerdemo.utils.RetrofitCreate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by Lmz on 2019/06/11
 *  引导页面获取数据
 */
public class ISplashPresenter implements IBasePresenter<FirstInBean>{

    private IBaseView iBaseView;
    @Override
    public void getData() {
        Map<String,String> map = new HashMap<>();
        map.put("device", Build.DEVICE);
        map.put("deviceKey", PhoneUtils.getDeviceKye());
        int sdkInt = Build.VERSION.SDK_INT;
        String sdk =""+sdkInt;
        map.put("sdkVersion",sdk);
        map.put("brand",Build.BOARD);
        map.put("product",Build.PRODUCT);
        RetrofitCreate.getNetApiService().FirstInAndGetToken(map)
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribeOn(Schedulers.io())
                                        .subscribe(new MVPObervice<FirstInBean>(){
                                            @Override
                                            public void onNext(FirstInBean firstInBean) {
                                                super.onNext(firstInBean);

                                                iBaseView.loadDataSuccess(firstInBean);
                                            }

                                            @Override
                                            public void onError(Throwable e) {
                                                super.onError(e);
                                                iBaseView.loadDataFailure(101,e.toString());
                                            }
                                        });
    }

    @Override
    public void attachView(IBaseView<FirstInBean> view) {
        iBaseView = view;
    }


    @Override
    public void detachView() {
            iBaseView =null;
    }
}
