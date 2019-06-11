package com.example.player.a1610aplayerdemo.ui.vippresenter;

import com.example.player.a1610aplayerdemo.bean.VipDateBean;
import com.example.player.a1610aplayerdemo.bean.XuanKeDateBean;
import com.example.player.a1610aplayerdemo.net.MVPObserver;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.ui.xuankepresenter.XuanKeInterface;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class VipPresenterCompl implements VipInterface.IvipPresenter{

    private VipInterface.VipView vipView;

    public VipPresenterCompl(VipInterface.VipView vipView) {
        this.vipView = vipView;
    }

    @Override
    public void getVipData() {
//http://api.immedc.com/restapi/
        RetrofitCreator.getApiService().getVipDate("http://api.immedc.com/restapi/masterPackage/getMasterPackagelist?minid=0&size=20")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        vipView.showLoading();
                    }
                })

                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        vipView.hideLoading();
                    }
                })
                .subscribe(new MVPObserver<VipDateBean>(){

                    @Override
                    public void onNext(VipDateBean vipDateBean) {
                        super.onNext(vipDateBean);

                        vipView.onGetDataSuccess(vipDateBean);

                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        e.printStackTrace();
                    }
                });

    }

    @Override
    public void detachView() {
        vipView = null;
    }
}
