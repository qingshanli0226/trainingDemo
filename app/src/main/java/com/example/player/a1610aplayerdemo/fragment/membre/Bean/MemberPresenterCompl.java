package com.example.player.a1610aplayerdemo.fragment.membre.Bean;

import com.example.player.a1610aplayerdemo.net.NetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreate;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

public class MemberPresenterCompl implements MemberPresenter.IMenberPresenter{
    MemberPresenter.IMemberView iMemberView;

    public MemberPresenterCompl(MemberPresenter.IMemberView iMemberView) {
        this.iMemberView = iMemberView;
    }

    @Override
    public void getData() {
        RetrofitCreate.getNetApiService().getMemberData("masterPackage/getMasterPackagelist?minid=0&size=20")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
//                .map(new NetFunction<ResEntity<MenmberBean>,MenmberBean>())
                .subscribe(new Observer<MenmberBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MenmberBean value) {
                        iMemberView.getSuccessData(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                            iMemberView.getFailData(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getDeView() {
        iMemberView=null;
    }
}
