package com.example.player.a1610aplayerdemo.fragment.MusicClass.present;

import com.example.player.a1610aplayerdemo.fragment.MusicClass.bean.MbBean;
import com.example.player.a1610aplayerdemo.net.RetrofitCreate;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MusicPresenterCompl implements MusicContact.MbPresent{
    MusicContact.MbView mbView;

    public MusicPresenterCompl(MusicContact.MbView mbView) {
        this.mbView = mbView;
    }
    @Override
    public void getData() {
        RetrofitCreate.getNetApiService().getMbBean("category/getPerfesional?pid=1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MbBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MbBean value) {
                        mbView.getSuccessData(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mbView.getFailData(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
