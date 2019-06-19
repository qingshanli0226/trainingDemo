package com.example.player.a1610aplayerdemo.cateactivity.presenter;

import android.util.Log;
import android.view.View;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.cateactivity.Bean.MusicClassBean;
import com.example.player.a1610aplayerdemo.net.CreatorRetorfitApi;
import com.example.player.a1610aplayerdemo.net.MyObServer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MusicClassPresenter implements IBasePresenter<MusicClassBean.DataBean> {
    private IBaseView<MusicClassBean.DataBean> iBaseView;

    @Override
    public void getData() {
        CreatorRetorfitApi.getiRetrofitApiSerice().getMusicBean()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MusicClassBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MusicClassBean musicClassBean) {
                        if(musicClassBean.getData() != null){
                            Log.d("Mh",musicClassBean.getData().get(0).getShortName());
                            iBaseView.onLoadData(musicClassBean.getData());
                        }

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void attachView(IBaseView<MusicClassBean.DataBean> iBaseView) {
        this.iBaseView = iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView = null;
    }
}
