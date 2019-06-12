package com.example.player.a1610aplayerdemo.ui.fragment;

import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.base.MemberBean;
import com.example.player.a1610aplayerdemo.utils.MVPObervice;
import com.example.player.a1610aplayerdemo.utils.RetrofitCreate;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lmz on 2019/06/12
 * vip页面的presenter
 */
public class IVipPresenter implements IBasePresenter<MemberBean>{
    private IBaseView iBaseView;
    @Override
    public void getData() {

    }
    //因为需要 参数 所有扩展一个 网络获取类
    public void getVipData(int minid,int size){
        RetrofitCreate.getNetApiService().getMemberViewInfo(minid,size)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe(new MVPObervice<MemberBean>(){
                                @Override
                                public void onNext(MemberBean memberBean) {
                                    super.onNext(memberBean);
                                    iBaseView.loadDataSuccess(memberBean);
                                }

                                @Override
                                public void onError(Throwable e) {
                                    super.onError(e);
                                    iBaseView.loadDataFailure(101,e.toString());
                                }
                            });
    }

    @Override
    public void attachView(IBaseView<MemberBean> view) {
            iBaseView =view;
    }

    @Override
    public void detachView() {
        iBaseView =null;
    }
}
