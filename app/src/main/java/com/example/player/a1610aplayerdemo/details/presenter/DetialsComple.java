package com.example.player.a1610aplayerdemo.details.presenter;

import com.example.player.a1610aplayerdemo.details.bean.DetailsBean;
import com.example.player.a1610aplayerdemo.net.CreatorRetorfitApi;
import com.example.player.a1610aplayerdemo.net.MyObServer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DetialsComple implements DetialsContract.IDetialsPresenter {
    private DetialsContract.IDetialsStatus iDetialsStatus;

    public DetialsComple(DetialsContract.IDetialsStatus iDetialsStatus) {
        this.iDetialsStatus = iDetialsStatus;
    }

    @Override
    public void getDetialsBean(String url) {
        CreatorRetorfitApi.getiRetrofitApiSerice().getDetailsBean(url)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new MyObServer<DetailsBean>() {
                    @Override
                    public void onNext(DetailsBean detailsBean) {
                        if(detailsBean != null){
                            iDetialsStatus.succssful(detailsBean);
                        }

                    }
                });
    }

    @Override
    public void dettach() {
        iDetialsStatus = null;
    }
}
