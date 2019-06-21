package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.utils.ErrorUtils;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MvpObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T value) {

    }

    @Override
    public void onError(Throwable e) {
            ErrorUtils.handleError(e);
    }

    @Override
    public void onComplete() {

    }
}
