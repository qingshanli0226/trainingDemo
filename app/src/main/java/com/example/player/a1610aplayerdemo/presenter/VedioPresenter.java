package com.example.player.a1610aplayerdemo.presenter;

import android.content.Context;
import com.example.player.a1610aplayerdemo.Server.AllServer;
import com.example.player.a1610aplayerdemo.common.VedioBean;
import com.example.player.a1610aplayerdemo.util.RetrofitHelper;
import com.example.player.a1610aplayerdemo.view.ViedioView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class VedioPresenter implements IVedioPresenter{
    ViedioView viedioView;

    public VedioPresenter(ViedioView viedioView) {
        this.viedioView = viedioView;
    }

    @Override
    public void getVidioData(String token, String viedioUrl, Context mContext) {
        RetrofitHelper instance = RetrofitHelper.getInstance(mContext);
        AllServer service = instance.getService();
        Observable<VedioBean> vedioInfo = service.getVedioInfo("BE46DFAA67FE0C41D3A03D5B1E087706", viedioUrl, "" + 0);
        vedioInfo.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VedioBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(VedioBean vedioBean) {
                        viedioView.SuccessCourse(vedioBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        viedioView.FailureCourse(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
