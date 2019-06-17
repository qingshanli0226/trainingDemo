package com.example.player.a1610aplayerdemo.cateactivity.presenter;

import com.example.player.a1610aplayerdemo.cateactivity.Bean.CateGoryBean;
import com.example.player.a1610aplayerdemo.net.CreatorRetorfitApi;
import com.example.player.a1610aplayerdemo.net.MyObServer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CateGoryComple implements CateGoryContract.ILoadCateGoryBean {
    private CateGoryContract.ICateGoryState iCateGoryState;

    public CateGoryComple(CateGoryContract.ICateGoryState iCateGoryState) {
        this.iCateGoryState = iCateGoryState;
    }

    @Override
    public void getCateGoryBean(String url) {
        CreatorRetorfitApi.getiRetrofitApiSerice().getCoryBean(url)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new MyObServer<CateGoryBean>() {
                    @Override
                    public void onNext(CateGoryBean bean) {
                        if(bean.getData() != null){
                            iCateGoryState.succssful(bean.getData());
                        }

                    }
                });
    }
}
